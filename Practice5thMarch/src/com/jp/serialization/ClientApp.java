package com.jp.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientApp {

	public static void main(String[] args) {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("employee.txt")));

			Address add = new Address(101, "Vagdevi", "Blore", 560037);
			Employee jaipal = new Employee(1,"B.E",1001, "Jaipal", "jaipal.kumar@hpe.com", 120000, add);
			// Employee sukanya = new Employee(1002, "Sukanya", "sukanya.saha@hpe.com",
			// 60000);

			oos.writeObject(jaipal);
			// oos.writeObject(sukanya);

			System.out.println("*******Serialized******");

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("employee.txt")));

			Employee emp = (Employee) ois.readObject();
			System.out.println("*******DeSerialized******");
			System.out.println(emp);

		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
