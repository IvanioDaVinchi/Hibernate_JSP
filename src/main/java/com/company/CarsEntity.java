package com.company;

import javax.persistence.*;

@Entity
@Table(name = "cars", schema = "cardealership")
public class CarsEntity
{
    private int id;
    private String carBrand;
    private String carModel;
    private Double speed;
    private Double racing;
    private String carColor;
    private Integer price;
    private EnginetypesEntity engineTypeByIdEngine;
    private TransmissiontypesEntity transmissiontypesEntityByIdTransmission;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CarBrand", nullable = true, length = 30)
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @Basic
    @Column(name = "CarModel", nullable = true, length = 30)
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Basic
    @Column(name = "Speed", nullable = true, precision = 0)
    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "Racing", nullable = true, precision = 0)
    public Double getRacing() {
        return racing;
    }

    public void setRacing(Double racing) {
        this.racing = racing;
    }

    @Basic
    @Column(name = "CarColor", nullable = true, length = 20)
    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Basic
    @Column(name = "Price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarsEntity that = (CarsEntity) o;

        if (id != that.id) return false;
        if (carBrand != null ? !carBrand.equals(that.carBrand) : that.carBrand != null) return false;
        if (carModel != null ? !carModel.equals(that.carModel) : that.carModel != null) return false;
        if (speed != null ? !speed.equals(that.speed) : that.speed != null) return false;
        if (racing != null ? !racing.equals(that.racing) : that.racing != null) return false;
        if (carColor != null ? !carColor.equals(that.carColor) : that.carColor != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (carBrand != null ? carBrand.hashCode() : 0);
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (racing != null ? racing.hashCode() : 0);
        result = 31 * result + (carColor != null ? carColor.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
    @Override
    public String toString()
    {
        return "Car {id = " + String.valueOf(id) + ", brand = "+ carBrand + ", model = " + carModel +
                "Speed = " + speed + ", racing = " + racing + ", carColor =  " + carColor + ", price = " + price + "}";
    }
    @ManyToOne
    @JoinColumn(name = "EngineType", referencedColumnName = "ID")
    public EnginetypesEntity getEngineTypeByIdEngine() {
        return engineTypeByIdEngine;
    }

    public void setEngineTypeByIdEngine(EnginetypesEntity engineTypeByIdEngine) { this.engineTypeByIdEngine = engineTypeByIdEngine; }

    @ManyToOne
    @JoinColumn(name = "TransmissionType", referencedColumnName = "ID")
    public TransmissiontypesEntity getTransmissionTypeByIdTransmission() {
        return transmissiontypesEntityByIdTransmission;
    }

    public void setTransmissionTypeByIdTransmission(TransmissiontypesEntity transmissiontypesEntityByIdTransmission)
    {
        this.transmissiontypesEntityByIdTransmission = transmissiontypesEntityByIdTransmission;
    }
}