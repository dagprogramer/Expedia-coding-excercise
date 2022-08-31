package ar.com.dag.fligth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class FligthApplication {
	public static void main(String[] args) {
		SpringApplication.run(FligthApplication.class, args);
	}
}
