package student_table.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student_table.connection.Student;

public class StudentDao {

	
	



	    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
	    private static final String USER = "root";
	    private static final String PASSWORD = "@Sahil_2030";  

	    public StudentDao() {
	        try {
//	        	Step 1 load/Register Driver
	            Class.forName("com.mysql.cj.jdbc.Driver"); 
//	            Step 2 create connection
	            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//	            	Step 3	Create statement
	                 Statement stmt = conn.createStatement()) {
//	            step 4	Execute query
	                String sql = "CREATE TABLE IF NOT EXISTS studenttable (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))";
	                stmt.execute(sql);
	                System.out.println("Database connected and table created successfully.");
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("H2 Driver not found: " + e.getMessage());
	        } catch (SQLException e) {
	            System.out.println("Database connection error: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    public void addStudent(Student student) {
	        String sql = "INSERT INTO studenttable (id, name, email) VALUES (?, ?, ?)";
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, student.getId());
	            pstmt.setString(2, student.getName());
	            pstmt.setString(3, student.getEmail());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Student getStudent(int id) {
	        String sql = "SELECT * FROM studenttable WHERE id = ?";
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public List<Student> getAllStudents() {
	        List<Student> students = new ArrayList<>();
	        String sql = "SELECT * FROM studenttable";
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return students;
	    }

	    public void updateStudent(Student student) {
	        String sql = "UPDATE studenttable SET name = ?, email = ? WHERE id = ?";
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, student.getName());
	            pstmt.setString(2, student.getEmail());
	            pstmt.setInt(3, student.getId());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteStudent(int id) {
	        String sql = "DELETE FROM studenttable WHERE id = ?";
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	

