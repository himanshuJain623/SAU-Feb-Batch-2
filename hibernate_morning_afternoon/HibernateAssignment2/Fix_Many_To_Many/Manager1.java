package com.accolite.manytomany.Question2_FixManyToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accolite.util.Util;

public class Manager1 {
	public static void main(String args[]) {
		Session ses = Util.getSession();

		Categories c1 = new Categories();
		c1.setCategoryId(1);
		c1.setCategoryName("cat 1");

		Categories c2 = new Categories();
		c2.setCategoryId(2);
		c2.setCategoryName("cat 2");

		Item i1 = new Item();
		Item i2 = new Item();

		i1.setItemId(101);
		i1.setItemName("item1");

		i2.setItemId(102);
		i2.setItemName("item2");

		Set itemSet = new HashSet();
		itemSet.add(i1);
		itemSet.add(i2);

		c1.setItems(itemSet);
		c2.setItems(itemSet);

		Set categorySet = new HashSet();
		categorySet.add(c1);
		categorySet.add(c2);

		i1.setCategories(categorySet);
		i2.setCategories(categorySet);

		Transaction tx = ses.beginTransaction();
		ses.save(c1);
		ses.save(c2);
		ses.save(i1);
		ses.save(i2);
		tx.commit();
		System.out.println("Many to Many using annotations been done...!!!!!");
		ses.close();
	}
}
