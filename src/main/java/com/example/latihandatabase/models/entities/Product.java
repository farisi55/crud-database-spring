package com.example.latihandatabase.models.entities;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;



@Entity
@Table(name = "tbl_product")
@SQLDelete(sql = "UPDATE tbl_product SET deleted = true Where id=?")

public class Product implements Serializable {

    private static final long  serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message =  "name is require")
    @Column(name = "product_name", length = 100)
    private String name;

    @NotEmpty(message =  "Description is require")
    @Column(name = "product_description", length = 500)
    private String description;

    private double price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable (
            name = "tbl_product_supplier",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<Supplier> suppliers;

    private boolean deleted = Boolean.FALSE;

    public Product(){}

    public Product(Long id, String name, String description, double price, Category category){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
