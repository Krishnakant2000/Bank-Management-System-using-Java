package com.app.bankTester;

import static com.app.bankingUtils.BankingUtils.populateBankAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;
import com.app.banking.BankingException;
import com.app.bankingValidation.ValidationRules;
import static com.app.bankingValidation.ValidationRules.validateAccountOpeningBalance;


public class TestAccount {

	public static void main(String[] args)  {
	
		try(Scanner sc=new Scanner(System.in)){
			
			System.out.println("--------Welcome to Banking Management System----------");
			boolean exit = false;
			
//			ArrayList<BankAccount> accounts = new ArrayList<>();
			List<BankAccount> accounts = (ArrayList<BankAccount>) populateBankAccount();
			
			Map<Integer, BankAccount> accsMap = new HashMap<>();
//			Populate hashmap with bank accounts data in utils
			for(BankAccount b : accounts) {
				accsMap.putIfAbsent(b.getAccountNumber(), b);
			}
			
			while(!exit){
				
				
				System.out.println("Enter your choice \n 1. Create new Account \n 2. Display Account Summary \n 3. Withdraw Money \n 4. Deposit Money \n 5. Fund Transfer\n 6. Sort the Account Numbers \n 7. Sort the Account Opening Date \n 8. Sort the Accounts as per Account Balance \n 0. Exit \n");
				
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter Account Number: ");
					int accNo = sc.nextInt();
//					ValidationRules.checkDuplicateAccountNumber(accounts,accNo);
					System.out.println("Enter Account Holder's Name: ");
					String custName = sc.next();
//					System.out.println("Enter Account Opening Date: ");
					LocalDate d = LocalDate.now();
					System.out.println("Enter Account Type: \n a) Savings (Min Balance req = Rs.5000) \n b) Current (Min Balance req = Rs.1000)\n c) Fixed Deposit (Min Balance req = Rs.3000)\n");
					String accType = sc.next().toUpperCase();
					AccountType a1 = AccountType.valueOf(accType);
					
					System.out.println("Enter the Opening Balance to be deposited");
//					try {
	
						double accBal = sc.nextDouble();
						if(validateAccountOpeningBalance(accBal,a1)!=0) {
							BankAccount act = new BankAccount(accNo, custName, d, accBal, a1);
							accsMap.putIfAbsent(act.getAccountNumber(), act); 
							System.out.println("Account created Successfully ");
							
							
						}
						else {
							System.out.println("Amount less than Minimum Balance required.. Try next Time !!");
						}
//						a1.getBalance().equals(accBal);
//					}
//					catch (Exception e) {
						// TODO: handle exception
//					}
//					accounts[counter-1].deposit(accBal);
					
					break;
				case 2:
//					boolean fl=false;
//					System.out.println("Enter your A/c Number :");
//					int acNo = sc.nextInt();
//					for(BankAccount acc : accounts) {
//						if (acNo == acc.getAccountNumber()) {
//							System.out.println("Your Account Summary is as follows: "+acc);
//							fl=true;
//							break;
//						}
//					}
				
//					if(!fl) {
//						System.out.println("Invalid A/c Number..!\n");
//					}
//					Iterator<BankAccount>  itr = accounts.iterator();
//					while(itr.hasNext()) {
//						System.out.println(itr.next());	
//					}
					Collection<BankAccount> accounts1=accsMap.values();
					Iterator<BankAccount>  itr = accounts1.iterator();
					while(itr.hasNext()) {
						System.out.println(itr.next());	
					}
					
					break;
				
				case 3:
					System.out.println("Enter your A/c Number :");
					int acNo1 = sc.nextInt();
					boolean flag=false;
					Collection<BankAccount> accounts2=accsMap.values();
					for(BankAccount acc: accounts2) {
						if (acc !=null && ((Integer)acNo1).equals(acc.getAccountNumber())) {
							System.out.println("Enter amount to be withdrawn : ");
							double amt = sc.nextDouble();
							acc.withdraw(amt);
							flag=true;
							System.out.println("Withdrawn Successfully..!!");
							break;
						} 
						
					}
					if(flag==false) {
						System.out.println("Entered an invalid account number!");
					}
					
					
					
					break;
	
				case 4:
					System.out.println("Enter your A/c Number :");
					int acNo2 = sc.nextInt();
					boolean flag1=false;
					Collection<BankAccount> accounts3=accsMap.values();
					for(BankAccount acc: accounts3) {
						if (((Integer)acNo2).equals(acc.getAccountNumber())) {
							System.out.println("Enter amount to be Deposit : ");
							double amt = sc.nextDouble();
							acc.deposit(amt);
							flag1=true;
							System.out.println("Deposited Successfully..!!");
							break;
						} 
						
					}
					if(flag1==false) {
						System.out.println("Entered an invalid account number!");
					}
					break;
				
				case 5:
//					boolean flag3=false, flag4=false;
					System.out.println("Enter your Source A/c Number :");
					int sourceAccount = sc.nextInt();
					boolean srcExists=accsMap.containsKey(sourceAccount);
					try {
						if(!srcExists) {
							throw new BankingException("Source A/c does not exist..!");
						}
						else {
					
							System.out.println("Enter the Target A/c Number of Creditor:");
							int targetAccount = sc.nextInt();
							boolean targetExists=accsMap.containsKey(targetAccount);
							if(!targetExists) {
								throw new BankingException("A/c does not exist..!");
							}
							else {
								System.out.println("Enter amount to be Transferred : ");
								double amt = sc.nextDouble();
								accsMap.get(sourceAccount).fundTransfer(accsMap.get(targetAccount), amt);
								System.out.println("Fund Transfer Successfull..!!");
							}
							
						}
					}catch (Exception e) {
						System.out.println(e);
						e.printStackTrace();
					}
//					------------IF USING ARRAYS--------------
//					for(BankAccount acc: accounts) {
//						if (acNo3 == acc.getAccountNumber()) {
//							flag3=true;
//							
//							System.out.println("Enter the A/c Number of Creditor:");
//							int acNo4 = sc.nextInt();
//								
//							for(BankAccount acc1 : accounts) {
//								if (acNo4 == acc1.getAccountNumber()) {
//									flag4=true;
//									System.out.println("Enter amount to be Transferred : ");
//									double amt = sc.nextDouble();
//									acc.fundTransfer(acc1,amt);
//									break;
//								}
//							}
//							if(!flag4) {
//									System.out.println("Invalid Creditor's A/c Number..!\n");
//								} 
//							}
//						}
//						if(!flag3) {
//							System.out.println("Invalid A/c Number..!\n");
//						} 
						
					
					break;
				case 6:
//					natural ordering (sorting based on acc nos. using values() for conversion in collection view
//					Collection<BankAccount> acc3 = accsMap.values();
//					ArrayList<BankAccount> accs3 = new ArrayList<>(acc3);
//					Collections.sort(accs3);
					Map<Integer, BankAccount> sortedMap = new TreeMap<>(accsMap);
					accsMap=sortedMap;
					
					break;
					
				case 7:
					Collection<BankAccount> acc4 = accsMap.values();
					ArrayList<BankAccount> accs4 = new ArrayList<>(acc4);
				    Collections.sort(accs4 ,new Comparator<BankAccount>() {
						 @Override
						 public int compare(BankAccount b1, BankAccount b2) {
							 
							return b1.getAccountOpeningDate().compareTo(b2.getAccountOpeningDate());
						 }
					});
				    for(BankAccount b: accs4) {
				    	System.out.println(b);				    	
				    }
					break;
				case 8:
//					custom ordering (sorting based on accBalance)
					Collection<BankAccount> acc5 = accsMap.values();
					ArrayList<BankAccount> accs5 = new ArrayList<>(acc5);
					 Collections.sort(accs5, new Comparator<BankAccount>() {
						 @Override
						 public int compare(BankAccount b1, BankAccount b2) {
							return ((Double)b1.getAccountBalance()).compareTo(b2.getAccountBalance());
						 }
					});
					 for(BankAccount b: accs5) {
					    	System.out.println(b);				    	
					    }
					break;
					
				case 0:
					System.out.println("Thank You for using our banking system..");
					exit = true;
//					System.exit(0);
					break;
				
				
				}
			} 
		}
		catch (BankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
