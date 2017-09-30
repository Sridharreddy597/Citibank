package com.bcj.creditcard.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcj.creditcard.model.CreditCard;
import com.bcj.creditcard.model.Customer;
import com.bcj.creditcard.model.Register;


@Repository
@Transactional
public class RegistrationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	public void saveCustomer(Customer customer) {

		System.out.println("customer saved sucessfully" + customer);
		Session session = this.sessionFactory.getCurrentSession();
		// Address add = customer.getAddress();
		// System.out.println("address saved sucessfully" + add);
		session.save(customer);
		// session.persist(add);
		// System.out.println("address saved sucessfully" + add);
		System.out.println("customer saved sucessfully" + customer);
	}

	public CreditCard validatecard(String card) {
		System.out.println(card);
		CreditCard carddetails = null;
		Session session = this.sessionFactory.getCurrentSession();
		// Transaction tx = session.beginTransaction();

		Query query = session.createQuery("FROM CreditCard WHERE cardNumber=:card");
		query.setParameter("card", card);
		List<CreditCard> creditcard = (List<CreditCard>) query.list();
		for (CreditCard details : creditcard) {

			carddetails = details;
		}

		return carddetails;

	}

	public void updateCreditCard(Register register) {
		// CreditCard card = (CreditCard) register.getCreditcard();
		Session session = this.sessionFactory.getCurrentSession();
		// Transaction tx = session.beginTransaction();

		// session.update(card);
		session.save(register);

	}

	public Register authenticate(Register register) {

		Register user = null;

		Session session = this.sessionFactory.getCurrentSession();
		// Transaction tx = session.beginTransaction();

		Query query = session.createQuery("FROM Register WHERE userName=:userName");
		query.setParameter("userName", register.getUserName());
		List<Register> userdetails = (List<Register>) query.list();
		for (Register details : userdetails) {

			user = details;
		}
		System.out.println(user.getUserName() + "  " + user.getPassword());
		return user;
	}

}
