package com.hibernate.flight.main;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.flight.entity.Flight;

public class FlightMain {

	public static void main(String[] args) {
		
		
		//create Sesion Factory object
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Flight.class)
								.buildSessionFactory();

		//create Session object
		Session session = factory.getCurrentSession();
		
		try {
			//begin session transaction
			session.beginTransaction();
			
			//Hibernate create operation
			createFlightBooking(session);
			
			//Hibernate read operation
			readFlightBooking(session);
			
			//Hibernate update operation
			updateFlightBooking(session);
			
			//Hibernate delete operation
			deleteFlightBooking(session);
			
			//commit session transaction
			session.getTransaction().commit();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

	//Method for delete operation
	private static void deleteFlightBooking(Session session) {
		//Get flight object from DB using ID
		Flight flight = session.get(Flight.class, 202002);
		
		//perform delete operation
		session.delete(flight);
		System.out.println("Delete done for --"+flight.getId());
		
	}

	//Method for update operation
	private static void updateFlightBooking(Session session) {
		//Create update query
		int updateCount = session.createQuery("update Flight f set f.refNo = 'TEST_REF'").executeUpdate();
		
		//print update result
		System.out.println("Update successfull -- Records updated --"+updateCount);
	}

	//Method for read operation
	private static void readFlightBooking(Session session) {
			
		//Retrieve flight details with id
		Flight flight = session.get(Flight.class, 202001);
		
		//Print student details fetched in previous step
		System.out.println("Read Flight Details -- "+flight.toString());
		
		
	}

	//Method for create operation
	private static void createFlightBooking(Session session) throws ParseException {
		//Date Formatter to convert String to date
		Date dateVal = dateFormat("05-04-2020");

		//Initialize Flight class object
		System.out.println("Initializing Flight Object for Create !!");
		Flight flight = new Flight("REF123", dateVal, "Abhihshek");

		//perform your operation here
		session.save(flight);
		
	}

	//SDF for handing String to Date Conversion
	private static Date dateFormat(String dateValue) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dateVal = sdf.parse(dateValue);
		return dateVal;
	}

}
