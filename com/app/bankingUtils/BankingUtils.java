package com.app.bankingUtils;
//import com.app.bankingValidation.*;
import static com.app.bankingValidation.ValidationRules.checkDuplicateAccountNumber;

import static com.app.bankingValidation.ValidationRules.validateAccountOpeningBalance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;
import com.app.banking.BankingException;

public class BankingUtils {
	public static List<BankAccount> populateBankAccount() throws BankingException
	{
		List<BankAccount> accs=new ArrayList<>();

//		use like this if not importing statically ValidationRules.checkDuplicateAccountNumber package
//		accs.add(new BankAccount(ValidationRules.checkDuplicateAccountNumber(accs,20002), "Jai" ,LocalDate.parse("2022-01-11"),35444,AccountType.SAVINGS));

//		accs.add(new BankAccount(checkDuplicateAccountNumber(accs,20002), "Jai" ,LocalDate.parse("2022-01-11"),validateAccountOpeningBalance(2000,AccountType.SAVINGS),AccountType.SAVINGS));
		try {
			accs.add(new BankAccount(checkDuplicateAccountNumber(accs,200022), "Abhay", LocalDate.parse("2022-12-15"),validateAccountOpeningBalance(40000,AccountType.SAVINGS), AccountType.SAVINGS));
			accs.add(new BankAccount(checkDuplicateAccountNumber(accs,200042), "Sonali" ,LocalDate.parse("2020-01-15"),validateAccountOpeningBalance(21003,AccountType.CURRENT),AccountType.CURRENT));
			accs.add(new BankAccount(checkDuplicateAccountNumber(accs,200046), "Ram" ,LocalDate.parse("2021-01-01"),validateAccountOpeningBalance(10000,AccountType.CURRENT),AccountType.CURRENT));
			accs.add(new BankAccount(checkDuplicateAccountNumber(accs,200038), "Raman" ,LocalDate.parse("2022-04-25"),validateAccountOpeningBalance(10000, AccountType.FIXEDDEPOSIT),AccountType.FIXEDDEPOSIT));
			accs.add(new BankAccount(checkDuplicateAccountNumber(accs,200054), "Shiv" ,LocalDate.parse("2019-11-15"),validateAccountOpeningBalance(25003,AccountType.SAVINGS),AccountType.SAVINGS));			
		} catch (Exception e) {
			System.out.println( e );
		}

		return accs;


	}

}
