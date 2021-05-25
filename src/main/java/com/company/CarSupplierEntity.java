package com.company;

import javax.persistence.*;

@Entity
@Table(name = "car_supplier", schema = "cardealership")
public class CarSupplierEntity
{
    private int id;
    private CarsEntity carsByIdCar;
    private SuppliersEntity supplierByIdSupplier;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "IDCar", referencedColumnName = "ID")
    public CarsEntity getCarsByIdCar() {
        return carsByIdCar;
    }

    public void setCarsByIdCar(CarsEntity carsByIdCar) {
        this.carsByIdCar = carsByIdCar;
    }

    @ManyToOne
    @JoinColumn(name = "IDSupplier", referencedColumnName = "ID")
    public SuppliersEntity getSupplierByIdSupplier() { return supplierByIdSupplier; }

    public void setSupplierByIdSupplier(SuppliersEntity supplierByIdSupplier) { this.supplierByIdSupplier = supplierByIdSupplier; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarSupplierEntity that = (CarSupplierEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString()
    {
        return "Car - Supplier { id = " + id + ", IdCar = " + carsByIdCar.getId() + ", IdSupplier = " + supplierByIdSupplier.getId() + "}";
    }
}