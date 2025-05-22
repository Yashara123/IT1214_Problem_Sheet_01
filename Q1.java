import java.util.Scanner;

class Student {
    
    private int studentId;
	private String name;
    private int daysattended;

    Student(int studentId ,String name, int daysattended) {
       
        this.studentId = studentId;
		this.name = name;
        this.daysattended = daysattended;
    }
   
    public int getStudentId() {
        return studentId;
    }
	 public String getName() {
        return name;
    }
    public int getDaysattended() {
        return daysattended;
    }
   
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
	 public void setName(String name) {
        this.name = name;
    }
    public void setDaysattended(int daysattended) {
        this.daysattended = daysattended;
    }
    

}
class Classroom{
    Student[] students=new Student[10]; 
    int studentCount=0;
    public void addStudent(Student student){
        if(studentCount<students.length){
            students[studentCount]=student;
            studentCount++;
        }else{
            System.out.println("Classroom is full");
        }
    }
	
    public void updateDaysattended(int studentId, int daysattended){
		int count=0;
		boolean stcheck=false;
        for(int x=0;x<studentCount;x++){
            if(students[x].getStudentId()==studentId){
                stcheck=true;
				count=x;
				break;
			}
        }
		if(stcheck==true){
			students[count].setDaysattended(daysattended);
            System.out.println("Days attended for student ID: " + studentId);
        }else{
			System.out.println("Student not found");
		}
    }
    public void displayStudents(){
        for(int x=0;x<studentCount;x++){
            System.out.println("Name: " + students[x].getName() + ", Student ID: " + students[x].getStudentId() + ", Days Attended: " + students[x].getDaysattended());
        }
    }
}
class StudentMain{
    public static void main(String[] args){
        Classroom classroom=new Classroom();
        Student s1=new Student("Alice smith", 101, 12);
        Student s2=new Student("Bob Jones", 102, 15); 
        Student s3=new Student("Carol Lee", 103, 10);
        classroom.addStudent(s1);
        classroom.addStudent(s2);
        classroom.addStudent(s3);
        classroom.updateDaysattended(104, 16);
        classroom.updateDaysattended(104, 16);
        classroom.displayStudents();
    }
}