package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "shop", catalog = "")
public class ProductsEntity {
    private int idProduct;
    private String description;
    private double price;

    @Id
    @Column(name = "idProduct", nullable = false)
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 40)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return idProduct == that.idProduct &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, description, price);
    }

    @Override
    public String toString() {
        return description +" - "+ price + " €";
    }
}
