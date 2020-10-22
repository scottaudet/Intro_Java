package A7;


public class Student {
	
	private String firstName = "";		//first name String
	private String lastName = "";		//last name String
	private String studentID = "";		//full student ID
	private String nameCode = "";		//code of first/last/ID
	private int midtermGrade = 0;		//midterm score
	private int finalGrade = 0;			//final score
	
	//default constructor
	public Student() {
		this.studentID = "1111111";
		this.lastName = "Doe";
		this.firstName = "John";
		this.midtermGrade = 50;
		this.finalGrade = 50;
		makeCode(firstName, lastName, studentID);
	}
	
	//parameterized constructor
	public Student(String studentID, String lastName, String firstName, int midtermGrade, int finalGrade) {
		this.studentID = studentID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.midtermGrade = midtermGrade;
		this.finalGrade = finalGrade;
		makeCode(firstName, lastName, studentID);
	}

	//create full name function
	public String getName() {
		return (firstName + " " + lastName);
	}
	
	//accessors and modifiers
	public void setName(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public int getMidtermGrade() {
		return midtermGrade;
	}

	public void setMidtermGrade(int midtermGrade) {
		this.midtermGrade = midtermGrade;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	public String getNameCode() {
		return nameCode;
	}
	
	//function to make code - controlled by class itself
	private String makeCode(String first, String last, String ID) {
		char firstLetter = first.toLowerCase().charAt(0);
		char lastLetter = last.toLowerCase().charAt(0);
		String upperFirst = Character.toString(firstLetter).toUpperCase();
		String upperLast = Character.toString(lastLetter).toUpperCase();
		String lastTwo = ID.substring(ID.length()-2, ID.length());
		nameCode = upperFirst + upperLast + lastTwo;
		return nameCode;
	}
	
	//student code statement, if needed
	public String studentCode() {
		return (getName() + " with ID " + studentID + " has code " + nameCode);
	}
	
	

}
