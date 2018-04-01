package com.first.hibernateCRUD;

import java.util.List;

public class App 
{
	
    public static void main( String[] args )
    {
    	/*Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	session.beginTransaction();
    	
    	Employee e1 = new Employee("Vipul", "Parmar");
    	session.save(e1);
    	session.getTransaction().commit();*/
    	
    	//HibernateUtil.createRecord();
    	/*List<Employee> employeeList = HibernateUtil.displayRecords();
    	
    	if(employeeList != null & employeeList.size() > 0) {
    		for (Employee e : employeeList) {
    			System.out.println(e.toString());
    		}
    	}*/
    	
    	HibernateUtil.updateRecord(2);
    }
    
    
}
