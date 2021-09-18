package application;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Scanner;

public class HiringApp {

    public static void main(String[] args) {
  
    	Queue<Person> exEmployee = new LinkedList<>();
    	Deque<Person> hire = new ArrayDeque<>();
    	LinkedList<Person> applicants = new LinkedList<>();

    	int value = getChoice();
    	while(value != 4) {
    		if(value == 1) {
    			applicants.add(getApplication());
    			//System.out.println(applicants);
    			value = getChoice();
    		}
    		if(value == 2 && applicants.isEmpty() && exEmployee.isEmpty()) {
    			System.out.println("The list is empty"); 
    			value = getChoice();
    		}
    		else if(value == 2 && exEmployee.isEmpty() == false) {
    			Person rehire = exEmployee.poll();
    			hire.add(rehire);
    			System.out.println(rehire.getName() + " was hired");
    			value = getChoice();
    		}
    		else if(value == 2 && exEmployee.isEmpty() && applicants.isEmpty() == false) {
    			Person newApplicant = applicants.remove();
    			hire.add(newApplicant);
    			System.out.println(newApplicant.getName() + " was hired");
    			value = getChoice();
    		}
    		else if(value == 2 && applicants.isEmpty()) {
    			System.out.println("There are no more applicants");
    			value = getChoice();
    		}
    		
    		if(value == 3 && hire.size() >= 1) {
    			Person fired = hire.removeLast(); 
    			exEmployee.add(fired); 
    			System.out.println(fired.getName() + " was fired");
    			value = getChoice();
    		}
    		else if(value == 3 && exEmployee.isEmpty()) {
    			System.out.println("The list is empty");
    			System.out.println("\n");
    			value = getChoice();
    		}
    		
    		if(value == 3 && hire.isEmpty()) {
    			System.out.println("There is no one left to fire"); 
    			value = getChoice();
    		}
    	}
        
    }
    
    public static void displayMenu() {
    	System.out.println("Please choose one of these methods: ");
    	System.out.println("1. Accept an application");
    	System.out.println("2. Hire the applicant");
    	System.out.println("3. Fire the employee"); 
    	System.out.println("4. Exit");
    	System.out.println("Please enter your choice: ");
    }
    
    public static int getChoice() {
        
    	displayMenu();
    	Scanner menu = new Scanner(System.in);
    	int choice = menu.nextInt(); 
    	return choice; 
        
    }

    public static Person getApplication() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Please enter your name");
    	String name = scan.nextLine();
        
    	System.out.println("Please enter your degree: ");
    	String degree = scan.nextLine();

    	System.out.println("Please enter how many skills you have: ");
    	int totalSkills = scan.nextInt();
    	scan.nextLine();
    	
    	ArrayList<String> skillList = new ArrayList<String>();
    	for(int i = 0; i < totalSkills; i++) {
    		System.out.println("Please enter your skills: ");
    		String skill = scan.nextLine();
    		skillList.add(skill);
    	}

    	Person result = new Person(name, degree, skillList);
    	return result; 
        
    }
}