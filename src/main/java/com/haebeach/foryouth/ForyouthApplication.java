package com.haebeach.foryouth;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class ForyouthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForyouthApplication.class, args);
	}

}
