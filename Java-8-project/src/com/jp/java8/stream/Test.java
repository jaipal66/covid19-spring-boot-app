package com.jp.java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		students.add(new Student("jaipal", 28, 101, Gender.MALE));
		students.add(new Student("kumar", 40, 102, Gender.MALE));
		students.add(new Student("roshan", 27, 105, Gender.MALE));
		students.add(new Student("pk", 28, 108, Gender.MALE));
		students.add(new Student("deepak", 31, 104, Gender.MALE));
		students.add(new Student("sukanya", 30, 103, Gender.FEMALE));
		students.add(new Student("rashmi", 35, 107, Gender.FEMALE));
		students.add(new Student("reena", 32, 108, Gender.FEMALE));
		Map<Integer, Student> studentMap = new HashMap<>();
		studentMap.put(1, new Student("jaipal", 28, 101, Gender.MALE));
		studentMap.put(2, new Student("kumar", 40, 102, Gender.MALE));
		studentMap.put(3, new Student("roshan", 27, 105, Gender.MALE));
		studentMap.put(4, new Student("pk", 28, 108, Gender.MALE));
		studentMap.put(5, new Student("deepak", 31, 104, Gender.MALE));
		studentMap.put(6, new Student("sukanya", 30, 103, Gender.FEMALE));
		studentMap.put(7, new Student("rashmi", 35, 107, Gender.FEMALE));
		studentMap.put(8, new Student("reena", 32, 108, Gender.FEMALE));
		listOperation(students);
		mapOperations(studentMap);

	}

	private static void mapOperations(Map<Integer, Student> studentMap) {

		Set<Integer> set = studentMap.keySet();
		set.forEach(System.out::print);
		System.out.println();
		Collection<Student> list = studentMap.values();
		list.forEach(System.out::print);
		System.out.println();
		System.out.println("WITH java 8");
		List<Integer> keyList = studentMap.keySet().stream().collect(Collectors.toList());
		System.out.println("List of Key with lamda");
		keyList.forEach(value -> System.out.print(value + " "));
		System.out.println();
		System.out.println("List of key with method reference");
		keyList.forEach(System.out::print);
		System.out.println();

		System.out.println("Another map by filter name");
		Map<Integer, Student> map = studentMap.entrySet()
				.stream()
				.filter(e -> e.getValue().getName().equals("kumar"))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		map.forEach((key,value)->{
			System.out.println(key);
			System.out.println(value);
		});

		System.out.println("Another map by filter name and sorting");
		Map<Integer, Student> map1 = studentMap.entrySet()
				.parallelStream()
				
				.limit(2)
				.filter(e -> e.getValue().getGender().equals(Gender.MALE))
				.sorted((e1,e2)->e1.getValue().getName().compareTo(e2.getValue().getName()))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		map1.forEach((key,value)->{
			System.out.println(key+" : "+value);
		});

	}

	private static void listOperation(List<Student> students) {
		System.out.println("List of Female students");
		List<Student> list = students.stream().filter(s -> s.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());
		System.out.println(list);

		System.out.println("List of Male students");
		List<Student> list1 = students.stream().filter(s -> s.getGender().equals(Gender.MALE))
				.collect(Collectors.toList());
		System.out.println(list1);

		System.out.println("List of Male students name");
		List<String> list2 = students.stream()
				.filter(s -> s.getGender().equals(Gender.MALE))
				.map(s -> s.getName())
				.collect(Collectors.toList());
		System.out.println(list2);

		System.out.println("List of Female students name");
		List<String> list3 = students.stream()
				.filter(s -> s.getGender().equals(Gender.FEMALE))
				.map(s -> s.getName())
				.collect(Collectors.toList());
		System.out.println(list3);

		System.out.println("Group by Gender");
		Map<Gender, Long> map = students.stream()
				.collect(Collectors.groupingBy(s -> s.getGender(), Collectors.counting()));
		System.out.println(map);

		System.out.println("average age");
		Double avegareAge = students.stream()
				.collect(Collectors.averagingInt(student -> student.getAge()));
		System.out.println(avegareAge);

		System.out.println("Collecting as average ");
		Stream<Student> stream = students.stream();
		double avg = stream.collect(Collectors.averagingInt(s -> s.getAge()));
		System.out.println("avg " + avg);
		double avg1 = students.stream()
				.collect(Collectors.averagingLong(Student::getAge));
		System.out.println("avg1 " + avg1);
		double avg2 = students.stream()
				.collect(Collectors.averagingDouble(Student::getId));
		System.out.println("avg2 " + avg2);

		System.out.println("Collecting as group by");

		Map<Object, List<Student>> map1 = students.stream()
				.collect(Collectors.groupingBy(s -> s.getGender()));
		System.out.println(map1);

		System.out.println("Collet as map of Name and age");
		Map<String, Integer> map2 = students.stream()
				.collect(Collectors.toMap(s -> s.getName(), s -> s.getAge()));
		System.out.println(map2);

		System.out.println("Collet as group by gender and " + "collect as gender as key and  list of student as value");
		Map<Gender, List<Student>> l = students.stream()
				.collect(Collectors.groupingBy(s -> s.getGender()));
		System.out.println(l);

		System.out.println("Collet as group by gender and name");
		Map<Object, Map<Object, List<Student>>> gn = students.stream()
				.collect(Collectors.groupingBy(s -> s.getGender(), Collectors.groupingBy(s -> s.getName())));

		System.out.println(gn);

		System.out.println("Collet as Map of gender as key " + "Name as value and if duplicate then replace with new");
		Map<Object, Object> gn1 = students.stream()
				.collect(Collectors.toMap(s -> s.getName(), s -> s.getGender(), (old, n) -> n));

		System.out.println(gn1);

		System.out.println("Collet as LinkedHashMap of gender as key " + "Name as value ");
		Map<Object, Object> gn2 = students.stream()
				.collect(Collectors.toMap(s -> s.getName(), s -> s.getGender(), (old, n) -> n, LinkedHashMap::new));

		System.out.println(gn2);

		System.out.println("Collet as group by gender and name");
		Map<Object, List<Student>> gn3 = students.stream().sorted(Comparator.comparingInt(Student::getAge).reversed())
				.filter(s -> s.getAge() > 20).collect(Collectors.groupingBy(s -> s.getGender()));

		System.out.println(gn3);
	}
}
