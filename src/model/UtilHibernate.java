package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilHibernate {



		private static final SessionFactory ourSessionFactory;

		static {
			try {
				Configuration configuration = new Configuration();
				configuration.configure();

				ourSessionFactory = configuration.buildSessionFactory();
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}
		}

		public static Session getSession() throws HibernateException {
			return ourSessionFactory.openSession();
		}
}
