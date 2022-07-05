package eapli.base.reportmanagement.auxiliary;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.repositories.AnswerRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Luís Araújo
 */
public class ReportPercentagesCalculator {
    /**
     * Instance of AnswerRepository
     */
    private final AnswerRepository answerRepository;
    /**
     * Instance of SurveyRepository
     */
    private final SurveyRepository surveyRepository;
    /**
     * int variables for the: size of the survey (amount of users the survey was distributed to), size of the free
     * text response and number of responses obtained
     */
    int universeSizeOfSurvey, sizeOfResponseFT, numberOfResponsesObtained;
    /**
     * Variable for the percentage of responses obtained
     */
    double percentageOfResponsesObtained;
    /**
     * Hash Maps to calculate the frequency of a response for numeric, single choice, single choice with input value,
     * multiple choice, multiple choice with input value, sorting and scaling questions
     */
    HashMap<String, Integer> frequencyMapNumeric = new HashMap<String, Integer>();
    HashMap<String, Integer> frequencyMapSC = new HashMap<String, Integer>();
    HashMap<String, Integer> frequencyMapSCWithIV = new HashMap<String, Integer>();
    HashMap<String, Integer> frequencyMapMC = new HashMap<String, Integer>();
    HashMap<String, Integer> frequencyMapMCWithIV = new HashMap<String, Integer>();
    HashMap<String, Integer> frequencyMapSorting = new HashMap<String, Integer>();
    HashMap<String, Integer> frequencyMapScaling = new HashMap<String, Integer>();
    /**
     * Lists to save the data for numeric, single choice, single choice with input value, multiple choice, multiple
     * choice with input value, sorting and scaling questions after calculating their frequencies
     */
    List<String> listWithTheDataForNumeric = new ArrayList<>();
    List<String> listWithTheDataForSC = new ArrayList<>();
    List<String> listWithTheDataForSCWithIV = new ArrayList<>();
    List<String> listWithTheDataForMC = new ArrayList<>();
    List<String> listWithTheDataForMCWithIV = new ArrayList<>();
    List<String> listWithTheDataForSorting = new ArrayList<>();
    List<String> listWithTheDataForScaling = new ArrayList<>();
    /**
     * List to save all the data from the report
     */
    List<String> allDataToAdd = new ArrayList<>();
    /**
     * Strings to save all the individual data. Then, all data is saved in "allData"
     */
    String allData, auxData, dataForNumeric, dataForSC, dataForSCWithIV, dataForMC, dataForMCWithIV, dataForFT, dataForSorting, dataForScaling;

    /**
     * Constructor to initialize the repositories
     */
    public ReportPercentagesCalculator() {
        answerRepository = PersistenceContext.repositories().answers();
        surveyRepository = PersistenceContext.repositories().surveys();
    }

    /**
     * Method that redirects to the method that calculates the percentages by verifying the question type
     *
     * @param surveyCode
     * @param questionList
     */
    public void calculatePercentages(SurveyCode surveyCode, List<Question> questionList) {
        for (Question question : questionList) {
            switch (question.type().toString()) {
                case "FREE_TEXT":
                    numberOfCharsInResponseOfFreeText(surveyCode, question);
                    break;
                case "NUMERIC":
                    percentagesOfResponsesForNumeric(surveyCode, question);
                    break;
                case "SINGLE_CHOICE":
                    percentagesOfResponsesForSingleChoice(surveyCode, question);
                    break;
                case "SINGLE_CHOICE_WITH_INPUT_VALUE":
                    percentagesOfResponsesForSingleChoiceWithInputValue(surveyCode, question);
                    break;
                case "MULTIPLE_CHOICE":
                    percentagesOfResponsesForMultipleChoice(surveyCode, question);
                    break;
                case "MULTIPLE_CHOICE_WITH_INPUT_VALUE":
                    percentagesOfResponsesForMultipleChoiceWithInputValue(surveyCode, question);
                    break;
                case "SORTING":
                    percentagesOfResponsesForSorting(surveyCode, question);
                    break;
                case "SCALING":
                    percentagesOfResponsesForScaling(surveyCode, question);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Method that fills the hash map with the frequency of a certain response in the list
     *
     * @param frequencyMap
     * @param answerList
     */
    private void fillHashMapWithFrequency(HashMap<String, Integer> frequencyMap, List<Answer> answerList) {
        for (Answer a : answerList) {
            String response = a.options().toString();
            if (frequencyMap.containsKey(response)) {
                frequencyMap.put(response, frequencyMap.get(response) + 1);
            } else {
                frequencyMap.put(response, 1);
            }

        }
    }

    /**
     * Method that adds the data of the hash map in the list
     *
     * @param frequencyMap
     * @param list
     * @param answerList
     */
    private void addDataToTheList(HashMap<String, Integer> frequencyMap, List<String> list, List<Answer> answerList) {
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            double value = (double) entry.getValue() / answerList.size();
            DecimalFormat df = new DecimalFormat("##.##%");
            String formattedPercent = df.format(value);
            list.add(entry.getKey() + "->" + formattedPercent + "%");
        }
    }

    /**
     * Method that gets the amount of users the survey was distributed to and assigns the value to the
     * universeSizeOfSurvey variable
     *
     * @param surveyCode
     */
    public void universeSizeOfSurvey(SurveyCode surveyCode) {
        this.universeSizeOfSurvey = surveyRepository.universeSizeOfSurvey(surveyCode);
    }

    /**
     * Method that returns the number of answers obtained in a certain survey
     *
     * @param surveyCode
     * @return number of answers obtained in a certain survey
     */
    public int numberOfResponsesObtained(SurveyCode surveyCode) {
        this.numberOfResponsesObtained = answerRepository.numberOfResponsesObtained(surveyCode);
        return numberOfResponsesObtained;
    }

    /**
     * Method that gets the percentage of responses obtained by dividing the number of responses obtained by
     * the number of questions a survey has and assigns the value to the percentageOfResponsesObtained variable
     *
     * @param surveyCode
     */
    public void percentageOfResponsesObtained(SurveyCode surveyCode) {
        int percentage;

        percentage = (numberOfResponsesObtained(surveyCode) / (universeSizeOfSurvey * surveyRepository.numberOfQuestions(surveyCode))) * 100;

        this.percentageOfResponsesObtained = percentage;
    }

    /**
     * Method that calculates the number of chars in a free text question and saves the information
     * in the string
     *
     * @param surveyCode
     * @param question
     */
    public void numberOfCharsInResponseOfFreeText(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfFT(surveyCode, question);

        for (Answer a : answerList) {
            for (String response : a.options()) {
                this.sizeOfResponseFT += response.length();
            }
        }

        dataForFT = "Number Of Chars In Response Of Free Text: " + sizeOfResponseFT +
                "\n-------------------------------------------------------------------------";

        allDataToAdd.add(dataForFT);
    }

    /**
     * Method that calculates the percentage of responses in a numeric question and saves the information
     * in the string
     *
     * @param surveyCode
     * @param question
     */
    public void percentagesOfResponsesForNumeric(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfNumeric(surveyCode, question);

        frequencyMapNumeric.clear();
        fillHashMapWithFrequency(frequencyMapNumeric, answerList);
        listWithTheDataForNumeric.clear();
        addDataToTheList(frequencyMapNumeric, listWithTheDataForNumeric, answerList);

        if (listWithTheDataForNumeric.isEmpty()) {
            this.dataForNumeric = "% of responses for Numeric " + question.toString() + " no numeric answers\n\n-------------------------------------------------------------------------";
        } else {
            this.dataForNumeric = "% of responses for Numeric " + question.toString() + "\n" + StringUtils.join(listWithTheDataForNumeric, "\n\n") +
                    "\n-------------------------------------------------------------------------";
        }

        allDataToAdd.add(dataForNumeric);
    }

    /**
     * Method that calculates the percentage of responses in a single choice question and saves the information
     * in the string
     *
     * @param surveyCode
     * @param question
     */
    public void percentagesOfResponsesForSingleChoice(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfSC(surveyCode, question);

        frequencyMapSC.clear();
        fillHashMapWithFrequency(frequencyMapSC, answerList);
        listWithTheDataForSC.clear();
        addDataToTheList(frequencyMapSC, listWithTheDataForSC, answerList);

        if (listWithTheDataForSC.isEmpty()) {
            this.dataForSC = "% of responses for Single Choice " + question.toString() + " no Single Choice answers\n\n-------------------------------------------------------------------------";
        } else {
            this.dataForSC = "% of responses for Single Choice " + question.toString() + "\n" + StringUtils.join(listWithTheDataForSC, "\n\n") +
                    "\n-------------------------------------------------------------------------";
        }

        allDataToAdd.add(dataForSC);
    }

    /**
     * Method that calculates the percentage of responses in a single choice with input value question and saves
     * the information in the string
     *
     * @param surveyCode
     * @param question
     */
    public void percentagesOfResponsesForSingleChoiceWithInputValue(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfSCIV(surveyCode, question);

        frequencyMapSCWithIV.clear();
        fillHashMapWithFrequency(frequencyMapSCWithIV, answerList);
        listWithTheDataForSCWithIV.clear();
        addDataToTheList(frequencyMapSCWithIV, listWithTheDataForSCWithIV, answerList);

        if (listWithTheDataForSCWithIV.isEmpty()) {
            this.dataForSCWithIV = "% of responses for Single Choice W/Input Value " + question.toString() + " no Single Choice W/Input Value answers\n\n-------------------------------------------------------------------------";
        } else {
            this.dataForSCWithIV = "% of responses for Single Choice W/Input Value " + question.toString() + "\n" + StringUtils.join(listWithTheDataForSCWithIV, "\n\n") +
                    "\n-------------------------------------------------------------------------";
        }

        allDataToAdd.add(dataForSCWithIV);
    }

    /**
     * Method that calculates the percentage of responses in a multiple choice question and saves the information
     * in the string
     *
     * @param surveyCode
     * @param question
     */
    public void percentagesOfResponsesForMultipleChoice(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfMC(surveyCode, question);

        frequencyMapMC.clear();
        fillHashMapWithFrequency(frequencyMapMC, answerList);
        listWithTheDataForMC.clear();
        addDataToTheList(frequencyMapMC, listWithTheDataForMC, answerList);

        if (listWithTheDataForMC.isEmpty()) {
            this.dataForMC = "% of responses for Multiple Choice " + question.toString() + " no Multiple Choice answers\n\n-------------------------------------------------------------------------";
        } else {
            this.dataForMC = "% of responses for Multiple Choice " + question.toString() + "\n" + StringUtils.join(listWithTheDataForMC, "\n\n") +
                    "\n-------------------------------------------------------------------------";
        }

        allDataToAdd.add(dataForMC);
    }

    /**
     * Method that calculates the percentage of responses in a multiple choice with input value question and saves
     * the information in the string
     *
     * @param surveyCode
     * @param question
     */
    public void percentagesOfResponsesForMultipleChoiceWithInputValue(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfMCIV(surveyCode, question);

        frequencyMapMCWithIV.clear();
        fillHashMapWithFrequency(frequencyMapMCWithIV, answerList);
        listWithTheDataForMCWithIV.clear();
        addDataToTheList(frequencyMapMCWithIV, listWithTheDataForMCWithIV, answerList);

        if (listWithTheDataForMCWithIV.isEmpty()) {
            this.dataForMCWithIV = "% of responses for Multiple Choice W/Input Value " + question.toString() + " no Multiple Choice W/Input Value answers\n\n-------------------------------------------------------------------------";
        } else {
            this.dataForMCWithIV = "% of responses for Multiple Choice W/Input Value " + question.toString() + "\n" + StringUtils.join(listWithTheDataForMCWithIV, "\n\n") +
                    "\n-------------------------------------------------------------------------";
        }

        allDataToAdd.add(dataForMCWithIV);
    }

    /**
     * Method that calculates the percentage of responses in a sorting question and saves the information
     * in the string
     *
     * @param surveyCode
     * @param question
     */
    public void percentagesOfResponsesForSorting(SurveyCode surveyCode, Question question) {
        try {
            List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfSorting(surveyCode, question);
            List<String> options = new ArrayList<>();
            int size = answerList.get(0).options().size();
            int counter = 0;
            frequencyMapSorting.clear();
            listWithTheDataForSorting.clear();

            for (int i = 0; i < size; i++) {
                options.add(answerList.get(0).options().get(i).toString());
            }

            for (int i = 0; i < size; i++) {
                int x = 0;
                while (x < size) {
                    String option = options.get(x);
                    for (Answer answer : answerList) {
                        if (option.equals(answer.options().get(i))) {
                            counter++;
                        }
                    }
                    frequencyMapSorting.put(options.get(x), counter);
                    counter = 0;
                    x++;
                }
                addDataToTheList(frequencyMapSorting, listWithTheDataForSorting, answerList);
            }

            if (listWithTheDataForSorting.isEmpty()) {
                this.dataForSorting = "% of responses for Sorting " + question.toString() + " no Sorting answers\n\n-------------------------------------------------------------------------";
            }

            List<List<String>> finalList = new ArrayList<>();

            int auxCounter = 0;
            counter = 1;
            int auxSize = size;
            for (int i = 0; i < listWithTheDataForSorting.size(); i += size) {
                List<String> aux = new ArrayList<>();
                aux.add(counter + " (st/nd/rd/th) place " + listWithTheDataForSorting.subList(i, auxSize));
                finalList.add(auxCounter, aux);
                auxCounter++;
                counter++;
                auxSize += size;
            }

            this.dataForSorting = "% of responses for Sorting " + question.toString() + "\n" + StringUtils.join(finalList, "\n\n") +
                    "\n-------------------------------------------------------------------------";

            allDataToAdd.add(dataForSorting);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that calculates the percentage of responses in a scaling question and saves the information
     * in the string
     *
     * @param surveyCode
     * @param question
     */
    public void percentagesOfResponsesForScaling(SurveyCode surveyCode, Question question) {
        List<Answer> answerList = answerRepository.findAnswersWithQuestionsOfScaling(surveyCode, question);

        frequencyMapScaling.clear();
        fillHashMapWithFrequency(frequencyMapScaling, answerList);
        listWithTheDataForScaling.clear();
        addDataToTheList(frequencyMapScaling, listWithTheDataForScaling, answerList);

        if (listWithTheDataForScaling.isEmpty()) {
            this.dataForScaling = "% of responses for Scaling " + question.toString() + " no Scaling answers\n\n-------------------------------------------------------------------------";
        } else {
            this.dataForScaling = "% of responses for Scaling " + question.toString() + "\n" + StringUtils.join(listWithTheDataForScaling, "\n\n") +
                    "\n-------------------------------------------------------------------------";
        }

        allDataToAdd.add(dataForScaling);
    }

    /**
     * Method that writes all the data in the final string
     */
    public void writeAllDataOfTheReport() {

        auxData = StringUtils.join(allDataToAdd, "\n");

        this.allData = "REPORT ANSWERS INFORMATION\n" +
                "----------------------------------------------------------------------------------------\n" +
                "Size Of Survey: " + universeSizeOfSurvey + "\n" + "Number Of Responses Obtained: " + numberOfResponsesObtained +
                "\n" + "% Of Responses Obtained: " + percentageOfResponsesObtained + "\n\n" + auxData;
    }

    @Override
    public String toString() {
        return allData;
    }
}
