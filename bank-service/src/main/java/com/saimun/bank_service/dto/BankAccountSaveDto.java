package com.saimun.bank_service.dto;

import lombok.Data;

@Data
public class BankAccountSaveDto {
	private String accountHolder;
	private Double balance;
}
