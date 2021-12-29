package com.study.lxdm.common.keepalive;


import com.study.lxdm.common.OperationResult;
import lombok.Data;

@Data
public class KeepaliveOperationResult extends OperationResult {

    private final long time;

}
