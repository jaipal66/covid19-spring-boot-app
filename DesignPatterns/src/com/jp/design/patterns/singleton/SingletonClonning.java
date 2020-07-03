package com.jp.design.patterns.singleton;

public class SingletonClonning implements Cloneable{

	private static SingletonClonning singletonClonning;

	private SingletonClonning() {

	}

	public static SingletonClonning getSingletonClonning() {
		if (singletonClonning == null) {
			singletonClonning = new SingletonClonning();
		}
		return singletonClonning;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		//throw new CloneNotSupportedException();
		return singletonClonning;
	}
}
