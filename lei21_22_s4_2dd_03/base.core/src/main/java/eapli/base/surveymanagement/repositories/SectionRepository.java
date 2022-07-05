package eapli.base.surveymanagement.repositories;

import eapli.base.surveymanagement.domain.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 * <p>
 Class that stores (in memory) the current state of sections. It's not being stored in the Data Base because, if the questionnaire creating is canceled, this repository is reset.
 <p>
 Also is reset every time a Questionnaire is successfully created.
 *
 */
public class SectionRepository {

    public static List<Section> sections = new ArrayList<>();

    /**Adds a Section to the current List
     *
     * @param section Section to be added.
     * @throws IllegalArgumentException Thrown if there is already a section with such code in the current list.
     */
    public static void add(Section section) throws IllegalArgumentException{
        if (!containsSectionId(section.sectionId()))
            sections.add(section);
        else
            throw new IllegalArgumentException("ERROR: Section with code " + section.sectionId() + "already defined in scope!");
    }

    /**Checks if a Section is in the current List
     *
     * @param sectionId Section ID to be used in the search
     * @return TRUE if it contains the Question, FALSE otherwise
     */
    public static boolean containsSectionId(String sectionId){
        for (Section section : sections){
            if (section.sectionId().equals(sectionId))
                return true;
        }
        return false;
    }

    /**
     * Clears the Section List
     */
    public static void clear(){
        sections = new ArrayList<>();
    }

    /**Searches a specific Section through its ID
     *
     * @param sectionId Section ID to be used in the search
     * @return Section instance if found, NULL otherwise
     */
    public static Section getSection(String sectionId){
        for (Section section : sections){
            if (section.sectionId().equals(sectionId))
                return section;
        }
        return null;
    }
}
