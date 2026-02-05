package student_table.contoller;


import java.util.List;
import java.util.Scanner;

import student_table.connection.Student;
import student_table.dao.StudentDao;

//import student_managent_system.dao.StudentDAO;


public class StudentController {
	



		


		    private StudentDao studentDAO = new StudentDao();
		    private Scanner scanner = new Scanner(System.in);

		    public void addStudent() {
		        System.out.print("Enter student ID: ");
		        int id = scanner.nextInt();
		        scanner.nextLine(); // consume newline
		        System.out.print("Enter student name: ");
		        String name = scanner.nextLine();
		        System.out.print("Enter student email: ");
		        String email = scanner.nextLine();
		        Student student = new Student(id, name, email);
		        studentDAO.addStudent(student);
		        System.out.println("Student added successfully!");
		    }

		    public void viewAllStudents() {
		        List<Student> students = studentDAO.getAllStudents();
		        if (students.isEmpty()) {
		            System.out.println("No students found.");
		        } else {
		            for (Student s : students) {
		                System.out.println(s);
		            }
		        }
		    }

		    public void updateStudent() {
		        System.out.print("Enter student ID to update: ");
		        int id = scanner.nextInt();
		        scanner.nextLine();
		        Student student = studentDAO.getStudent(id);
		        if (student != null) {
		            System.out.print("Enter new name: ");
		            String name = scanner.nextLine();
		            System.out.print("Enter new email: ");
		            String email = scanner.nextLine();
		            student.setName(name);
		            student.setEmail(email);
		            studentDAO.updateStudent(student);
		            System.out.println("Student updated successfully!");
		        } else {
		            System.out.println("Student not found.");
		        }
		    }

		    public void deleteStudent() {
		        System.out.print("Enter student ID to delete: ");
		        int id = scanner.nextInt();
		        studentDAO.deleteStudent(id);
		        System.out.println("Student deleted successfully!");
		    }
		}
		
		




