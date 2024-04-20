package com.bankapplication.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.DTO.AccountDTO;
import com.bankapplication.Mapper.AccountMapper;
import com.bankapplication.Repo.AccountRepo;
import com.bankapplication.entity.Account;

@Service
public class AccountServiceImpl  implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;

	
	//Create account
	@Override
	public AccountDTO CreateAccount(AccountDTO accountDTO) {
	         
		     Account account=AccountMapper.mapToAccount(accountDTO);
		           Account saveAccount= accountRepo.save(account);		     
		     
		return AccountMapper.mapToAccountDto(saveAccount);
	}


	//get Single By id
	@Override
	public AccountDTO GetAccountById(Long id) {
		                  
		           Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist !!"));
		return AccountMapper.mapToAccountDto(account);
	}


	//Get All Account
	@Override
	public List<AccountDTO> GetAllAccount() {
		               
		
		                 List<Account> allaccount= accountRepo.findAll();
		return allaccount.stream().map((accounts)->AccountMapper.mapToAccountDto(accounts)).collect(Collectors.toList());
	}


	@Override
	public String DeleteById(Long id) {
		
		 accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist !!"));
		 accountRepo.deleteById(id);
		return "Delete Success Account";
		
	}

//deposit
	@Override
	public AccountDTO Deposit(Long id, double amount) {
	
		Account account= accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist !!"));
		                  double total= account.getBalance()+ amount;
		                  account.setBalance(total);
		                            Account saveAccount= accountRepo.save(account);
		
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}


	@Override
	public AccountDTO WIthDraw(Long id, double amount) {
		
		
		Account account= accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist !!"));
		
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient Client Ammount..");
			
		}
		
		
        double total= account.getBalance()-amount;
        account.setBalance(total);
                  Account saveAccount= accountRepo.save(account);

		return AccountMapper.mapToAccountDto(saveAccount);
	}


	


	

}
