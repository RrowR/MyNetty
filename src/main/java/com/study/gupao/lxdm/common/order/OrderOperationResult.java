package com.study.gupao.lxdm.common.order;

import com.study.gupao.lxdm.common.OperationResult;
import lombok.Data;

@Data
public class OrderOperationResult extends OperationResult {

    private final int tableId;
    private final String dish;
    private final boolean complete;

}
