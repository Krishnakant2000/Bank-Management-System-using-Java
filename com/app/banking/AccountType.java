package com.app.banking;

public enum AccountType {
	
	
		SAVINGS(5000),
		CURRENT(1000),
		FIXEDDEPOSIT(3000);
        private double balance;
        
		AccountType(int i) {
			this.balance=i;
			
		}
		public double getBalance() {
			return this.balance;
		}
		
//		static double valueOf(AccountType accType) {
//			try {
//				return AccountType.valueOf(accType);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return 0;
//		}
		
		
	
}
