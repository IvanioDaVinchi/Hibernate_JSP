package com.company;
import javax.persistence.*;

@Entity
@Table(name = "suppliers", schema = "cardealership")
public class SuppliersEntity
{
    private int id;
    private String nameSupplier;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NameSupplier", nullable = true, length = 20)
    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SuppliersEntity that = (SuppliersEntity) o;

        if (id != that.id)
            return false;
        if (nameSupplier != null ? !nameSupplier.equals(that.nameSupplier) : that.nameSupplier != null)
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (nameSupplier != null ? nameSupplier.hashCode() : 0);
        return result;
    }
    @Override
    public String toString()
    {
        return "Supplier {id = " + id + ", nameSupplier = " + nameSupplier + "}";
    }
}