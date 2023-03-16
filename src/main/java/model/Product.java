package model;

public class Product {
    private int id;
    private String productName;
    private int productPrice;
    private String productSize;
    private String productColor;
    private int brandId;

    public Product() {
    }

    public Product(int id, String productName, int productPrice, String productSize, String productColor, int brandId) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSize = productSize;
        this.productColor = productColor;
        this.brandId = brandId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSize='" + productSize + '\'' +
                ", productColor='" + productColor + '\'' +
                ", brandId=" + brandId +
                '}';
    }
}
