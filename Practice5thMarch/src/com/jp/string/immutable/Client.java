package com.jp.string.immutable;

public class Client {
	
	public static void main(String[] args) {
		
		try {
		Address add=new Address("101", "Vagdevi Layout", "B'lore", 560037);
		System.out.println("address : "+add.hashCode());
		
		Student student=new Student(101, "Jaipal", "jaipal66kumar@gmail.com", add);
		System.out.println("student: "+student.hashCode());
		
		Address add1=student.getAddress();
		add1.setCity("Bengaluru");
		
		System.out.println("student: "+student.hashCode());
		System.out.println(student.getAddress().getCity());
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
