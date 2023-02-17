package com.haebeach.foryouth.common.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    private static final String JASYPT_KEY = "FOR_YOUTH";
    private static final String ALGORITHM = "PBEWithMD5AndDES";

    @Bean("jasyptStringEncryptor")
    public StandardPBEStringEncryptor standardPBEStringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();
        config.setAlgorithm(ALGORITHM);
        config.setPassword(JASYPT_KEY);
        encryptor.setConfig(config);
        return encryptor;
    }

    public static void main(String[] args) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm(JasyptConfig.ALGORITHM);
        encryptor.setPassword(JasyptConfig.JASYPT_KEY);

        String test = encryptor.encrypt("QAhz0fVQ0EaHGSFwGEwVJSdulqxl0mvQ9kOoUrcZMUpvsWVTIHRFhAwsxzqCmKJwxjHtWEXwiAlCVTeP0KNgJQ%3D%3D");

        System.out.println("test : " + test);
//        System.out.println("test : " + encryptor.decrypt(""));
    }

}
