package com.study.gupao.lxdm.common.keepalive;


import com.study.gupao.lxdm.common.OperationResult;
import lombok.Data;

@Data
public class KeepaliveOperationResult extends OperationResult {

    private final long time;

}
