package DAO;

import Connection.MyConnection;
import java.sql.Connection;
import model.Student;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getAll() {
        final String sql = "SELECT * FROM `students`";

        List<Student>  studentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student p = new Student();
                p.setId(rs.getString("id"));
                p.setFullName(rs.getString("full_name"));
                p.setGender(rs.getInt("gender"));
                p.setDateOfBirth(rs.getString("date_of_birth"));
                p.setAddress(rs.getString("address"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setGPA(rs.getDouble("GPA"));

                studentList.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
    public void insert(Student p) {
        final String sql = String.format("INSERT  INTO `students` VALUES ( '%s','%s','%d','%s','%s','%s','%s','%f' ) ",
                p.getId(), p.getFullName(), p.getGender(), p.getDateOfBirth(), p.getAddress(),p.getPhone(),p.getEmail(),p.getGPA()
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student getById(String id) {
        final String sql = "SELECT * FROM `students` WHERE  `id` = " + id;
        Student p = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                p = new Student();
                p.setId(rs.getString("id"));
                p.setFullName(rs.getString("full_name"));
                p.setGender(rs.getInt("gender"));
                p.setDateOfBirth(rs.getString("date_of_birth"));
                p.setAddress(rs.getString("address"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setGPA(rs.getDouble("GPA"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    public void delete(String id) {
        Student student = getById(id);
        if (student == null) {
            throw new RuntimeException("Sinh viên không tồn tại!");
        }

        final String sql = "DELETE FROM `students` WHERE  `id` = " + id;
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
