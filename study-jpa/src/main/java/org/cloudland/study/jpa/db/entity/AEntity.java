package org.cloudland.study.jpa.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Study.DB.JPA.AEntity")
@Table(name = "T_A")
@Data
@NoArgsConstructor
public class AEntity extends AbstractBasicEntity {

    @Id
    @Column(name = "INDETIFIER_NO")
    private String indetifierNo;

    @Column(name = "A_TEXT")
    private String text;

    @Column(name = "A_NUMBER")
    private int number;

    @Column(name = "A_DECIMAL")
    private BigDecimal decimal;

    public AEntity(String indetifierNo, String text, int number, BigDecimal decimal) {
        this.indetifierNo = indetifierNo;
        this.text = text;
        this.number = number;
        this.decimal = decimal;
    }

}
