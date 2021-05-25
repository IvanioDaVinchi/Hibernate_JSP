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
    public void UpdateCars()
    {
        System.out.println("ведите id авто");
        int id = in.nextInt();
        System.out.println("Введите марку авто");
        String carBrand = in.next();
        System.out.println("Введите модель авто");
        String carModel = in.next();
        System.out.println("Введите скорость авто");
        Double speed = in.nextDouble();
        System.out.println("Введите разгон до 100 авто");
        Double racing = in.nextDouble();
        System.out.println("Введите тип двигателя авто");
        int engineType = in.nextInt();
        System.out.println("Введите тип трансмиссии авто");
        int transmissionType = in.nextInt();
        System.out.println("Введите цвет кузова авто");
        String color = in.next();
        System.out.println("Введите цену авто");
        int price = in.nextInt();
        EngineTypesDao engineDao = new EngineTypesDao();
        List<EnginetypesEntity> listEngines = engineDao.GetListEngines();
        EnginetypesEntity engine = listEngines.get(engineType - 1);
        TransmissionTypesDao transmissionDao = new TransmissionTypesDao();
        List<TransmissiontypesEntity> listTransmisson = transmissionDao.GetListTransmissions();
        TransmissiontypesEntity transmission = listTransmisson.get(transmissionType - 1);
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
    public void UpdateCarsSupplier()
    {
        System.out.println("Введите id записи");
        int id = in.nextInt();
        System.out.println("Введите номер авто");
        int idCar = in.nextInt();
        System.out.println("Введите номер поставщика");
        int idSupplier = in.nextInt();
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
    public void UpdateClients()
    {
        System.out.println("Введите id клиента");
        int id = in.nextInt();
        ClientsDao clientsDao = new ClientsDao();
        System.out.println("Введите фамилию клиента");
        String fName = in.next();
        System.out.println("Введите имя клиента");
        String sName = in.next();
        System.out.println("Введите отчество клиента");
        String patronymic = in.next();
        System.out.println("Введите телефон клиента");
        String phoneNumber = in.next();
        ClientsEntity client = new ClientsEntity();
        client.setId(id);
        client.setFirstName(fName);
        client.setSecondName(sName);
        client.setPatronymic(patronymic);
        client.setPhoneNumber(phoneNumber);
        clientsDao.Update(client);
    }
    public void UpdateEmplooyee()
    {
        EmployeesDao employeesDao = new EmployeesDao();
        System.out.println("Введите id работника");
        int id = in.nextInt();
        System.out.println("Введите фамилию работника");
        String fName = in.next();
        System.out.println("Введите имя работника");
        String sName = in.next();
        System.out.println("Введите отчество работника");
        String patronymic = in.next();
        System.out.println("Введите телефон работника");
        String phoneNumber = in.next();
        System.out.println("Введите должность работника");
        String position = in.next();
        EmployeersEntity employee = new EmployeersEntity();
        employee.setId(id);
        employee.setFirstName(fName);
        employee.setSecondName(sName);
        employee.setPatronymic(patronymic);
        employee.setPhoneNumber(phoneNumber);
        employee.setPosition(position);
        employeesDao.Update(employee);
    }
    public void UpdateSupplier()
    {
        SuppliersDao suppliersDao = new SuppliersDao();
        SuppliersEntity supplier = new SuppliersEntity();
        System.out.println("Введите id поставщика");
        int id = in.nextInt();
        System.out.println("Введите наименование поставщика");
        String nameSupplier = in.next();
        supplier.setId(id);
        supplier.setNameSupplier(nameSupplier);
        suppliersDao.Update(supplier);
    }
    public void UpdateEngineType()
    {
        System.out.println("введите id двигателя");
        int id = in.nextInt();
        System.out.println("Введите ниаименование двигателя");
        String nameEngine = in.next();
        System.out.println("Введите объем двигателя");
        Double capacity = in.nextDouble();
        System.out.println("Введите мощность двигателя");
        int power = in.nextInt();
        EngineTypesDao engineDao = new EngineTypesDao();
        EnginetypesEntity engineType = new EnginetypesEntity();
        engineType.setId(id);
        engineType.setNameEngine(nameEngine);
        engineType.setEngineCapacity(capacity);
        engineType.setEnginePower(power);
        engineDao.Update(engineType);
    }
    public void UpdateTransmissionType()
    {
        System.out.println("Введите id трансмиссии");
        int id = in.nextInt();
        System.out.println("Введите наименование трансимссии");
        String nameT = in.next();
        System.out.println("Введите количство передач");
        int countGears = in.nextInt();
        TransmissionTypesDao transmissionTypesDao = new TransmissionTypesDao();
        TransmissiontypesEntity transmission = new TransmissiontypesEntity();
        transmission.setId(id);
        transmission.setNameTransmission(nameT);
        transmission.setNumberOfGears(countGears);
        transmissionTypesDao.Update(transmission);
    }
    public void UpdateSale() throws ParseException
    {
        SalesDao salesDao = new SalesDao();
        System.out.println("Введите id продажи");
        int id = in.nextInt();
        System.out.println("Введите id клиента");
        int idClient = in.nextInt();
        System.out.println("Введите id авто");
        int idCar = in.nextInt();
        System.out.println("Введите id сотрудника");
        int idEmployee = in.nextInt();
        System.out.println("Введите дату продажи");
        String date = in.next();
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