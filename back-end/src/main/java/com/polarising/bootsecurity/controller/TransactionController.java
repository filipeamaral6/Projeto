package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.model.Account;
import com.polarising.bootsecurity.soap.account.example.xmlns._1564670090695.AccountService;
import com.polarising.bootsecurity.soap.account.tibco.schemas.account.InputAccount;
import com.polarising.bootsecurity.soap.transaction.example.xmlns._1564747039855.TransactionService;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.deposit.InputDeposit;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.deposit.OutputDeposit;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.getbyiban.GetByIbanTransaction;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.getbyid.GetById;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.payment.InputPayment;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.payment.OutputPayment;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction.InputTransaction;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction.OutputTransaction;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction.RootTransaction;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.transfer.InputTransfer;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.withdraw.InputWithdraw;
import com.polarising.bootsecurity.soap.transaction.tibco.schemas.withdraw.OutputWithdraw;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TransactionController {

	// Add Transfer
	@PostMapping("transfer/add")
	public ResponseEntity<Object> AddTransfer(@Valid @RequestBody InputTransfer inputTransfer, BindingResult result) {
			

			HashMap<String, String> error = new HashMap<>();
			boolean noMoneyError = false;
			
			AccountService accountService = new AccountService();
			GetByIban getByIban = new GetByIban();
			getByIban.setIban(inputTransfer.getAccountIban());

			Root getAccountByIban = accountService.getPortTypeGetAccountByIbanEndpoint1().operation(getByIban);

			InputAccount currentAccount = getAccountByIban.getInputAccount().get(0);
			
			
			
			if (Double.parseDouble(currentAccount.getBalance()) - Double.parseDouble(inputTransfer.getValue()) < 0) {
				error.put("field", "balance");
				error.put("message", "Não tem saldo suficiente para fazer executar esta operação!");
				noMoneyError = true;
			}
			
			if (!result.hasErrors() && !noMoneyError) {

		AccountController accountController = new AccountController();
		HashMap<String, String> error = new HashMap<>();
		boolean noMoneyError = false;
		Account currentAccount = (Account) accountController.getAccountByIban(inputTransfer.getAccountIban()).getBody();

			}
			
			if (result.hasErrors()) {
				error.put("field", result.getFieldError().getField());
				error.put("message", result.getFieldError().getDefaultMessage());
	
			}
			
			if (getAccountByIban.getInputAccount().isEmpty()) {
				return getAccountByIban.getOutputAccount();
			} 			
			return error;

		if (!result.hasErrors() && !noMoneyError) {

			TransactionService transactionService = new TransactionService();
			OutputTransaction message = transactionService.getPortTypeTransferEndpoint1().writeTransfer(inputTransfer);
			return new ResponseEntity<Object>(message, HttpStatus.OK);

		}
		
		// Add Withdraw
		@PostMapping("withdraw/add")
		public Object AddWithdraw(@Valid @RequestBody InputWithdraw inputWithdraw, BindingResult result) {
			
			HashMap<String, String> error = new HashMap<>();
			boolean noMoneyError = false;
			
			AccountService accountService = new AccountService();
			GetByIban getByIban = new GetByIban();
			getByIban.setIban(inputWithdraw.getAccountIban());

			Root getAccountByIban = accountService.getPortTypeGetAccountByIbanEndpoint1().operation(getByIban);

			InputAccount currentAccount = getAccountByIban.getInputAccount().get(0);
			
			
			
			if (Double.parseDouble(currentAccount.getBalance()) - Double.parseDouble(inputWithdraw.getValue()) < 0) {
				error.put("field", "balance");
				error.put("message", "Não tem saldo suficiente para fazer executar esta operação");
				noMoneyError = true;
			}
			
			if (!result.hasErrors() && !noMoneyError) {

		if (result.hasErrors()) {
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());

		}
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

	// Add Withdraw
	@PostMapping("withdraw/add")
	public ResponseEntity<Object> AddWithdraw(@Valid @RequestBody InputWithdraw inputWithdraw, BindingResult result) {

		AccountController accountController = new AccountController();
		HashMap<String, String> error = new HashMap<>();
		boolean noMoneyError = false;
		Account currentAccount = (Account) accountController.getAccountByIban(inputWithdraw.getAccountIban()).getBody();

		if (currentAccount.getBalance() - Double.parseDouble(inputWithdraw.getValue()) < 0) {
			error.put("field", "balance");
			error.put("message", "Não tem saldo suficiente para fazer executar esta operação");
			noMoneyError = true;
		}
		
		// Add Payment
		@PostMapping("payment/add")
		public Object AddPayment(@Valid @RequestBody InputPayment inputPayment, BindingResult result) {
			
			HashMap<String, String> error = new HashMap<>();
			boolean noMoneyError = false;
			
			AccountService accountService = new AccountService();
			GetByIban getByIban = new GetByIban();
			getByIban.setIban(inputPayment.getAccountIban());

			Root getAccountByIban = accountService.getPortTypeGetAccountByIbanEndpoint1().operation(getByIban);

			InputAccount currentAccount = getAccountByIban.getInputAccount().get(0);
			
			
			
			if (Double.parseDouble(currentAccount.getBalance()) - Double.parseDouble(inputPayment.getValue()) < 0) {
				error.put("field", "balance");
				error.put("message", "Não tem saldo suficiente para fazer executar esta operação");
				noMoneyError = true;
			}
			if (!result.hasErrors() && !noMoneyError) {

		if (!result.hasErrors() && !noMoneyError) {

			TransactionService transactionService = new TransactionService();
			OutputWithdraw message = transactionService.getPortTypeWithdrawEndpoint1().writeWithdraw(inputWithdraw);
			return new ResponseEntity<Object>(message, HttpStatus.OK);

		}
		
		// Add Deposit
		@PostMapping("deposit/add")
		public Object AddDeposit(@Valid @RequestBody InputDeposit inputDeposit, BindingResult result) {
			
			HashMap<String, String> error = new HashMap<>();
			
		
			
			if (!result.hasErrors()) {

		if (result.hasErrors()) {
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());

		}
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

	// Add Payment
	@PostMapping("payment/add")
	public ResponseEntity<Object> AddPayment(@Valid @RequestBody InputPayment inputPayment, BindingResult result) {

		AccountController accountController = new AccountController();
		HashMap<String, String> error = new HashMap<>();
		boolean noMoneyError = false;
		Account currentAccount = (Account) accountController.getAccountByIban(inputPayment.getAccountIban()).getBody();

		if (currentAccount.getBalance() - Double.parseDouble(inputPayment.getValue()) < 0) {
			error.put("field", "balance");
			error.put("message", "Não tem saldo suficiente para fazer executar esta operação");
			noMoneyError = true;
		}

		if (!result.hasErrors() && !noMoneyError) {

			TransactionService transactionService = new TransactionService();
			OutputPayment message = transactionService.getPortTypePaymentEndpoint1().writePayment(inputPayment);
			return new ResponseEntity<Object>(message, HttpStatus.OK);

			com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction.RootTransaction getTransactionById = transactionService.getPortTypeTransactionByIdEndpoint1().operation(getById);

		if (result.hasErrors()) {
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());

		}
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

		// Get Transaction by IBAN
		@GetMapping("transaction/accountIBAN/{accountIBAN}")
		public Object getTransactionByIBAN(@PathVariable String accountIBAN) {

	// Add Deposit
	@PostMapping("transfer/add")
	public ResponseEntity<Object> AddDeposit(@Valid @RequestBody InputDeposit inputDeposit, BindingResult result) {

		HashMap<String, String> error = new HashMap<>();

		if (!result.hasErrors()) {

			TransactionService transactionService = new TransactionService();
			GetByIbanTransaction getByIban = new GetByIbanTransaction();
			getByIban.setIban(accountIBAN);

			RootTransaction getTransactionsByIban = transactionService.getPortTypeGetTransactionsByIbanEndpoint1().operation(getByIban);

		if (result.hasErrors()) {
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());

		}
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

			TransactionService transactionService = new TransactionService();
			RootTransaction getTransactions = transactionService.getPortTypeGetAllTransactionsEndpoint1().operation();

	// Get Transaction by Id
	@GetMapping("transaction/id/{id}")
	public ResponseEntity<Object> getTransactionById(@PathVariable String id) {

		TransactionService transactionService = new TransactionService();
		GetById getById = new GetById();
		getById.setId(id);

		Root getTransactionById = transactionService.getPortTypeTransactionByIdEndpoint1().operation(getById);

		if (getTransactionById.getInputTransaction().isEmpty()) {
			return new ResponseEntity<Object>(getTransactionById.getOutputTransaction(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(getTransactionById.getInputTransaction(), HttpStatus.OK);
		}
	}

	// Get Transaction by IBAN
	@GetMapping("transaction/id/{id}")
	public ResponseEntity<Object> getTransactionByIBAN(@PathVariable String accountIBAN) {

		TransactionService transactionService = new TransactionService();
		GetByIban getByIban = new GetByIban();
		getByIban.setIban(accountIBAN);

		Root getTransactionsByIban = transactionService.getPortTypeGetTransactionsByIbanEndpoint1()
				.operation(getByIban);

		if (getTransactionsByIban.getInputTransaction().isEmpty()) {
			return new ResponseEntity<Object>(getTransactionsByIban.getOutputTransaction(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(getTransactionsByIban.getInputTransaction(), HttpStatus.OK);
		}
	}

	// Get Transactions
	@GetMapping("transactions")
	public ResponseEntity<List<Object>> getAccounts() {

		TransactionService transactionService = new TransactionService();
		Root getTransactions = transactionService.getPortTypeGetAllTransactionsEndpoint1().operation();

		List<Object> message = new ArrayList<Object>();

		if (!getTransactions.getInputTransaction().isEmpty()) {
			for (InputTransaction transaction : getTransactions.getInputTransaction()) {
				message.add(transaction);
			}
		} else {
			message.add(getTransactions.getOutputTransaction().get(0));
		}

		return new ResponseEntity<List<Object>>(message, HttpStatus.OK);
	}

}
