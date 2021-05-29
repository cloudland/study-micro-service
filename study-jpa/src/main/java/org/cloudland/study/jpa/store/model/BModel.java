package org.cloudland.study.jpa.store.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class BModel extends AbstractParentModel {

    private String id;

    private String text;

    private int number;

    private BigDecimal decimal;

    public BModel(String id, String text, int number, BigDecimal decimal, Date createdTime, Date updatedTime, Date loseTime, Integer version) {
        super(createdTime, updatedTime, loseTime, version);
        this.id = id;
        this.text = text;
        this.number = number;
        this.decimal = decimal;
    }

}
