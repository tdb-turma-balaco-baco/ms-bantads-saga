package br.ufpr.tads.msbantadssaga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsBantadsSagaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBantadsSagaApplication.class, args);
	}

}
