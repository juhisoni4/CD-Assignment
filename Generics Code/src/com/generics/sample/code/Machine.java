package com.generics.sample.code;

class Robot{
	
	private int totalNo;	

	public Robot(int id) {
		super();
		this.totalNo = id;
	}
	
	public int getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}
	@Override
	public String toString() {
		return "Robot ";
	}

}

class Car extends Robot{

	public Car(int totalNo) {
		super(totalNo);
	}	
	
	public String toString() {
		return "Car";
	}
}

class Bike extends Robot{

	public Bike(int totalNo) {
		super(totalNo);		
	}
	
	public String toString() {
		return "Bike";
	}
}

public class Machine<T extends Robot> {

	T a;		
	
	public Machine(T a) {
		this.a = a;
	}
	
	public void start(){
		System.out.println(a + " is starting");
	}	
	
	public void count(int a){
		System.out.println("On the date of the today the total no. of "+this.a.toString()+" is "+a);
	}
	
	public int getToalNo() {
		return a.getTotalNo();
	}	
	
	public boolean isTotalEqual(Machine<?> total){
	     
	    if( a.getTotalNo() == total.getToalNo()){
	    	 return true;
	    }
	    return false;
	} 
		
	public static void main(String arg[]){
		
		Machine<Car> machine1 = new Machine<Car>(new Car(58));
		Machine<Bike> machine2 = new Machine<Bike>(new Bike(59));	
		
		machine1.start();
		machine1.count(machine1.getToalNo());
		machine2.start();
		machine2.count(machine2.getToalNo());
		
		System.out.println("Is total same? "+machine1.isTotalEqual(machine2));
		
	}
	
	
	
}

