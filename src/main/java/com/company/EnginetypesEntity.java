package com.company;

import javax.persistence.*;

@Entity
@Table(name = "enginetypes", schema = "cardealership")
public class EnginetypesEntity
{
    private int id;
    private String nameEngine;
    private Double engineCapacity;
    private Integer enginePower;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NameEngine", nullable = true, length = 20)
    public String getNameEngine() {
        return nameEngine;
    }

    public void setNameEngine(String nameEngine) {
        this.nameEngine = nameEngine;
    }

    @Basic
    @Column(name = "EngineCapacity", nullable = true, precision = 0)
    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Basic
    @Column(name = "EnginePower", nullable = true)
    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnginetypesEntity that = (EnginetypesEntity) o;

        if (id != that.id) return false;
        if (nameEngine != null ? !nameEngine.equals(that.nameEngine) : that.nameEngine != null) return false;
        if (engineCapacity != null ? !engineCapacity.equals(that.engineCapacity) : that.engineCapacity != null)
            return false;
        if (enginePower != null ? !enginePower.equals(that.enginePower) : that.enginePower != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (nameEngine != null ? nameEngine.hashCode() : 0);
        result = 31 * result + (engineCapacity != null ? engineCapacity.hashCode() : 0);
        result = 31 * result + (enginePower != null ? enginePower.hashCode() : 0);
        return result;
    }
    @Override
    public String toString()
    {
        return "EngineTypes - {id = " + id + ", nameEngine = " + nameEngine + ", engineCapacity = " + engineCapacity + ", enginePower = " + enginePower + "}";
    }
}