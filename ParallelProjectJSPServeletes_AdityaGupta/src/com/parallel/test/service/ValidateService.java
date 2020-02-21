package com.parallel.test.service;

import com.parallel.test.bean.Wallet;

public class ValidateService {
	
	public boolean validate(Wallet w) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		if(! (w.getWalletEmailId().matches(regex))) {
			System.out.println("Please enter the valid email");
			return false;
		}
		if(Long.toString(w.getWalletPhoneNumber()).length()!=10) {
			System.out.println("Please enter the valid phone number");
			return false;
		}
		if(Integer.toString(w.getPin()).length()<4) {
			System.out.println("Please enter the valid pin");
			return false;
		}
		if(w.getWalletName().compareTo("")==0) {
			return false;
		}
		return true;
	}
}
//	public boolean validate(String email) {
//		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//		
//		if(! (email.matches(regex))) {
//			System.out.println("Please enter the valid email");
//			return false;
//		}
//		return true;
//	}
//	public boolean validate(Long phn) {
//		
//		if(Long.toString(phn).length()!=10) {
//			System.out.println("Please enter the valid phone number");
//			return false;
//		}
//		return true;
//	}
//	public boolean validate(int pin) {
//		
//		if(Integer.toString(pin).length()<=4) {
//			System.out.println("Please enter the valid pin");
//			return false;
//		}
//		return true;
//	}
//	
//}
