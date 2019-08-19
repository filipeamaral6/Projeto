package com.polarising.bootsecurity.controller;

import java.util.HashMap;

import javax.validation.Valid;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.soap.account.example.xmlns._1564670090695.AccountService;
import com.polarising.bootsecurity.soap.account.tibco.schemas.account.OutputAccount;
import com.polarising.bootsecurity.soap.account.tibco.schemas.getbyid.GetById;
import com.polarising.bootsecurity.soap.transaction.example.xmlns._1564747039855.TransactionService;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction.InputTransaction;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction.OutputTransaction;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TransactionController {

	
	// Add Transaction
		@PostMapping("transaction/add")
		public Object AddTransaction(@Valid @RequestBody InputTransaction inputTransaction, BindingResult result) {
			
			HashMap<String, String> error = new HashMap<>();
			boolean NoMoneyError = false;
			
			if (Double.parseDouble(GetById.getBalance()) - Double.parseDouble(inputTransaction.getValue()) < 0) {

				inputTransaction.;

				TransactionService transactionService = new TransactionService();

				OutputTransaction message = transactionService.getPortTypeTransactionEndpoint1().operation(inputTransaction);
				return message;

			}

			HashMap<String, String> error = new HashMap<>();
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());

			return error;
		}

}
