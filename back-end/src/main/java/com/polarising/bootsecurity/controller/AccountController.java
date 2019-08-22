package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.services.Utils;
import com.polarising.bootsecurity.soap.account.example.xmlns._1564670090695.AccountService;
import com.polarising.bootsecurity.soap.account.tibco.schemas.account.InputAccount;
import com.polarising.bootsecurity.soap.account.tibco.schemas.account.OutputAccount;
import com.polarising.bootsecurity.soap.account.tibco.schemas.account.Root;
import com.polarising.bootsecurity.soap.account.tibco.schemas.getbyiban.GetByIban;
import com.polarising.bootsecurity.soap.account.tibco.schemas.getbyid.GetById;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AccountController {

	@Autowired
	Utils utils;

	// Add Account
	@PostMapping("accounts/add")
	public ResponseEntity<Object> AddAccount(@Valid @RequestBody InputAccount inputAccount, BindingResult result) {

		Long accountNumber = (System.currentTimeMillis() / 100);
		HashMap<String, String> error = new HashMap<>();
		boolean minBalanceError = false;

		if (Double.parseDouble(inputAccount.getBalance()) < 500) {
			error.put("field", "balance");
			error.put("message", "Valor mínimo de depósitio de abertura de conta inválido (500€)");
			minBalanceError = true;
		}

		if (!result.hasErrors() && !minBalanceError) {

			inputAccount.setAccountNumber(accountNumber.toString());
			inputAccount.setIban(utils.generateIban("PT50", 4000, accountNumber));
			AccountService accountService = new AccountService();

			OutputAccount message = accountService.getPortTypeCreateAccountEndpoint1().operation(inputAccount);
			return new ResponseEntity<Object>(message, HttpStatus.OK);

		}

		if (result.hasErrors()) {
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());

		}
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

	// Get Accounts
	@GetMapping("accounts")
	public ResponseEntity<List<Object>> getAccounts() {

		AccountService accountService = new AccountService();
		Root getAccounts = accountService.getPortTypeGetAllAccountsEndpoint1().operation();

		List<Object> message = new ArrayList<Object>();

		if (!getAccounts.getInputAccount().isEmpty()) {
			for (InputAccount account : getAccounts.getInputAccount()) {
				message.add(account);
			}
		} else {
			message.add(getAccounts.getOutputAccount().get(0));
		}

		return new ResponseEntity<List<Object>>(message, HttpStatus.OK);
	}

	// Get Account by Id
	@GetMapping("accounts/id/{id}")
	public ResponseEntity<Object> getAccountById(@PathVariable String id) {

		AccountService accountService = new AccountService();
		GetById getById = new GetById();
		getById.setId(id);

		Root getAccountById = accountService.getPortTypeGetAccountByIdEndpoint1().operationGetAccountById(getById);

		if (getAccountById.getInputAccount().isEmpty()) {
			return new ResponseEntity<Object>(getAccountById.getOutputAccount(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(getAccountById.getInputAccount(), HttpStatus.OK);
		}
	}

	// Get Account By IBAN
	@GetMapping("accounts/iban/{iban}")
	public ResponseEntity<Object> getAccountByIban(@PathVariable String iban) {
		AccountService accountService = new AccountService();
		GetByIban getByIban = new GetByIban();
		getByIban.setIban(iban);

		Root getAccountByIban = accountService.getPortTypeGetAccountByIbanEndpoint1().operation(getByIban);

		if (getAccountByIban.getInputAccount().isEmpty()) {
			return new ResponseEntity<Object>(getAccountByIban.getOutputAccount(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(getAccountByIban.getInputAccount(), HttpStatus.OK);
		}

	}

	// Update Account
	@PutMapping("accounts/update")
	public ResponseEntity<Object> updateAccounts(@Valid @RequestBody InputAccount inputAccount, BindingResult result) {

		if (!result.hasErrors()) {

			AccountService accountService = new AccountService();

			OutputAccount message = accountService.getPortTypeUpdateAccountEndpoint1().operation(inputAccount);

			return new ResponseEntity<Object>(message, HttpStatus.OK);

		}

		HashMap<String, String> error = new HashMap<>();
		error.put("field", result.getFieldError().getField());
		error.put("message", result.getFieldError().getDefaultMessage());

		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}
}