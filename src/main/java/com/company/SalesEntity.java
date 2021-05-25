package com.company;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sales", schema = "cardealership")
public class SalesEntity
{
    private int id;
    private Date dateSale;
    private ClientsEntity clientsByIdClient;
    private CarsEntity carsByIdCar;
    private EmployeersEntity employeersByIdEmployee;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DateSale", nullable = true)
    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesEntity that = (SalesEntity) o;

        if (id != that.id) return false;
        if (dateSale != null ? !dateSale.equals(that.dateSale) : that.dateSale != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (dateSale != null ? dateSale.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IDClient", referencedColumnName = "ID")
    public ClientsEntity getClientsByIdClient() {
        return clientsByIdClient;
    }

    public void setClientsByIdClient(ClientsEntity clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
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
    @JoinColumn(name = "IDEmployee", referencedColumnName = "ID")
    public EmployeersEntity getEmployeersByIdEmployee() {
        return employeersByIdEmployee;
    }

    public void setEmployeersByIdEmployee(EmployeersEntity employeersByIdEmployee)
    {
        this.employeersByIdEmployee = employeersByIdEmployee;
    }
    @Override
    public String toString()
    {
        return "Sale - {id = " + id + ", date = " + dateSale + ", IdClient = " + clientsByIdClient.getId() + ", IdCar" +
                carsByIdCar.getId() + ", IdEmployeer = " + employeersByIdEmployee.getId() + "}";
    }
}