package org.cloudland.study.seata.a.master.information.support.bean;

import org.cloudland.study.seata.a.master.SubmitBean;
import org.cloudland.study.seata.a.master.information.bean.Attach;
import org.cloudland.study.seata.a.master.information.bean.Information;

import java.math.BigDecimal;

public class InformationBean extends SubmitBean implements Information {

    @Override
    public void setText(String text) {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void setNumber(Integer number) {

    }

    @Override
    public Integer getNumber() {
        return null;
    }

    @Override
    public void setArray(String... value) {

    }

    @Override
    public String[] getArray() {
        return new String[0];
    }

    @Override
    public Attach addAttach(String text, BigDecimal... decimal) {
        return null;
    }

    @Override
    public Attach getAttach() {
        return null;
    }

    @Override
    protected void validate() {

    }

    @Override
    protected String doSubmit() {
        return null;
    }

}
