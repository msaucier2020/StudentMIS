/*
 * an Interface for student lists
 * @author- Madeleine Saucier
 */
package assg6_saucierm20;

import java.util.ArrayList;

public interface StudentListInterface {

	/*
	 * load data from input file
	 * @param input file name
	 */
	public void loadData(String filename);
	
	/*
	 * display student roster
	 */
	public void displayRoster();
	
	/*
	 * search by ID
	 * @param student ID to search for
	 * @return student with ID if found; if student does not exist, return null
	 */
	public Student searchForStudent(String searchID);
	
	/*
	 * add student to list
	 * @param id, name, standing, and major of new student
	 * @return true if student is added, false if not
	 */
	public boolean addStudent(String id, String name, String stand, String maj);
	
	/*
	 * remove student from list
	 * @param id of student to be removed
	 * @return true if student is removed, false if not
	 */
	public boolean removeStudent(String id);
	
	/*
	 * get list of students with a specific major
	 * @param major to search for
	 * @return ArrayList of type Student containing students with major that was searched for
	 */
	public ArrayList<Student> getStudentsByMajor(String maj);
	
	/*
	 * sort list by ID
	 */
	public void sort();
	
	/*
	 * save to same file that input came from
	 */
	public void save();

}
