import java.util.Scanner;
class Student{
	private String name;
	private int e1;
	private int e2;
	private int e3;
	
	Student(String name,int e1,int e2,int e3){
		this.name=name;
		if (validateMarks(e1)&&validateMarks(e2)&&validateMarks(e3)) {
			this.e1 = e1;
			this.e2 = e2;
			this.e3 = e3;
		}else{
			throw new IllegalArgumentException("Marks must be between 0 and 100");
		}
	}
		
		
		
	
	boolean validateMarks(int marks){
		if (marks<=100 && marks>=0){
			return true;
		}else{
			return false;
		}
	}
	public int getExam1(){
		return e1;
	}
	public int getExam2(){
		return e2;
	}
	public int getExam3(){
		return e3;
	}
	
	public double calculateAverage(){
		double ave=(e1+e2+e3)/3;
		return ave;
	}
	
}
class Main{
	public static void main(String []args){
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter the Name :");
		String name=sc.nextLine();
		System.out.print("Enter marks for Exam1 :");
		int e1=sc.nextInt();
		System.out.print("Enter marks for Exam2 :");
		int e2=sc.nextInt();
		System.out.print("Enter marks for Exam3 :");
		int e3=sc.nextInt();
		try{
			Student st=new Student(name,e1,e2,e3);
			System.out.println(name+",s Average mark is "+st.calculateAverage());
		}catch(IllegalArgumentException e){
			System.out.println("Error :"+ e.getMessage());
		}
		
}
}
