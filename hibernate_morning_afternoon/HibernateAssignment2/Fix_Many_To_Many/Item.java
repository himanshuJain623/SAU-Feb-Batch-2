package com.accolite.manytomany.Question2_FixManyToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name = "item")
public class Item {
	@Id
	@Column(name = "itemid")
	private int itemId;
	@Column(name = "itemname", length = 10)
	private String itemName;
	
	//@ManyToMany(targetEntity = Item.class)
	//@JoinColumn(referencedColumnName = "itemid")
	@ManyToMany(targetEntity = Categories.class)
	@JoinColumn(referencedColumnName = "itemid")	
	private Set<Categories> categories;
	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
