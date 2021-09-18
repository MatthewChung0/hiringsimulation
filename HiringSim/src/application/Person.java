package application;

import java.util.ArrayList;

public class Person {

	public String name; 
	public String degree; 
	public ArrayList<String> skill; 
    
	public Person(String name, String degree, ArrayList<String> skill) {
		this.name = name; 
		this.degree = degree; 
		this.skill = skill;
	}

	public String getName() {
		return name; 
	}
	
	public String getDegree() {
		return degree; 
	}
	
	public ArrayList<String> getSkill() {
		return skill; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setDegree(String degree) {
		this.degree = degree; 
	}
	
	public void setSkill(ArrayList<String> skill) {
		this.skill = new ArrayList<String>(); 
	}

	@Override
	public String toString() {
		return name + " " + degree + " " + skill; 
	}

}

