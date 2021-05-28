package com.company.Handlers;

import com.company.*;
import com.company.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InsertHandler
{
    static Scanner in = new Scanner(System.in);
    public void InsertInCars(String carBrand, String carModel, Double speed, Double racing, int engineType, int transmissionType, String color, int price)
    {
        EngineTypesDao engineDao = new EngineTypesDao();
        EnginetypesEntity engine = engineDao.GetObjectWithID(engineType);
        TransmissionTypesDao transmissionDao = new TransmissionTypesDao();
        TransmissiontypesEntity transmission = transmissionDao.GetObjectWithID(transmissionType);
        CarsEntity car = new CarsEntity();
        car.setCarBrand(carBrand);
        car.setCarModel(carModel);
        car.setEngineTypeByIdEngine(engine);
        car.setTransmissionTypeByIdTransmission(transmission);
        car.setSpeed(speed);
        car.setRacing(racing);
        car.setCarColor(color);
        car.setPrice(price);
        CarsDao carsDao = new CarsDao();
        List<CarsEntity> listCars = carsDao.GetListCars();
        car.setId(listCars.size()+1);
        carsDao.Insert(car);
    }
    public void InsertInCarSupplier(int idCar, int idSupplier)
    {
        CarsDao carsDao = new CarsDao();
        CarsEntity car = carsDao.GetObjectWithID(idCar);
        SuppliersDao suppliersDao = new SuppliersDao();
        SuppliersEntity supplier = suppliersDao.GetObjectWithID(idSupplier);
        CarSupplierEntity carSupplier = new CarSupplierEntity();
        CarsSupplerDao carsSupplerDao = new CarsSupplerDao();
        List<CarSupplierEntity> carSupplierList = carsSupplerDao.GetListCarsSupplers();
        carSupplier.setCarsByIdCar(car);
        carSupplier.setSupplierByIdSupplier(supplier);
        carSupplier.setId(carSupplierList.size()+1);
        carsSupplerDao.Insert(carSupplier);
    }
    public void InsertInClient(String fName, String sName, String patronymic, String phoneNumber)
    {
        ClientsDao clientsDao = new ClientsDao();
        List<ClientsEntity> listClients = clientsDao.GetListClients();
        ClientsEntity client = new ClientsEntity();
        client.setId(listClients.size() + 1);
        client.setFirstName(fName);
        client.setSecondName(sName);
        client.setPatronymic(patronymic);
        client.setPhoneNumber(phoneNumber);
        clientsDao.Insert(client);
    }
    public void InsertInSuppliers(String nameSupplier)
    {
        SuppliersDao suppliersDao = new SuppliersDao();
        SuppliersEntity supplier = new SuppliersEntity();
        List<SuppliersEntity> listSuppliers = suppliersDao.GetListSuppliers();
        supplier.setId(listSuppliers.size() + 1);
        supplier.setNameSupplier(nameSupplier);
        suppliersDao.Insert(supplier);
    }
    public void InsertInEmployees(String fName, String sName, String patronymic, String phoneNumber, String position)
    {
        EmployeesDao employeesDao = new EmployeesDao();
        List<EmployeersEntity> listEployees = employeesDao.GetListEmployeers();
        EmployeersEntity employee = new EmployeersEntity();
        employee.setId(listEployees.size() + 1);
        employee.setFirstName(fName);
        employee.setSecondName(sName);
        employee.setPatronymic(patronymic);
        employee.setPhoneNumber(phoneNumber);
        employee.setPosition(position);
        employeesDao.Insert(employee);
    }
    public void InsertInEngineTypes(String nameEngine, Double capacity, int power)
    {
        EngineTypesDao engineDao = new EngineTypesDao();
        EnginetypesEntity engineType = new EnginetypesEntity();
        List<EnginetypesEntity> listEngines = engineDao.GetListEngines();
        engineType.setId(listEngines.size() + 1);
        engineType.setNameEngine(nameEngine);
        engineType.setEngineCapacity(capacity);
        engineType.setEnginePower(power);
        engineDao.Insert(engineType);
    }
    public void InsertInTransmissionType(String nameT, int countGears)
    {
        TransmissionTypesDao transmissionTypesDao = new TransmissionTypesDao();
        TransmissiontypesEntity transmission = new TransmissiontypesEntity();
        List<TransmissiontypesEntity> listTransmission = transmissionTypesDao.GetListTransmissions();
        transmission.setId(listTransmission.size() + 1);
        transmission.setNameTransmission(nameT);
        transmission.setNumberOfGears(countGears);
        transmissionTypesDao.Insert(transmission);
    }
    public void InsertInSales(int idClient, int idCar, int idEmployee, String date) throws ParseException
    {
        SalesDao salesDao = new SalesDao();
        ClientsDao clientsDao = new ClientsDao();
        CarsDao carsDao = new CarsDao();
        EmployeesDao employeesDao = new EmployeesDao();
        ClientsEntity client = clientsDao.GetObjectWithID(idClient);
        CarsEntity car = carsDao.GetObjectWithID(idCar);
        EmployeersEntity employee = employeesDao.GetObjectWithID(idEmployee);
        SalesEntity sale = new SalesEntity();
        List<SalesEntity> listSales = salesDao.GetListSales();
        sale.setId(listSales.size() + 1);
        sale.setClientsByIdClient(client);
        sale.setCarsByIdCar(car);
        sale.setEmployeersByIdEmployee(employee);
        Date _date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        sale.setDateSale((java.sql.Date) _date);
        salesDao.Insert(sale);
    }
}