package com.vipin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtill {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();
		om.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));

		Car car = new Car("fial=t", 5,new Date());
		File file = new File("car.json");
		

		System.out.println(om.writeValueAsString(car));

	}

}

class Car {
	private String brand = null;
	private int doors = 0;
	private Date manufatureDate;

	public Date getManufatureDate() {
		return manufatureDate;
	}

	public void setManufatureDate(Date manufatureDate) {
		this.manufatureDate = manufatureDate;
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String brand, int doors, Date date) {
		super();
		this.brand = brand;
		this.doors = doors;
		this.manufatureDate = date;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getDoors() {
		return this.doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}
}