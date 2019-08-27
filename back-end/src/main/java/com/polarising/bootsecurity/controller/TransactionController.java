package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.soap.account.example.xmlns._1564670090695.AccountService;
import com.polarising.bootsecurity.soap.account.tibco.schemas.account.InputAccount;
import com.polarising.bootsecurity.soap.account.tibco.schemas.account.Root;
import com.polarising.bootsecurity.soap.account.tibco.schemas.getbyiban.GetByIban;
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

				TransactionService transactionService = new TransactionService();
				OutputTransaction message = transactionService.getPortTypeTransferEndpoint1().writeTransfer(inputTransfer);
				
				if(message.getMessage().startsWith("Erro")) {
					return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<Object>(message, HttpStatus.OK);

			}
			
			if (result.hasErrors()) {
				error.put("field", result.getFieldError().getField());
				error.put("message", result.getFieldError().getDefaultMessage());
	
			}
			
			if (getAccountByIban.getInputAccount().isEmpty()) {
				return new ResponseEntity<Object> (getAccountByIban.getOutputAccount(), HttpStatus.BAD_REQUEST);
			} 			
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

		}
		
		// Add Withdraw
		@PostMapping("withdraw/add")
		public ResponseEntity<Object> AddWithdraw(@Valid @RequestBody InputWithdraw inputWithdraw, BindingResult result) {
			
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

				TransactionService transactionService = new TransactionService();
				OutputWithdraw message = transactionService.getPortTypeWithdrawEndpoint1().writeWithdraw(inputWithdraw);
				
				if(message.getMessage().startsWith("Erro")) {
					return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<Object>(message, HttpStatus.OK);

			}
			
			if (result.hasErrors()) {
				error.put("field", result.getFieldError().getField());
				error.put("message", result.getFieldError().getDefaultMessage());
	
			}
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

		}
		
		// Add Payment
		@PostMapping("payment/add")
		public ResponseEntity<Object>  AddPayment(@Valid @RequestBody InputPayment inputPayment, BindingResult result) {
			
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

				TransactionService transactionService = new TransactionService();
				OutputPayment message = transactionService.getPortTypePaymentEndpoint1().writePayment(inputPayment);
				
				if(message.getMessage().startsWith("Erro")) {
					return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<Object>(message, HttpStatus.OK);

			}
			
			if (result.hasErrors()) {
				error.put("field", result.getFieldError().getField());
				error.put("message", result.getFieldError().getDefaultMessage());
	
			}
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

		}
		
		// Add Deposit
		@PostMapping("deposit/add")
		public ResponseEntity<Object> AddDeposit(@Valid @RequestBody InputDeposit inputDeposit, BindingResult result) {
			
			HashMap<String, String> error = new HashMap<>();
			
		
			
			if (!result.hasErrors()) {

				TransactionService transactionService = new TransactionService();
				OutputDeposit message = transactionService.getPortTypeDepositEndpoint1().writeDeposit(inputDeposit);
				
				if(message.getMessage().startsWith("Erro")) {
					return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<Object>(message, HttpStatus.OK);

			}
			
			if (result.hasErrors()) {
				error.put("field", result.getFieldError().getField());
				error.put("message", result.getFieldError().getDefaultMessage());
	
			}
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

		}

		// Get Transaction by Id
		@GetMapping("transaction/id/{id}")
		public ResponseEntity<List<Object>> getTransactionById(@PathVariable String id) {
			
			TransactionService transactionService = new TransactionService();
			GetById getById = new GetById();
			getById.setId(id);
			
			List<Object> objects = new ArrayList<Object>();

			com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction.RootTransaction getTransactionById = transactionService.getPortTypeTransactionByIdEndpoint1().operation(getById);

			objects.add(0, getTransactionById.getInputTransaction());
			objects.add(1, getTransactionById.getPaymentTransaction());
			objects.add(2, getTransactionById.getDepositTransaction());
			objects.add(3, getTransactionById.getTransferTransaction());
			objects.add(4, getTransactionById.getWithdrawTransaction());
			objects.add(5, getTransactionById.getOutputTransaction());
			
			if (getTransactionById.getInputTransaction().isEmpty()) {
				return new ResponseEntity<List<Object>>(objects, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<List<Object>>(objects, HttpStatus.OK);
			}
		}

		// Get Transaction by IBAN
		@GetMapping("transaction/accountIBAN/{accountIBAN}")
		public ResponseEntity<Object> getTransactionByIBAN(@PathVariable String accountIBAN) {

			TransactionService transactionService = new TransactionService();
			GetByIbanTransaction getByIban = new GetByIbanTransaction();
			getByIban.setIban(accountIBAN);

			RootTransaction getTransactionsByIban = transactionService.getPortTypeGetTransactionsByIbanEndpoint1().operation(getByIban);

			if (getTransactionsByIban.getInputTransaction().isEmpty()) {
				return new ResponseEntity<Object>(getTransactionsByIban.getOutputTransaction(), HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Object> (getTransactionsByIban.getInputTransaction(), HttpStatus.OK);
			}
		}
		
		// Get Transactions
		@GetMapping("transactions")
		public ResponseEntity<List<Object>> getTransactions() {

			TransactionService transactionService = new TransactionService();
			RootTransaction getTransactions = transactionService.getPortTypeGetAllTransactionsEndpoint1().operation();

			List<Object> message = new ArrayList<Object>();

			if (!getTransactions.getInputTransaction().isEmpty()) {
				for (InputTransaction transaction : getTransactions.getInputTransaction()) {
					message.add(transaction);
				}
			} else {
				message.add(getTransactions.getOutputTransaction().get(0));
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<List<Object>>(message, HttpStatus.OK);
		}

}
