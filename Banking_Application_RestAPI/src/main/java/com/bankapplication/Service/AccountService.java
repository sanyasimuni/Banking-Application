package com.bankapplication.Service;

import java.util.List;

import com.bankapplication.DTO.AccountDTO;

public interface AccountService {
	
	//create Account
	AccountDTO CreateAccount(AccountDTO accountDTO);
	
	//get Single By id
	AccountDTO GetAccountById(Long id);
	
	//get All account 
	List<AccountDTO>GetAllAccount();
	//Delete By id
	
	String DeleteById(Long id);
	//Deposit Account
	
	AccountDTO Deposit(Long id,double amount);
	
	//withDraw
	
	AccountDTO WIthDraw(Long id,double amount);
	

}
