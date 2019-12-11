package com.curdoperations.saving;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StudentMain {

	public static void main(String[] args) {
		
		//---->for deleting the record
		//deleteStudent(1);
		
		/*//---->for updating the record
		Student std=updateStudent(1);
		System.out.println(std.getStudentId());
		System.out.println(std.getStudentName());
		System.out.println(std.getStudentGrade());*/
		
		
		
		/*--->for getting the record
		Student std=getStudent(1);
		System.out.println(std.getStudentId());
		System.out.println(std.getStudentName());
		System.out.println(std.getStudentGrade());*/
		
	    //For Saving the Student
		SessionFactory factory=getSessionFactory();
		Session session=factory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		Student std=new Student();
		std.setStudentName("Subhan");
		std.setStudentId(83);
		std.setStudentGrade("A");
		session.save(std);
		trans.commit();
		
	}
	
	/*private static Student getStudent(int id) {
		SessionFactory factory=getSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Student std=session.get(Student.class, 1);
		return std;
	}
	
	private static Student updateStudent(int id) {
		SessionFactory factory=getSessionFactory();
		Session session=factory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		Student std=session.get(Student.class, 1);
		
		std.setStudentGrade("B");
		session.saveOrUpdate(std);
		trans.commit();
		return std;
	}
	private static Student deleteStudent(int id) {
		SessionFactory factory=getSessionFactory();
		Session session=factory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		Student std=session.get(Student.class, 1);
		session.delete(std);
		trans.commit();
		return std;
	}*/

	private static SessionFactory getSessionFactory() {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		return factory;
	}

}
