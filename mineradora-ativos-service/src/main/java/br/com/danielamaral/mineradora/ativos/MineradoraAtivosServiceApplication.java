package br.com.danielamaral.mineradora.ativos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MineradoraAtivosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MineradoraAtivosServiceApplication.class, args);
	}

	
}
