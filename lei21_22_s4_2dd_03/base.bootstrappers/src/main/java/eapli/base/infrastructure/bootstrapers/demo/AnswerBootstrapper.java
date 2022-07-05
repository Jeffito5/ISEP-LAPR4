package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.surveymanagement.builders.AnswerBuilder;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.framework.actions.Action;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class AnswerBootstrapper implements Action {

    @SneakyThrows
    @Override
    public boolean execute() {
        JpaRepository<Survey, Long> surveyRepo = new JpaRepository<Survey, Long>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        JpaRepository<Customer, Long> customerRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        JpaRepository<Answer, Long> answerRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };

        List<Survey> surveys = surveyRepo.findAll();
        List<Customer> customers = customerRepo.findAll();
        AnswerBuilder builder = new AnswerBuilder(false);

        //survey 1
        Survey survey = surveys.get(0);
        //survey 2
        Survey survey1 = surveys.get(1);
        //questionnaire 1
        Questionnaire questionnaire = survey.questionnaire();
        //questionnaire 2
        Questionnaire questionnaire1 = survey1.questionnaire();

        //section 1
        List<Section> sections = questionnaire.sections();
        Section section = sections.get(0);
        //section 2
        List<Section> sections1 = questionnaire1.sections();
        Section section1 = sections1.get(0);

        List<Question> questions = section.questions();
        Question question1Q1 = questions.get(0);
        Question question2Q1 = questions.get(1);
        Question question3Q1 = questions.get(2);
        Question question4Q1 = questions.get(3);
        Question question5Q1 = questions.get(4);
        Question question6Q1 = questions.get(5);
        Question question7Q1 = questions.get(6);
        Question question8Q1 = questions.get(7);
        Question question9Q1 = questions.get(8);
        Question question10Q1 = questions.get(9);
        Question question11Q1 = questions.get(10);

        List<Question> questions1 = section1.questions();
        Question question9 = questions1.get(0);
        Question question10 = questions1.get(1);
        Question question11 = questions1.get(2);
        Question question12 = questions1.get(3);
        Question question13 = questions1.get(4);
        Question question14 = questions1.get(5);
        Question question15 = questions1.get(6);

        // answers for questionnaire 1 and section 1
        List<String> options1Q1 = new ArrayList<>();
        List<String> options2Q1 = new ArrayList<>();
        List<String> options3Q1 = new ArrayList<>();
        List<String> options4Q1 = new ArrayList<>();
        List<String> options5Q1 = new ArrayList<>();
        List<String> options6Q1 = new ArrayList<>();
        List<String> options7Q1 = new ArrayList<>();
        List<String> options8Q1 = new ArrayList<>();
        List<String> options9Q1 = new ArrayList<>();
        List<String> options10Q1 = new ArrayList<>();
        List<String> options11Q1 = new ArrayList<>();
        options1Q1.add("a)");
        options2Q1.add("a)");
        options2Q1.add("c)");
        options3Q1.add("1");
        options4Q1.add("b)");
        options5Q1.add("a)");
        options5Q1.add("b)");
        options6Q1.add("Nothing, this is the best company ever created.");
        options7Q1.add("c)");
        options7Q1.add("a)");
        options7Q1.add("b)");
        options8Q1.add("a)");
        options9Q1.add("b)");
        options10Q1.add("c)");
        options11Q1.add("a)");
        options11Q1.add("b)");
        options11Q1.add("c)");
        // answers for questionnaire 1 and section 1
        List<String> options12Q1 = new ArrayList<>();
        List<String> options13Q1 = new ArrayList<>();
        List<String> options14Q1 = new ArrayList<>();
        List<String> options15Q1 = new ArrayList<>();
        List<String> options16Q1 = new ArrayList<>();
        List<String> options17Q1 = new ArrayList<>();
        List<String> options18Q1 = new ArrayList<>();
        List<String> options19Q1 = new ArrayList<>();
        List<String> options20Q1 = new ArrayList<>();
        List<String> options21Q1 = new ArrayList<>();
        List<String> options22Q1 = new ArrayList<>();
        options12Q1.add("b)");
        options13Q1.add("a)");
        options13Q1.add("b)");
        options14Q1.add("1");
        options15Q1.add("a)");
        options16Q1.add("a)");
        options16Q1.add("c)");
        options17Q1.add("Nothing, this is the best company ever created.");
        options18Q1.add("b)");
        options18Q1.add("a)");
        options18Q1.add("c)");
        options19Q1.add("c)");
        options20Q1.add("a)");
        options21Q1.add("b)");
        options22Q1.add("a)");
        options22Q1.add("b)");
        options22Q1.add("c)");

        // answers for questionnaire 2 and section 2
        List<String> options9 = new ArrayList<>();
        List<String> options10 = new ArrayList<>();
        List<String> options11 = new ArrayList<>();
        List<String> options12 = new ArrayList<>();
        List<String> options13 = new ArrayList<>();
        List<String> options14 = new ArrayList<>();
        List<String> options15 = new ArrayList<>();
        options9.add("2");
        options10.add("a)");
        options11.add("b)");
        options12.add("Condoms");
        options13.add("b)");
        options13.add("a)");
        options13.add("c)");
        options14.add("1");
        options15.add("b)");
        // answers for questionnaire 2 and section 2
        List<String> options16 = new ArrayList<>();
        List<String> options17 = new ArrayList<>();
        List<String> options18 = new ArrayList<>();
        List<String> options19 = new ArrayList<>();
        List<String> options20 = new ArrayList<>();
        List<String> options21 = new ArrayList<>();
        List<String> options22 = new ArrayList<>();
        options16.add("1");
        options17.add("b)");
        options18.add("c)");
        options19.add("Condoms");
        options20.add("b)");
        options20.add("c)");
        options20.add("a)");
        options21.add("1");
        options22.add("a)");
        int size = 0;

        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question1Q1)
                        .withText(options1Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question1Q1)
                            .withText(options12Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question2Q1)
                        .withText(options2Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question2Q1)
                            .withText(options13Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question3Q1)
                        .withText(options3Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question3Q1)
                            .withText(options14Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question4Q1)
                        .withText(options4Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question4Q1)
                            .withText(options15Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question5Q1)
                        .withText(options5Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question5Q1)
                            .withText(options16Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question6Q1)
                        .withText(options6Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question6Q1)
                            .withText(options17Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question7Q1)
                        .withText(options7Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question7Q1)
                            .withText(options18Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question8Q1)
                        .withText(options8Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question8Q1)
                            .withText(options19Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question9Q1)
                        .withText(options9Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question9Q1)
                            .withText(options20Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question10Q1)
                        .withText(options10Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question10Q1)
                            .withText(options21Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey)
                        .withSection(section)
                        .withQuestion(question11Q1)
                        .withText(options11Q1)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey)
                            .withSection(section)
                            .withQuestion(question11Q1)
                            .withText(options22Q1)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey1)
                        .withSection(section1)
                        .withQuestion(question9)
                        .withText(options9)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey1)
                            .withSection(section1)
                            .withQuestion(question9)
                            .withText(options16)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey1)
                        .withSection(section1)
                        .withQuestion(question10)
                        .withText(options10)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {

                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey1)
                            .withSection(section1)
                            .withQuestion(question10)
                            .withText(options17)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey1)
                        .withSection(section1)
                        .withQuestion(question11)
                        .withText(options11)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey1)
                            .withSection(section1)
                            .withQuestion(question11)
                            .withText(options18)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey1)
                        .withSection(section1)
                        .withQuestion(question12)
                        .withText(options12)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey1)
                            .withSection(section1)
                            .withQuestion(question12)
                            .withText(options19)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey1)
                        .withSection(section1)
                        .withQuestion(question13)
                        .withText(options13)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {

                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey1)
                            .withSection(section1)
                            .withQuestion(question13)
                            .withText(options20)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey1)
                        .withSection(section1)
                        .withQuestion(question14)
                        .withText(options14)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey1)
                            .withSection(section1)
                            .withQuestion(question14)
                            .withText(options21)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }

        size = 0;
        for (Customer customer : customers) {
            if (size <= customers.size() / 2 && !customer.email().equals("marcoRamos@gmail.com")) {
                Answer answer = builder.withCustomer(customer)
                        .withSurvey(survey1)
                        .withSection(section1)
                        .withQuestion(question15)
                        .withText(options15)
                        .build();
                answerRepo.add(answer);
                size++;
            } else {
                if (!customer.email().equals("marcoRamos@gmail.com")) {
                    Answer answer = builder.withCustomer(customer)
                            .withSurvey(survey1)
                            .withSection(section1)
                            .withQuestion(question15)
                            .withText(options22)
                            .build();
                    answerRepo.add(answer);
                }
            }
        }
        return true;
    }
}
