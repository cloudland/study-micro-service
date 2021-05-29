package org.cloudland.study.jpa.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Study.DB.JPA.BEntity")
@Table(name = "T_B")
@Data
@NoArgsConstructor
public class BEntity extends AbstractBasicEntity {

    @Id
    @Column(name = "INDETIFIER_NO")
    private String indetifierNo;

    @Column(name = "B_TEXT")
    private String text;

    @Column(name = "B_NUMBER")
    private int number;

    @Column(name = "B_DECIMAL")
    private BigDecimal decimal;

    public BEntity(String indetifierNo, String text, int number, BigDecimal decimal) {
        this.indetifierNo = indetifierNo;
        this.text = text;
        this.number = number;
        this.decimal = decimal;
    }

}
