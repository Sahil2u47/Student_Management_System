package student_table.connection;

import java.util.Scanner;

import student_table.contoller.StudentController;


public class Main {
	
	



	    public static void main(String[] args) {
	        StudentController controller = new StudentController();
	        
	        try (Scanner scanner = new Scanner(System.in)) {
	            while (true) {
	                System.out.println("\nStudent Management System");
	                System.out.println("1. Add Student");
	                System.out.println("2. View All Students");
	                System.out.println("3. Update Student");
	                System.out.println("4. Delete Student");
	                System.out.println("5. Exit");
	                System.out.print("Choose an option: ");
	                int choice = scanner.nextInt();
	                switch (choice) {
	                    case 1:
	                        controller.addStudent();
	                        break;
	                    case 2:
	                        controller.viewAllStudents();
	                        break;
	                    case 3:
	                        controller.updateStudent();
	                        break;
	                    case 4:
	                        controller.deleteStudent();
	                        break;
	                    case 5:
	                        System.out.println("Exiting...");
	                        return;
	                    default:
	                        System.out.println("Invalid option. Try again.");
	                }
	            }
	        }
	    }
	}
	


