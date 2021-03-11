package com.au.ecommerce;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.au.util.SessionUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to the system");

		Category computersCat = new Category("computers", "electronics");
		Category mobilesCat = new Category("mobiles", "electronics");
		Category clothesCat = new Category("clothes", "fashion");

		Supplier supplier1 = new Supplier();
		Supplier supplier2 = new Supplier();
		Supplier supplier3 = new Supplier();

		supplier1.setSupplierName("supplier 1");
		supplier1.setSupplierPhone("9999887765");

		supplier2.setSupplierName("supplier 2");
		supplier2.setSupplierPhone("9999887764");

		supplier3.setSupplierName("supplier 3");
		supplier3.setSupplierPhone("9999887763");

		List<Supplier> supplierList1 = new ArrayList<Supplier>();
		supplierList1.add(supplier1);
		supplierList1.add(supplier2);

		List<Supplier> supplierList2 = new ArrayList<Supplier>();
		supplierList2.add(supplier2);
		supplierList2.add(supplier3);

		List<Supplier> supplierList3 = new ArrayList<Supplier>();
		supplierList3.add(supplier1);
		supplierList3.add(supplier3);

		computersCat.setSupplier(supplierList1);
		mobilesCat.setSupplier(supplierList2);
		clothesCat.setSupplier(supplierList3);

		Product product1 = new Product();
		product1.setProductName("hp");
		product1.setProductPrice(10000);
		product1.setCategory(computersCat);

		Product product2 = new Product();
		product2.setProductName("dell");
		product2.setProductPrice(12000);
		product2.setCategory(computersCat);

		Product product3 = new Product();
		product3.setProductName("realme");
		product3.setProductPrice(8000);
		product3.setCategory(mobilesCat);

		Product product4 = new Product();
		product4.setProductName("shirt");
		product4.setProductPrice(500);
		product4.setCategory(clothesCat);

		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.save(computersCat);
		session.save(mobilesCat);
		session.save(clothesCat);

		session.save(supplier1);
		session.save(supplier2);
		session.save(supplier3);

		session.save(product1);
		session.save(product2);
		session.save(product3);
		session.save(product4);

		tx.commit();
		session.close();
		System.out.println("welcome again");
	}
}
