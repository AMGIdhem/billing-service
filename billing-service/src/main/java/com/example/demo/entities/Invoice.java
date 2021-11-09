package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Invoice {
	@Id
	private String id;
	private Date date;
	private BigDecimal amount;
	private String customerID;
	@Transient
	Customer customer;
}
