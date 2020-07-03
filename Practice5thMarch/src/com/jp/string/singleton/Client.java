package com.jp.string.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
	public static void main(String[] args) {

		Singleton obje = Singleton.getInstance();
		System.out.println(obje.hashCode());
		System.out.println("++++++++ after clone() ++++++");
		try {
			Singleton obj2 = (Singleton) obje.clone();
			System.out.println(obj2.hashCode());
		} catch (Exception e) {

		}

		System.out.println("++++++++ after Reflection ++++++");

		Class<Singleton> cls = Singleton.class;
		Constructor<?>[] con = cls.getDeclaredConstructors();
		for (Constructor<?> constructor : con) {
			try {
				constructor.setAccessible(true);
				Object ob = constructor.newInstance();
				Singleton sin = (Singleton) ob;
				System.out.println(sin.hashCode());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("++++++++  Serialiazation & Deserialization ++++++");

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Singleton.text")));
			Singleton sin = Singleton.getInstance();
			oos.writeObject(sin);
			oos.close();
			System.out.println("++++Serialized+++++");
			
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("Singleton.text")));
			
			Singleton si=(Singleton)ois.readObject();
			System.out.println(si.hashCode());
			ois.close();
			System.out.println("++++DESerialized+++++");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
