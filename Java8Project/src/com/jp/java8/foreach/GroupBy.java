package com.jp.java8.foreach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupBy {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("John", "London","MALE", 21));
		people.add(new Person("Swann", "London","FEMALE", 21));
		people.add(new Person("Kevin", "London","MALE" ,23));
		people.add(new Person("Monobo", "Tokyo","MALE", 23));
		people.add(new Person("Sam", "Paris","MALE", 23));
		people.add(new Person("Nadal", "Paris","FEMALE", 31));

		System.out.println("Before Java 8");
		Map<String, List<Person>> groupByCity = new HashMap<>();

		for (Person person : people) {
			if (groupByCity.containsKey(person.getCity())) {
				List<Person> p = groupByCity.get(person.getCity());
				p.add(person);
				groupByCity.put(person.getCity(), p);
			} else {
				List<Person> p = new ArrayList<>();
				p.add(person);
				groupByCity.put(person.getCity(), p);
			}
		}
		groupByCity.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		System.out.println("grouping With single field in  java 8");

		Map<String, List<Person>> grp = people.stream()
				.collect(Collectors.groupingBy(Person::getCity));

		grp.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println("grouping With single field and count java 8");

		Map<String, Long> grp4 = people.stream()
				.collect(Collectors
				.groupingBy(Person::getCity,Collectors.counting()));

		grp4.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println("grouping and average With java 8");

		Map<String,Double> grp2 = people.stream()
				.collect(Collectors
				.groupingBy(Person::getCity,Collectors.averagingDouble(Person::getAge)));

		grp2.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println("grouping with multiple field and average With java 8");

		Map<String,Map<String,Double>> grp3 = people
				.stream()
				.collect(Collectors
				.groupingBy(Person::getCity,Collectors
				.groupingBy(Person::getGender,Collectors.averagingDouble(Person::getAge))));

		grp3.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}
}

class Person {

	private String name;
	private String city;
	private String gender;
	private int age;

	public Person(String name, String city, String gender, int age) {
		this.name = name;
		this.city = city;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("%s (%s,%s,%d)", name, city,gender, age);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.name);
		hash = 79 * hash + Objects.hashCode(this.city);
		hash = 79 * hash + Objects.hashCode(this.gender);
		hash = 79 * hash + this.age;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Person other = (Person) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.city, other.city)) {
			return false;
		}
		if (!Objects.equals(this.gender, other.gender)) {
			return false;
		}
		if (this.age != other.age) {
			return false;
		}
		return true;
	}
}
