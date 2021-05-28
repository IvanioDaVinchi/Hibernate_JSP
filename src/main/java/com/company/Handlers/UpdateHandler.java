package com.company.Handlers;

import com.company.*;
import com.company.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UpdateHandler
{
    static Scanner in = new Scanner(System.in);
    public void UpdateCars(int id, String carBrand, String carModel, Double speed, Double racing, int engineType, int transmissionType, String color, int price)
    {
        EngineTypesDao engineDao = new EngineTypesDao();
        EnginetypesEntity engine = engineDao.GetObjectWithID(engineType);
        TransmissionTypesDao transmissionDao = new TransmissionTypesDao();
        TransmissiontypesEntity transmission = transmissionDao.GetObjectWithID(transmissionType);
        CarsEntity car = new CarsEntity();
        CarsDao carDao = new CarsDao();
        car.setId(id);
        car.setCarBrand(carBrand);
        car.setCarModel(carModel);
        car.setSpeed(speed);
        car.setRacing(racing);
        car.setCarColor(color);
        car.setEngineTypeByIdEngine(engine);
        car.setTransmissionTypeByIdTransmission(transmission);
        car.setPrice(price);
        carDao.Update(car);
    }
    public void UpdateCarsSupplier(int id, int idCar, int idSupplier)
    {
        CarsDao carsDao = new CarsDao();
        List<CarsEntity> listCars = carsDao.GetListCars();
        CarsEntity car = listCars.get(idCar - 1);
        SuppliersDao suppliersDao = new SuppliersDao();
        List<SuppliersEntity> listSuppliers = suppliersDao.GetListSuppliers();
        SuppliersEntity supplier = listSuppliers.get(idSupplier - 1);
        CarSupplierEntity carSupplier = new CarSupplierEntity();
        CarsSupplerDao carsSupplerDao = new CarsSupplerDao();
        List<CarSupplierEntity> carSupplierList = carsSupplerDao.GetListCarsSupplers();
        carSupplier.setCarsByIdCar(car);
        carSupplier.setSupplierByIdSupplier(supplier);
        carSupplier.setId(id);
        carsSupplerDao.Update(carSupplier);
    }
    public void UpdateClients(int id, String fName, String sName, String patronymic, String phoneNumber)
    {
        ClientsDao clientsDao = new ClientsDao();
        ClientsEntity client = new ClientsEntity();
        client.setId(id);
        client.setFirstName(fName);
        client.setSecondName(sName);
        client.setPatronymic(patronymic);
        client.setPhoneNumber(phoneNumber);
        clientsDao.Update(client);
    }
    public void UpdateEmplooyee(int id, String fName, String sName, String patronymic, String phoneNumber, String position)
    {
        EmployeesDao employeesDao = new EmployeesDao();
        EmployeersEntity employee = new EmployeersEntity();
        employee.setId(id);
        employee.setFirstName(fName);
        employee.setSecondName(sName);
        employee.setPatronymic(patronymic);
        employee.setPhoneNumber(phoneNumber);
        employee.setPosition(position);
        employeesDao.Update(employee);
    }
    public void UpdateSupplier(int id, String nameSupplier)
    {
        SuppliersDao suppliersDao = new SuppliersDao();
        SuppliersEntity supplier = new SuppliersEntity();
        supplier.setId(id);
        supplier.setNameSupplier(nameSupplier);
        suppliersDao.Update(supplier);
    }
    public void UpdateEngineType(int id, String nameEngine, Double capacity, int power)
    {
        EngineTypesDao engineDao = new EngineTypesDao();
        EnginetypesEntity engineType = new EnginetypesEntity();
        engineType.setId(id);
        engineType.setNameEngine(nameEngine);
        engineType.setEngineCapacity(capacity);
        engineType.setEnginePower(power);
        engineDao.Update(engineType);
    }
    public void UpdateTransmissionType(int id, String nameT, int countGears)
    {
        TransmissionTypesDao transmissionTypesDao = new TransmissionTypesDao();
        TransmissiontypesEntity transmission = new TransmissiontypesEntity();
        transmission.setId(id);
        transmission.setNameTransmission(nameT);
        transmission.setNumberOfGears(countGears);
        transmissionTypesDao.Update(transmission);
    }
    public void UpdateSale(int id, int idClient, int idCar, int idEmployee, String date) throws ParseException
    {
        SalesDao salesDao = new SalesDao();
        ClientsDao clientsDao = new ClientsDao();
        CarsDao carsDao = new CarsDao();
        EmployeesDao employeesDao = new EmployeesDao();
        List<ClientsEntity> listClients = clientsDao.GetListClients();
        List<CarsEntity> listCars = carsDao.GetListCars();
        List<EmployeersEntity> listEmployee = employeesDao.GetListEmployeers();
        ClientsEntity client = listClients.get(idClient - 1);
        CarsEntity car = listCars.get(idCar - 1);
        EmployeersEntity employee = listEmployee.get(idEmployee - 1);
        SalesEntity sale = new SalesEntity();
        sale.setId(id);
        sale.setClientsByIdClient(client);
        sale.setCarsByIdCar(car);
        sale.setEmployeersByIdEmployee(employee);
        Date _date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        sale.setDateSale((java.sql.Date) _date);
        salesDao.Update(sale);
    }
}