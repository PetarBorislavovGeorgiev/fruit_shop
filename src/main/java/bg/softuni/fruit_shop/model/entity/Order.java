package bg.softuni.fruit_shop.model.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @Column(name = "date_created")
    private LocalDate dateCreated;


    @ManyToOne(optional = false)
    private User customer;

    @ManyToMany
    private List<CartItem> items;

    @ManyToOne(optional = false)
    private Address address;

    public Order() {
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
