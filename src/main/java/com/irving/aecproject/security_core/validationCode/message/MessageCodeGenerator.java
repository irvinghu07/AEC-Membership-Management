package com.irving.aecproject.security_core.validationCode.message;

import com.irving.aecproject.security_core.properties.SecurityProperties;
import com.irving.aecproject.security_core.validationCode.ValidateCode;
import com.irving.aecproject.security_core.validationCode.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component("messageCodeGenerator")
public class MessageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generateCode(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties
                .getValidateCodeProperties().getMessageCodeProperties().getLength());
        return new ValidateCode(code, securityProperties
                .getValidateCodeProperties().getMessageCodeProperties().getExpireIn());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
