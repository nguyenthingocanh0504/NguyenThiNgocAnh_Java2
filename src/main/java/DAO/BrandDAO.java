package DAO;

import model.Brands;
import Connection.MyConnection;
import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {
    public List<Brands> getAll(){
        List<Brands> brandsList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM brands";
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);

            while (rs.next()) {
                // Tao doi tuong Person rong
                Brands p = new Brands();
                p.setId(rs.getInt("id"));
                p.setBrandName(rs.getString("brand_name"));
                p.setBrandAddress(rs.getString("brand_address"));

                brandsList.add(p);
            }
            // Buoc 4
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandsList;
    }
    public List<Product> getAllProductByBrand(int brandID){
        final String sql = "Select* from `products` where `brand_id`="+brandID;
        List<Product> productList=new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);

            while (rs.next()) {
                // Tao doi tuong Person rong
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setProductName(rs.getString("product_name"));
                p.setProductSize(rs.getString("product_size"));
                p.setProductColor(rs.getString("product_color"));
                p.setProductPrice(rs.getInt("product_price"));
                p.setBrandId(brandID);

                productList.add(p);
            }
            // Buoc 4
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    public void insertBrand(Brands e) {
        final String sql = String.format("INSERT INTO brands VALUES (NULL,'%s','%s')",
                e.getBrandName(), e.getBrandAddress()
        );

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Thêm thất bại!");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Brands getByIdBrand(long id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM brands WHERE id = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Brands e = null;
            if (rs.next()) {
                e = new Brands();
                e.setId(rs.getInt("id"));
                e.setBrandName(rs.getString("brand_name"));
                e.setBrandAddress(rs.getString("brand_address"));

            }
            rs.close();
            stmt.close();
            conn.close();
            return e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateBrand(Brands p, long id) {
        Brands tmp = getByIdBrand(id);
        if(tmp == null){
            System.out.println("Không tồn tại hang sản xuất có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE brands SET `brand_name`='%s',`brand_address`='%s' WHERE `id`='%d' " ,
                p.getBrandName(), p.getBrandAddress(), id
        );

        System.out.println(sql);
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void deleteBrand(long id) {
        try {
            // Buoc 1
            Connection conn = MyConnection.getConnection();
            // Buoc 2
            String sql = "DELETE FROM `brands` WHERE id = " + id;
            // Buoc 3
            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
