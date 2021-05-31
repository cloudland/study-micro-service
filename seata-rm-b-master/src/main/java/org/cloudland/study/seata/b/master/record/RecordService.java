package org.cloudland.study.seata.b.master.record;

import org.cloudland.study.seata.b.master.record.bean.State;

public interface RecordService {

    State handler(String id);

}
