package com.bankapplication.Mapper;

import com.bankapplication.DTO.AccountDTO;
import com.bankapplication.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDTO accountDTO) {
		   
		Account account=new Account();
		account.setId(accountDTO.getId());
		account.setAccountHolderName(accountDTO.getAccountHolderName());
		account.setBalance(accountDTO.getBalance());
		
		return account;
		
	}
	
	public static AccountDTO mapToAccountDto(Account account) {
		   
		AccountDTO accountdto=new AccountDTO();
		accountdto.setId(account.getId());
		accountdto.setAccountHolderName(account.getAccountHolderName());
		accountdto.setBalance(account.getBalance());
		
		return accountdto;
		
	}
	

}
