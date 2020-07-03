package com.jp.design.patterns.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Client {
	public static void main(String[] args) {

		Singleton singleton = Singleton.getInstance();
		System.out.println("Singleton : " + singleton.hashCode());

		Class cls = Singleton.class;
		try {

			Constructor con = cls.getDeclaredConstructor();
			con.setAccessible(true);
			Singleton sin = (Singleton) con.newInstance();
			System.out.println("SIN : " + sin.hashCode());
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();

		}

		System.out.println("=====================================");
		Employee employee = Employee.getEmployee();
		System.out.println("Emp: " + employee.hashCode());

		try {
			FileOutputStream fio = new FileOutputStream(new File("employee.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fio);
			oos.writeObject(employee);
			System.out.println("Employee is serialized : " + employee.hashCode());

			FileInputStream fis = new FileInputStream(new File("employee.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee emp = (Employee) ois.readObject();
			System.out.println("Employee is deseralized : " + emp.hashCode());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("=====================================");

		SingletonClonning singletonClonning = SingletonClonning.getSingletonClonning();
		System.out.println("SingletonClonning : " + singletonClonning.hashCode());

		try {
			SingletonClonning singletonClonning2 = (SingletonClonning)singletonClonning.clone();
			System.out.println("SingletonClonning with clonning "+singletonClonning2.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
