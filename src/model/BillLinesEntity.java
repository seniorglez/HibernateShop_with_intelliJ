package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bill_lines", schema = "shop", catalog = "")
public class BillLinesEntity {
    private int id;
    private int billId;
    private int productId;
    private int units;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bill_id", nullable = false)
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "units", nullable = false)
    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillLinesEntity that = (BillLinesEntity) o;
        return id == that.id &&
                billId == that.billId &&
                productId == that.productId &&
                units == that.units;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billId, productId, units);
    }
}
