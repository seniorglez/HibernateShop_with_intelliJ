/*
 *  Copyright (c) 2020 Diego Dominguez Gonzalez
 *
 *	This file is part of HibernateShop.
 *
 *  HibernateShop is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or any later version.
 *
 *	HibernateShop is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with HibernateShop. If not, see <https://www.gnu.org/licenses/>.
 */
package model;

import org.hibernate.*;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * A class that allows us to read and write a sql database
 * 
 * @author Diego Dominguez Gonzalez
 *
 */
public class DataBaseTool {
	Session session;

	public DataBaseTool() {

		session=UtilHibernate.getSession();
	}

	/**
	 * Checks if a costumer exists on the database
	 *
	 * @param name     the name which identifies the costumer's account.
	 * @param password the costumer's account.
 	*/
	public boolean checkUser(String name, String password) {
			Query query =session.createQuery("FROM CustomersEntity WHERE name=?1 AND password=?2");
			query.setParameter(1,name);
			query.setParameter(2,password);
			return query.uniqueResult() != null;
	}



	/**
	 *  Adds a new costumer to the database
	 *
	 * @param name     the name which identifies the costumer's account.
	 * @param password the password that the costumer will use to login.
	 */
	public void createUser(String name, String password) {
		CustomersEntity cus = new CustomersEntity();
		cus.setName(name);
		cus.setPassword(password);
		session.beginTransaction();
		session.save(cus);
		session.getTransaction().commit();
	}

	/**
	 * Gets a List of Products that represents all the products on the database.
	 *
	 * @return List of Products that represents all the products on the database.
	 */
	public List<ProductsEntity> getProducts() {
		return session.createQuery("FROM ProductsEntity").list();
	}


	public void addPurchase(CustomersEntity us, Map<Integer, Integer> cart) {
		int id = checkUserId(us);
		BillsEntity be = new BillsEntity();
		be.setClientId(id);
		be.setPurchaseDate(new Timestamp(new Date().getTime()));
		session.beginTransaction();
		session.save(be);
		session.getTransaction().commit();
		int idBill=checkLastBillId(id);
		cart.forEach((p,num)->{
			BillLinesEntity b= new BillLinesEntity();
			b.setBillId(idBill);
			b.setProductId(p);
			b.setUnits(num);
			session.beginTransaction();
			session.save(b);
			session.getTransaction().commit();
		});
	}

	private int checkUserId(CustomersEntity us){
		Query<CustomersEntity> query = session.createQuery("from CustomersEntity where name=?1 and password=?2");
		query.setParameter(1,us.getName());
		query.setParameter(2,us.getPassword());
		return query.uniqueResult().getId();
	}

	private int checkLastBillId(int clientid){
		Query query = session.createQuery("select max(id) from BillsEntity where clientId=?1");
		query.setParameter(1,clientid);
		return (int) query.uniqueResult();
	}

	/**
	 * Gets a product object that represents a product stored on the database.
	 *
	 * @param code The unitary code which identifies the product.
	 * @return the product object that represents the product stored on the
	 *         database.
	 */
	public ProductsEntity getProduct(int code) {
		Query query =session.createQuery("FROM ProductsEntity WHERE idProduct=?1");
		query.setParameter(1,code);
		return (ProductsEntity) query.uniqueResult();
	}
}
