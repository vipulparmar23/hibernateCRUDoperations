package com.first.hibernateCRUD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static Session session;

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {

			Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
			return con.buildSessionFactory();

		} catch (Throwable t) {

			System.out.println("SessionFactory creation failed: " + t);
			throw new ExceptionInInitializerError();

		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	public static void createRecord() {
		session = getSessionFactory().openSession();
		session.beginTransaction();

		Employee e1 = new Employee("John", "Smith");

		session.save(e1);
		session.getTransaction().commit();

	}

	public static List displayRecords() {
		session = getSessionFactory().openSession();
		session.beginTransaction();

		List employeeList = new ArrayList();

		employeeList = session.createQuery("FROM Employee").list();

		return employeeList;
	}

	public static void deleteRecord(Integer id) {
		session = getSessionFactory().openSession();
		session.beginTransaction();

		Employee e = session.get(Employee.class, id);
		session.delete(e);

		System.out.println("Employee with ID = " + id + " has been deleted from records.");
	}

	public static void updateRecord(Integer id) {
		session = getSessionFactory().openSession();
		session.beginTransaction();

		Employee e = session.get(Employee.class, id);
		e.setFirstName("ABC");
		session.getTransaction().commit();
		System.out.println("Employee with ID = " + id + " has been updated.");
	}

	public static Employee findEmployeeByID(Integer id) {
		session = getSessionFactory().openSession();
		session.beginTransaction();

		Employee e = session.load(Employee.class, id);
		return e;
	}

	public static void deleteAllRecords() {

		session = getSessionFactory().openSession();
		session.beginTransaction();

		Query q = session.createQuery("DELETE FROM Employee");
		q.executeUpdate();

		session.getTransaction().commit();

		System.out.println("All employee records are deleted.");

	}

}
