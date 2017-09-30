package com.bcj.creditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcj.creditcard.dao.RegistrationDao;
import com.bcj.creditcard.model.CreditCard;
import com.bcj.creditcard.model.Customer;
import com.bcj.creditcard.model.Register;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDao rDao;

	public void setRdao(RegistrationDao rDao) {
		this.rDao = rDao;
	}

	public void saveCustomer(Customer customer) {

		System.out.println("customer service " + customer);
		rDao.saveCustomer(customer);
	}

	/*
	 * public boolean validatecard(CreditCard creditcard) { boolean bool=false;
	 * String creditcardNumber= rDao.validatecard(creditcard);
	 * 
	 * if(creditcardNumber.equals(creditcard.getCardNumber())) { bool=true; }
	 * else{ bool =false; }
	 * 
	 * 
	 * return bool;
	 * 
	 * 
	 * }
	 */

	public int activateCard(Register register) {

		String cardNmbr = register.getCreditcard().getCardNumber();
		CreditCard ccard = rDao.validatecard(cardNmbr);
		System.out.println(ccard);

		if (ccard != null && ccard.getStatus().equals("inactive")) {
			register.getCreditcard().setStatus("activated");
			rDao.updateCreditCard(register);



			return 1;
		} else if (ccard != null && ccard.getStatus().equals("activated")) {
			return 2;
		} else
			return 3;

	}

	public boolean authenticate(Register register) {
		Register user = rDao.authenticate(register);
		if ((user != null) && (user.getUserName().equals(register.getUserName()))
				&& (user.getPassword().equals(register.getPassword()))) {
			return true;
		} else
			return false;

	}

}
