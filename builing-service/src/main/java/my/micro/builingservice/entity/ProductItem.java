package my.micro.builingservice.entity;

import lombok.*;
import my.micro.builingservice.dto.Product;

import javax.persistence.*;

@Entity
@Builder
@ToString
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long productId;
    @ManyToOne()
    private Bill bill;
    private int quantity;

    @Transient
    private Product product;
    private double discount;

    public ProductItem(long id, long productId, Bill bill, int quantity, Product product, double discount) {
        this.id = id;
        this.productId = productId;
        this.bill = bill;
        this.quantity = quantity;
        this.product = product;
        this.discount = discount;
    }

    public ProductItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
