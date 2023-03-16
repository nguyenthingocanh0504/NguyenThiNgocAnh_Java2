package model;

public class Brands {
    private int id;
    private String brandName;
    private String brandAddress;

    public Brands() {
    }

    public Brands(int id, String brandName, String brandAddress) {
        this.id = id;
        this.brandName = brandName;
        this.brandAddress = brandAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandAddress() {
        return brandAddress;
    }

    public void setBrandAddress(String brandAddress) {
        this.brandAddress = brandAddress;
    }

    @Override
    public String toString() {
        return "Brands{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", brandAddress='" + brandAddress + '\'' +
                '}';
    }

}
