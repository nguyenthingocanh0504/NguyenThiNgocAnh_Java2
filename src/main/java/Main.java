import DAO.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentDAO studentDAO = new StudentDAO();
    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ THÔNG TIN SINH VIÊN ---");
        System.out.println("1. Danh sách sinh viên");
        System.out.println("2. Nhập một sinh viên mới");
        System.out.println("3. Xóa sinh viên theo mã");
        System.out.println("4. Câp nhật thông tin sinh viên");
        System.out.println("5. Tìm một sinh viên theo họ tên hoặc mã");
        System.out.println("6. Sắp xếp sinh viên theo điểm số GPA tăng dần");
        System.out.println("7. Tất cả các sinh viên nữ ở Hà Nội có GPA trên 2.5");
        System.out.println("8. Sắp xếp sinh viên theo họ tên, sắp xếp theo bảng chữ cái abc");
        System.out.println("9. Thoát");
    }

    private static void option1() {
        List<Student> studentList = studentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Student p = studentList.get(i);
            System.out.printf("%-20s %-20s %-20d %-20s\n", p.getId(), p.getFullName(), p.getGender(),p.getAddress());
        };
    }

    private static void option2(Scanner in){
        Student p = new Student();
        System.out.print("\tNhập mã sinh viên: ");
        p.setId(in.nextLine());
        System.out.print("\tNhập họ tên: ");
        p.setFullName(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        p.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập ngày sinh: ");
        p.setDateOfBirth(in.nextLine());
        System.out.print("\tNhập địa chỉ: ");
        p.setAddress(in.nextLine());
        System.out.print("\tNhập số điện thoại: ");
        p.setPhone(in.nextLine());
        System.out.print("\tNhập email: ");
        p.setEmail(in.nextLine());
        System.out.print("\tNhập điểm GPA: ");
        p.setGPA(Double.parseDouble(in.nextLine()));

        studentDAO.insert(p);
    }

    private static void option3(Scanner in){
        StudentDAO studentDAO= new StudentDAO();
        System.out.println("Nhập mã sinh viên muốn xóa: ");
        String maSV = in.nextLine();

        studentDAO.delete(maSV);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());

            if (option < 1 || option > 9) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                    //option4(in);
                    break;
                case 5:
                    break;
                case 6:
                    //option6();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }

        }
        while (option != 0);
        in.close();
    }
}
