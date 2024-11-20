package Bean;

public class Product {
    private String productName;
    private String productModel;
    private String productNumber;
    private String productPrice;

    public Product() {
    }

    public Product(String productName, String productModel, String productNumber, String productPrice) {
        this.productName = productName;
        this.productModel = productModel;
        this.productNumber = productNumber;
        this.productPrice = productPrice;
    }

    /**
     * 获取
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取
     * @return productModel
     */
    public String getProductModel() {
        return productModel;
    }

    /**
     * 设置
     * @param productModel
     */
    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    /**
     * 获取
     * @return productNumber
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * 设置
     * @param productNumber
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    /**
     * 获取
     * @return productPrice
     */
    public String getProductPrice() {
        return productPrice;
    }

    /**
     * 设置
     * @param productPrice
     */
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String toString() {
        return "Product{productName = " + productName + ", productModel = " + productModel + ", productNumber = " + productNumber + ", productPrice = " + productPrice + "}";
    }
}
