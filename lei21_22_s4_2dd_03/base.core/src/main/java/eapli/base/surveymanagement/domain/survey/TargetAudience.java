package eapli.base.surveymanagement.domain.survey;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

@Embeddable
public class TargetAudience implements ValueObject, Serializable {

    @Enumerated(EnumType.STRING)
    private TargetType targetType;      //The type of List to show in the UI. Either with Products, Brands, Categories etc

    @ElementCollection
    private List<String> codes;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstDate", column = @Column(name = "target_firstDate")),
            @AttributeOverride(name = "secondDate", column = @Column(name = "target_secondDate")),
    })
    private TimeInterval dayCount;               //The number os days to search for. E.g. People who bought socks in the last 30 days.





    public TimeInterval getDayCount() {
        return dayCount;
    }

    public void setDayCount(TimeInterval dayCount) {
        this.dayCount = dayCount;
    }

    //Required by JPA
    protected TargetAudience(){}

    public TargetAudience(TargetType targetType, List<String> codes,TimeInterval dayCount){
        this.targetType = targetType;
        this.codes = codes;
        this.dayCount = dayCount;
    }

    public List<String> codes(){
        return new ArrayList<>(codes);
    }

    public TargetType targetType(){return this.targetType;}

}

;