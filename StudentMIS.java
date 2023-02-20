/*
 * main method for Student MIS
 * @author- Madeleine Saucier
 */
package assg6_saucierm20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentMIS {

	public static void main(String[] args) {
		
		StudentList roster = new StudentList();
		ArrayList<Student> majorList = new ArrayList<Student>();
		String option, search, newID, newName, newStand, newMaj;
		Student stu;
		Scanner kbd = new Scanner(System.in);
		
		//load data from input file
		roster.loadData("assg6_data.txt");
		
		//display menu and use switch to perform specific functions
		do {
			System.out.println("Select an option: ");
			System.out.println("1. Display the roster");
			System.out.println("2. Search for a student by ID");
			System.out.println("3. Add a new student");
			System.out.println("4. Remove a student");
			System.out.println("5. Search for students by major");
			System.out.println("6. Sort and save to file");
			System.out.println("7. Save to file");
			System.out.println("8. Exit");
			
			option = kbd.nextLine();
			
			switch(option) {
			
				//display roster
				case "1":
					roster.displayRoster();
					break;
					
				//search by ID
				case "2":
					System.out.println("Enter ID to search for: ");
					search = kbd.next();
					stu = roster.searchForStudent(search);
					if(stu == null) {
						System.out.println("Error: Student " + search + " not found.");
					}
					else {
						System.out.println(stu.toString());
					}
					break;
				
				//add student; if ID already exists, display error
				case "3":
					System.out.println("Enter ID of new student: ");
					newID = kbd.nextLine();
					stu = roster.searchForStudent(newID);
					if(stu!=null) {
						System.out.println("Error: Student " + newID + " already exists.");
					}
					else {
						System.out.println("Enter name of new student: ");
						newName = kbd.nextLine();
						
						System.out.println("Enter standing of new student: ");
						newStand = kbd.nextLine();
						
						System.out.println("Enter major of new student: ");
						newMaj = kbd.nextLine();
						
						roster.addStudent(newID, newName, newStand, newMaj);
					}
					break;
				
				//remove student; if ID does not exist, display error
				case "4":
					System.out.println("Enter ID to remove: ");
					search = kbd.nextLine();
					stu = roster.searchForStudent(search);
					if(stu == null) {
						System.out.println("Error: Student " + search + " not found.");
					}
					else {
						roster.removeStudent(search);
					}
					break;
		
				//search by major; if no students have that major, display error
				case "5":
					System.out.println("Enter major to search for: ");
					search = kbd.nextLine();
					majorList = roster.getStudentsByMajor(search);
					Iterator<Student> iter = majorList.iterator();
					
					if(majorList.size() == 0) {
						System.out.println("Error: No students majoring in " + search);
					}
					else {
						while(iter.hasNext()) {
							System.out.println(iter.next().toString());
						}
					}
					break;
				
				//sort and save
				case "6":
					roster.sort();
					roster.save();
					break;
				
				//save
				case "7":
					roster.save();
					break;
					
				//exit program
				case "8":
					break;
				
				//error message if option is not inf range 1-8
				default:
					System.out.println("Invalid option entered.");
					break;
			}
			
			System.out.println("\n");
			
		}while(!option.equals("8"));
		
		kbd.close();
	}
}
