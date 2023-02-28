package com.cerner.dao;

import java.time.LocalDate;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cerner.model.Encounter;
import com.cerner.model.Vitals;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class VitalsDAO {
	
	public List<Vitals> getAllVitals() {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  
		  //TypedQuery<PatientsVitalsDetails> query =session.getNamedNativeQuery("getPatientDetails")
		  @SuppressWarnings({ "unchecked", "deprecation" })
		Query<Vitals> query=session.createQuery("from Vitals v");
		  
		  @SuppressWarnings("deprecation")
		List<Vitals> list=query.list();
		  
		  transaction.commit();
		  session.close();

		//List<PatientsVitalsDetails> patientList = new ArrayList<PatientsVitalsDetails>(patientMap.values());
		return list;
	}

	public Vitals getVitalForId(Integer id) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		 
		  
		  Vitals vital=session.get(Vitals.class, id);
		  
		  session.close();
		  sessionFactory.close();
		return vital;
	}

	public String createVital(Vitals vital) {
		
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  vital.setUpdation_date(LocalDate.now());
		  
		  session.save(vital);
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		return "Vitals Data saved ";
	}

	public Vitals updateVital(Vitals vital) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
	
		  
		  vital.setUpdation_date(LocalDate.now());
		  
		  
		  session.update(vital);
		  
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		 return vital;
		
	}

	public Vitals deleteVital(Integer id) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  Vitals patient=session.get(Vitals.class, id);
		  
		  session.delete(patient);
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		
		return patient;
	}
	public Vitals recentData() {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  
		  Vitals patient=null;
		  
		  //session.delete(patient);
		  Query query=session.createQuery("from Vitals v ORDER BY v.vital_Id desc");
		  
		  List<Vitals> patientList1=query.list();
		  int i=1;
		  for(int j=0;j<i;j++) {
			   patient=  patientList1.get(j);
		  }
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		
		return patient;
	}
	
	public int getEncounter(int id) {
		Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  
		  
		  Encounter encounter=session.get(Encounter.class, id);
		  
		 int encounter_Id=encounter.getEncounter_Id();
		 
		
		  session.close();
		
		return encounter_Id;
	}
	
//	public List<Vitals> getPatientByDate(String date){
//		
//		Configuration configuration = new Configuration();
//		  configuration.configure("hibernate.cfg.xml");
//		  SessionFactory sessionFactory = configuration.buildSessionFactory();
//		  Session session = sessionFactory.openSession();
//		  Transaction transaction = session.beginTransaction();
//		
//		  transaction.commit();
//		  session.close();
//		  sessionFactory.close();
//		return null;
//	}

	
}
