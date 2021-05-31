package org.cloudland.study.seata.a.master.information.bean;

import org.cloudland.study.seata.a.master.Submit;

import java.math.BigDecimal;

public interface Information extends Submit {

    void setText(String text);

    String getText();

    void setNumber(Integer number);

    Integer getNumber();

    void setArray(String... value);

    String[] getArray();

    Attach addAttach(String text, BigDecimal... decimal);

    Attach getAttach();

}
