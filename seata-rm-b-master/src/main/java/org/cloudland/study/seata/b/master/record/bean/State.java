package org.cloudland.study.seata.b.master.record.bean;

public interface State {

    void write();

    void readOnly();

}
