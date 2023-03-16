import DAO.BrandDAO;
import DAO.ProductDAO;
import model.Brands;
import model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ SẢN PHẨM ---");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Xóa sản phẩm theo mã");
        System.out.println("4. Cập nhật thông tin sản phẩm");
        System.out.println("5. Lấy thông tin hãng sx");
        System.out.println("6. Top 5 sản phẩm có giá trị cao nhất");
        System.out.println("7. Danh sách hãng sản xuất");
        System.out.println("8. Thêm hãng sản xuất");
        System.out.println("9. Xóa hãng sản xuất theo mã");
    }

    private static ProductDAO productDAO = new ProductDAO();
    private static BrandDAO brandDAO=new BrandDAO();
    private static void option1(){
        List<Product> productList = productDAO.getAll();
        System.out.printf("%-30s %-30s %-30s %-30s","STT","Ten san pham","Gia san pham","Mau sac");
        System.out.println();
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            System.out.printf("%-30d %-30s %-30d %-30s",(i+1),p.getProductName(),p.getProductPrice(),p.getProductColor());
        }
        System.out.println();
    }
    private static void option2(Scanner in){
        Product p=new Product();
        System.out.println("Nhap ten: ");
        p.setProductName(in.nextLine());
        System.out.println("Nhap gia: ");
        p.setProductPrice(Integer.parseInt(in.nextLine()));
        System.out.println("Nhap size: ");
        p.setProductSize(in.nextLine());
        System.out.println("Nhap mau: ");
        p.setProductColor(in.nextLine());
        System.out.println("Nhap hang: ");

        List<Brands> list= brandDAO.getAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("-20%d  -20%d",i+1,list.get(i).getBrandName());
        }
        int brand_id= list.get(Integer.parseInt(in.nextLine())-1).getId();

        p.setBrandId(brand_id);

        productDAO.insert(p);
    }
    private static void option4(){

    }
    public static void main(String[] args) {
        int option = -1;
        Scanner in = new Scanner(System.in);
        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng!");
                continue;
            }
            if (option < 1 || option > 9) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }
            // Xu ly cac TH thoa man
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    System.out.println("Nhap ma san pham muon xoa: ");
                    int maSP=in.nextInt();
                    productDAO.delete(maSP);
                    break;
                case 4:
                    System.out.println("Nhap ma san pham muon sua: ");
                    int updateMaSP=in.nextInt();
                    List<Product> list1 = Arrays.asList();
//                    productDAO.update(,updateMaSP);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }

        }
        while (option != 9);
        in.close();

    }
}
