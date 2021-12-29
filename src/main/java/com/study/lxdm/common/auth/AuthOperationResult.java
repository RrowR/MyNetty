package com.study.lxdm.common.auth;

import com.study.lxdm.common.OperationResult;
import lombok.Data;

@Data
public class AuthOperationResult extends OperationResult {

    private final boolean passAuth;

}
