package com.chigo.BSL;

import javafx.beans.property.SimpleStringProperty;

//public class Currencies extends ChScraper {
public class Currencies {
	private String name;
	private String eikonBid;
	private double webBid;
	public SimpleStringProperty getItemName() {
		return itemName;
	}

	public void setItemName(SimpleStringProperty itemName) {
		this.itemName = itemName;
	}

	public SimpleStringProperty itemName = new SimpleStringProperty("<Name>");
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEikonBid() {
		return eikonBid;
	}

	public void setEikonBid(String eikonBid) {
		this.eikonBid = eikonBid;
	}

	public double getWebBid() {
		return webBid;
	}

	public void setWebBid(double webBid) {
		this.webBid = webBid;
	}

	public Currencies() {
		this.name = "";
		this.eikonBid = "";
		this.webBid = 0;
	}
	
	public Currencies(String name, String eikonBid, double webBid) {
		/*
		this.name = name;
		this.eikonBid = eikonBid;
		this.webBid = webBid;
		System.out.println("return name! " + name);
		*/
		this.name = name;
		this.eikonBid = eikonBid;
		this.webBid = webBid;
		//System.out.println("return name! " + name);
	}

}
