package com.app.bankingValidation;

import java.util.ArrayList;

import com.app.banking.BankAccount;
import com.app.banking.CustomException;

public class validationRules {

	public static void checkDuplicateAccountNumber(ArrayList<BankAccount> acts,int accNo) throws CustomException {
		BankAccount acc = new BankAccount(accNo);
//		boolean check = false;
		if (acts.contains(acc)){
			throw new CustomException("Account already exists!!!!!");
		}

	}
	
	
}
