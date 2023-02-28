package com.cerner.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cerner.model.User;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class UserDAO {


	public List<User> getAllUsers() {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  Query query=session.createQuery("from User u");
		  
		  List<User> userList=query.list();
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();


//		List<User> userList = new ArrayList<User>(usersMap.values());
		return userList;
	}

	public User getUserForId(int id) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  User user=session.get(User.class, id);
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		return user;
	}

	public User createUser(User user) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  session.save(user);
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();

		
		return user;
	}

	public User updateUser(User user) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  
		  session.update(user);
		  
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		
		return user;
	}

	public User deleteUser(int id) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  User user=session.get(User.class, id);
		  
		  session.delete(user);
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		
		return user;
	}

}
