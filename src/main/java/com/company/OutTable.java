package com.company;

import com.company.dao.*;
import java.util.List;

public class OutTable
{
    public void PrintCarsTable()
    {
        CarsDao carsDao = new CarsDao();
        List<CarsEntity> cars = carsDao.GetListCars();
        for (CarsEntity car : cars)
        {
            System.out.println(car);
        }
    }
    public void PrintCarSupplierTable()
    {
        CarsSupplerDao carsSupplerDao = new CarsSupplerDao();
        List<CarSupplierEntity> carSupplierEntityList = carsSupplerDao.GetListCarsSupplers();
        for (CarSupplierEntity carSupplierEntity : carSupplierEntityList)
        {
            System.out.println(carSupplierEntity);
        }
    }
    public void PrintClientsTable()
    {
        ClientsDao clientsDao = new ClientsDao();
        List<ClientsEntity> clientsList = clientsDao.GetListClients();
        for (ClientsEntity client : clientsList)
        {
            System.out.println(client);
        }
    }
    public void PrintEmployeersTable()
    {
        EmployeesDao employeersDao = new EmployeesDao();
        List<EmployeersEntity> employeersList = employeersDao.GetListEmployeers();
        for (EmployeersEntity employeer : employeersList)
        {
            System.out.println(employeer);
        }
    }
    public void PrintEngineTypesTable()
    {
        EngineTypesDao engineTypesDao = new EngineTypesDao();
        List<EnginetypesEntity> enginetypesList = engineTypesDao.GetListEngines();
        for (EnginetypesEntity engine : enginetypesList)
        {
            System.out.println(engine);
        }
    }
    public void PrintSalesTable()
    {
        SalesDao salesDao = new SalesDao();
        List<SalesEntity> salesEntityList = salesDao.GetListSales();
        for (SalesEntity sale : salesEntityList)
        {
            System.out.println(sale);
        }
    }
    public void PrintSuppliersTable()
    {
        SuppliersDao suppliersDao = new SuppliersDao();
        List<SuppliersEntity> suppliersList = suppliersDao.GetListSuppliers();
        for (SuppliersEntity supplier : suppliersList)
        {
            System.out.println(supplier);
        }
    }
    public void PrintTransmissionTypesTable()
    {
        TransmissionTypesDao transmissionTypesDao = new TransmissionTypesDao();
        List<TransmissiontypesEntity> transmissionTypesList = transmissionTypesDao.GetListTransmissions();
        for (TransmissiontypesEntity transmis : transmissionTypesList)
        {
            System.out.println(transmis);
        }
    }
}