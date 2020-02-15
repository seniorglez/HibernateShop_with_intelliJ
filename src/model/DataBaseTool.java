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


/**
 * A class that allows us to read and write a sql database
 * 
 * @author Diego Dominguez Gonzalez
 *
 */
public class DataBaseTool {


	public DataBaseTool() {
		SessionFactory sf =UtilHibernate.getSessionFactory();
		Session session=sf.getCurrentSession();
	}
	
//    public List<ProductsEntity> listProduct(){
//
//        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        List<ProductsEntity> resultados=(List<ProductsEntity>) session.createQuery("from ProductsEntity ").list();
//        return  resultados;
//
//    }
//
//	/**
//	 * Checks if a costumer exists on the database
//	 * 
//	 * @param name     the name which identifies the costumer's account.
//	 * @param password the costumer's account.
//	 */
//	public boolean checkUser(String name, String password) {
//
//		return false;
//	}
//
//	private int checkUserId(User u) {
//
//		return 0;
//	}
//
//	/**
//	 * Adds a new costumer to the database
//	 * 
//	 * @param name     the name which identifies the costumer's account.
//	 * @param password the password that the costumer will use to login.
//	 */
//	public void createUser(String name, String password) {
//
//
//	}
//
//	/**
//	 * Gets a List of Products that represents all the products on the database.
//	 * 
//	 * @return List of Products that represents all the products on the database.
//	 */
//	public List<Product> getProducts() {
//		return null;
//	}
//
//
//	public void addPurchase(User us, Map<Integer, Integer> cart) {
//
//	}
//
//	/**
//	 * Gets a product object that represents a product stored on the database.
//	 * 
//	 * @param code The unitary code which identifies the product.
//	 * @return the product object that represents the product stored on the
//	 *         database.
//	 */
//	public Product getProduct(int code) {
//		return null;
//	}
}
