package com.company;

import javax.persistence.*;

@Entity
@Table(name = "transmissiontypes", schema = "cardealership")
public class TransmissiontypesEntity
{
    private int id;
    private String nameTransmission;
    private Integer numberOfGears;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NameTransmission", nullable = true, length = 20)
    public String getNameTransmission() {
        return nameTransmission;
    }

    public void setNameTransmission(String nameTransmission) {
        this.nameTransmission = nameTransmission;
    }

    @Basic
    @Column(name = "NumberOfGears", nullable = true)
    public Integer getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(Integer numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransmissiontypesEntity that = (TransmissiontypesEntity) o;

        if (id != that.id) return false;
        if (nameTransmission != null ? !nameTransmission.equals(that.nameTransmission) : that.nameTransmission != null)
            return false;
        if (numberOfGears != null ? !numberOfGears.equals(that.numberOfGears) : that.numberOfGears != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (nameTransmission != null ? nameTransmission.hashCode() : 0);
        result = 31 * result + (numberOfGears != null ? numberOfGears.hashCode() : 0);
        return result;
    }
    @Override
    public String toString()
    {
        return "TransmissionType - {id = " + id + ", nameTransmission = " + nameTransmission + ", numberOfGears" + numberOfGears + "}";
    }
}