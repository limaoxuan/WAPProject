package model;

public class Product {
    private String  id;
    private String productName;
    private String productDes;
    private Double price;
    private String productUrl;


    public Product(String productName, String productDes, Double price, String productUrl) {
        this.productName = productName;
        this.productDes = productDes;
        this.price = price;
        this.productUrl = productUrl;
    }

    public Product(String id, String productName, String productDes, Double price, String productUrl) {
        this.id = id;
        this.productName = productName;
        this.productDes = productDes;
        this.price = price;
        this.productUrl = productUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDes() {
        return productDes;
    }

    public Double getPrice() {
        return price;
    }

    public String getProductUrl() {
        return productUrl;
    }
}
