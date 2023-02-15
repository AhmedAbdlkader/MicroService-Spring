package my.micro.builingservice.entity;

import lombok.*;
import my.micro.builingservice.dto.Customers;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Builder
@ToString
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date billdate;

    private long customerId;

    @Transient
    private Customers customers;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;


    public Bill(long id, Date billdate, long customerId, Customers customers, List<ProductItem> productItems) {
        this.id = id;
        this.billdate = billdate;
        this.customerId = customerId;
        this.customers = customers;
        this.productItems = productItems;
    }

    public Bill() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }
}
