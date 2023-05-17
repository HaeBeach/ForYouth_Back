package com.haebeach.foryouth;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEncryptableProperties
@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class ForyouthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForyouthApplication.class, args);
	}

}
