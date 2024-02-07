package com.study.gupao.lxdm.common.auth;

import com.study.gupao.lxdm.common.OperationResult;
import lombok.Data;

@Data
public class AuthOperationResult extends OperationResult {

    private final boolean passAuth;

}
