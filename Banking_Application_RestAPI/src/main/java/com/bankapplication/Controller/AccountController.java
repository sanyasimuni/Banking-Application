package com.bankapplication.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapplication.DTO.AccountDTO;
import com.bankapplication.Service.AccountService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/account")

@Tag(name =" Account Controller",description = "To Perform Some Operation")
public class AccountController {
	@Autowired
	private AccountService service;
	
	
	//Create Account
	@Operation(
			summary = "Post Operation on Account Details",
			description = "It is used to Save The Account Details"
			)
	
	
	@PostMapping()
	public ResponseEntity<AccountDTO>CreatebankAccount(@RequestBody AccountDTO accountDTO){
		               
		            AccountDTO dto=service.CreateAccount(accountDTO);
		            return new ResponseEntity<AccountDTO>(dto,HttpStatus.CREATED);
	}

	//GetSingle Acount By Id
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO>GetSingleAccountByid(@PathVariable Long id) {
		              AccountDTO dd=service.GetAccountById(id);
		              
		              return new ResponseEntity<AccountDTO>(dd,HttpStatus.OK);
		
	}
	
	
	//get List Of Account 
	@GetMapping()
	public ResponseEntity<List<AccountDTO>>GetAllAccount() {
		             List<AccountDTO> allaccount=service.GetAllAccount();
		              
		              return new ResponseEntity<>(allaccount,HttpStatus.OK);
		
	}
	
	//delete By Account
	
	@Hidden
	@DeleteMapping("/{id}")
	public ResponseEntity<String>DeleteAccount(@PathVariable Long id){ 
		            String del=service.DeleteById(id);
		            return new ResponseEntity<String>(del,HttpStatus.OK);
		
	}
	
	
	//deposit
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO>Deposit(@PathVariable Long id,@RequestBody Map<String,Double>request){
		       Double amount=request.get("amount");
		                AccountDTO dto= service.Deposit(id,amount);
		                
    return new ResponseEntity<AccountDTO>(dto,HttpStatus.OK);
		                                     
		
	}
	
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO>WithDraw(@PathVariable Long id,@RequestBody Map<String,Double>request){
		       Double amount=request.get("amount");
		                AccountDTO obj= service.WIthDraw(id, amount);
		                
    return new ResponseEntity<AccountDTO>(obj,HttpStatus.OK);
		                                     
		
	}
	
}
