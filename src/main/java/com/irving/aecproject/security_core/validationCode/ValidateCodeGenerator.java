package com.irving.aecproject.security_core.validationCode;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ValidateCode generateCode(ServletWebRequest request);
}
