/*
 * A class for a Student object
 * @author - Madeleine Saucier
 */

package assg6_saucierm20;

public class Student implements Comparable<Student>{

	private String id;
	private String name;
	private String standing;
	private String major;
	
	public Student(String stuID, String stuName, String stuStand, String stuMaj) {
		id = stuID;
		name = stuName;
		standing = stuStand;
		major = stuMaj;
	}
	
	/*
	 * method to retrieve student ID
	 * @return id
	 */
	public String getID() {
		return id;
	}
	
	/*
	 * method to retrieve name of student
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * method to retrieve student standing(freshman,sophomore,junior,or senior)
	 * @return standing
	 */
	public String getStand() {
		return standing;
	}
	
	/*
	 * method to retrieve major of student 
	 * @return major
	 */
	public String getMaj() {
		return major;
	}
	
	/*
	 * method to change student major
	 * @param new major
	 */
	public void setMaj(String newMaj) {
		major = newMaj;
	}
	
	/*
	 * method to turn all student information into a string
	 * @return String with all student info
	 */
	public String toString() {
		return  id +"," + name + "," + standing + "," + major;
	}
	
	/*
	 * method to see if two students are equal
	 * @param student as an object type
	 * @return true if same id, false if different id or object is not instance of student
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student temp = (Student)obj;
			return this.id.equals(temp.id);
		}
		else {
			return false;
		}
	}
	
	/*
	 * method to compare two students
	 * @param student to be compared
	 * @return in order of student id (0 if same, -1 if this student comes after compStu, 1 if this student comes before compStu)
	 */
	public int compareTo(Student compStu) {
		return this.id.compareTo(compStu.id);
	}
	
}
