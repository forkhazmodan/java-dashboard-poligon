package com.chmax.polygon.proivder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderProvider {

    public static PasswordEncoder getEncoder() {
        return (PasswordEncoder) ApplicationContextProvider.getApplicationContext().getBean("passwordEncoder");
    }
}
