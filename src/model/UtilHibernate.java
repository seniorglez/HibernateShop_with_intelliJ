package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilHibernate {
	private static SessionFactory sessionFactory=null;

	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory==null)
			try {
				File cfg = new File("sessionFactory.xml");
				  BufferedReader br = new BufferedReader(new FileReader(cfg)); 
				  System.out.println("---------------Loading hibernate.cfg.xml---------------");
				  String st; 
				  while ((st = br.readLine()) != null) System.out.println(st); 
				 br.close();
				sessionFactory=new Configuration().configure(cfg).buildSessionFactory();
			} catch (Exception e) {//get ,getClassLoader
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return sessionFactory;
	}

}
