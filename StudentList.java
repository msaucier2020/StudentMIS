package assg6_saucierm20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class StudentList implements StudentListInterface{

	private ArrayList<Student> studentRoster;
	
	/*
	 * default constructor
	 */
	public StudentList() {
		studentRoster = new ArrayList<Student>();
	}
	
	/*
	 * load data from input file
	 * @param input file name
	 */
	public void loadData(String filename) {
		Scanner input;
		String line;
		line = null;
		input = null;
		
		try {
			input = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening file " + filename);
			System.exit(0);
		}
		
		while(input.hasNextLine()) {
			line = input.nextLine();
			
			int index = line.indexOf(',');
			String id = line.substring(0,index);
			line = line.substring(index+1);
			
			index = line.indexOf(',');
			String name = line.substring(0, index);
			line = line.substring(index+1);
			
			index = line.indexOf(',');
			String stand = line.substring(0, index);
			line = line.substring(index+1);
			
			String major = line;
			
			studentRoster.add(new Student(id, name, stand, major));
		}
		input.close();
	}
	
	/*
	 * display student roster
	 */
	public void displayRoster() {
		for(int i = 0; i < studentRoster.size(); i++) {
			System.out.println(studentRoster.get(i).toString());
		}
	}
	
	/*
	 * search by ID
	 * @param student ID to search for
	 * @return student with ID if found; if student does not exist, return null
	 */
	public Student searchForStudent(String searchID) {
		Iterator<Student> iter = studentRoster.iterator();
		
		while(iter.hasNext()) {
			Student stu = iter.next();
			if(stu.getID().equals(searchID)) {
				return stu;
			}
		}
		
		return null;
	}
	
	/*
	 * add student to list
	 * @param id, name, standing, and major of new student
	 * @return true if student is added, false if not
	 */
	public boolean addStudent(String id, String name, String stand, String maj) {
		if(this.searchForStudent(id) != null) {
			return false;
		}
		else {
			studentRoster.add(new Student(id, name, stand, maj));
			return true;
		}
	}
	
	/*
	 * remove student from list
	 * @param id of student to be removed
	 * @return true if student is removed, false if not
	 */
	public boolean removeStudent(String id) {
		if(this.searchForStudent(id) == null) {
			System.out.println("Student " + id + " does not exist.");
			return false;
		}
		else {
			studentRoster.remove(this.searchForStudent(id));
			return true;
		}
	}

	/*
	 * get list of students with a specific major
	 * @param major to search for
	 * @return ArrayList of type Student containing students with major that was searched for
	 */
	public ArrayList<Student> getStudentsByMajor(String maj){
		ArrayList<Student> majorList = new ArrayList<Student>();
		Iterator<Student> iter = studentRoster.iterator();
		
		while(iter.hasNext()) {
			Student stu = iter.next();
			if(stu.getMaj().equals(maj)) {
				majorList.add(stu);
			}
		}
		
		return majorList;
	}

	/*
	 * sort list by ID
	 */
	public void sort() {
		Collections.sort(studentRoster);
	}
	
	/*
	 * save to same file that input came from
	 */
	public void save() {
		PrintWriter outputStream = null;
		Iterator<Student> iter = studentRoster.iterator();
		String filename = "assg6_data.txt";
		String line;
		
		try {
			outputStream = new PrintWriter(filename);
		}
		catch(IOException e) {
			System.out.println("Error opening file assg6_data.txt");
			System.exit(0);
		}
		
		while(iter.hasNext()) {
			line = iter.next().toString();
			outputStream.println(line);
		}
		
		outputStream.close();
	}

}
