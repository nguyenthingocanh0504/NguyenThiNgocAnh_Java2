package DAO;

import Connection.MyConnection;
import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM products";
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);

            while (rs.next()) {
                // Tao doi tuong Person rong
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getInt("product_price"));
                p.setProductSize(rs.getString("product_size"));
                p.setProductColor(rs.getString("product_color"));
                p.setBrandId(rs.getInt("brand_id"));

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
    public void insert(Product e) {
        final String sql = String.format("INSERT INTO products VALUES (NULL,'%s','%d','%s','%s','%d')",
                e.getProductName(), e.getProductPrice(), e.getProductSize(), e.getProductColor(), e.getBrandId()
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
    public void delete(long id) {
        try {
            // Buoc 1
            Connection conn = MyConnection.getConnection();
            // Buoc 2
            String sql = "DELETE FROM `products` WHERE id = " + id;
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
    public Product getById(long id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM products WHERE id = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Product e = null;
            if (rs.next()) {
                e = new Product();
                e.setId(rs.getInt("id"));
                e.setProductName(rs.getString("product_name"));
                e.setProductPrice(rs.getInt("product_price"));
                e.setProductSize(rs.getString("product_size"));
                e.setProductColor(rs.getString("product_color"));
                e.setBrandId(rs.getInt("brand_id"));
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
    public void update(Product p, long id) {
        Product tmp = getById(id);
        if(tmp == null){
            System.out.println("Không tồn tại sản phẩm có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE products SET `product_name`='%s',`product_price`='%d',`product_size`='%s',`product_color`='%s',`brand_id`='%d' WHERE `id`='%d' " ,
                p.getProductName(), p.getProductPrice(), p.getProductSize(), p.getProductColor(), p.getBrandId(), id
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
}
