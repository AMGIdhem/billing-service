package com.example.demo;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.demo.dto.InvoiceRequestDTO;
import com.example.demo.services.InvoiceService;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(InvoiceService invoiceService) {
		return args -> {
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(76000), "C01"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(76000), "C01"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(76000), "C02"));
		};
	}

}
