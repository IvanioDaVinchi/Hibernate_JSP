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
    public void InsertInCars()
    {
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
        EnginetypesEntity engine = listEngines.get(engineType);
        TransmissionTypesDao transmissionDao = new TransmissionTypesDao();
        List<TransmissiontypesEntity> listTransmisson = transmissionDao.GetListTransmissions();
        TransmissiontypesEntity transmission = listTransmisson.get(transmissionType);
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
    public void InsertInCarSupplier()
    {
        System.out.println("Введите номер авто");
        int idCar = in.nextInt();
        System.out.println("Введите номер поставщика");
        int idSupplier = in.nextInt();
        CarsDao carsDao = new CarsDao();
        List<CarsEntity> listCars = carsDao.GetListCars();
        CarsEntity car = listCars.get(idCar);
        SuppliersDao suppliersDao = new SuppliersDao();
        List<SuppliersEntity> listSuppliers = suppliersDao.GetListSuppliers();
        SuppliersEntity supplier = listSuppliers.get(idSupplier);
        CarSupplierEntity carSupplier = new CarSupplierEntity();
        CarsSupplerDao carsSupplerDao = new CarsSupplerDao();
        List<CarSupplierEntity> carSupplierList = carsSupplerDao.GetListCarsSupplers();
        carSupplier.setCarsByIdCar(car);
        carSupplier.setSupplierByIdSupplier(supplier);
        carSupplier.setId(carSupplierList.size()+1);
        carsSupplerDao.Insert(carSupplier);
    }
    public void InsertInClient()
    {
        ClientsDao clientsDao = new ClientsDao();
        System.out.println("Введите фамилию клиента");
        String fName = in.next();
        System.out.println("Введите имя клиента");
        String sName = in.next();
        System.out.println("Введите отчество клиента");
        String patronymic = in.next();
        System.out.println("Введите телефон клиента");
        String phoneNumber = in.next();
        List<ClientsEntity> listClients = clientsDao.GetListClients();
        ClientsEntity client = new ClientsEntity();
        client.setId(listClients.size() + 1);
        client.setFirstName(fName);
        client.setSecondName(sName);
        client.setPatronymic(patronymic);
        client.setPhoneNumber(phoneNumber);
        clientsDao.Insert(client);
    }
    public void InsertInSuppliers()
    {
        SuppliersDao suppliersDao = new SuppliersDao();
        SuppliersEntity supplier = new SuppliersEntity();
        System.out.println("Введите наименование нового поставщика");
        String nameSupplier = in.next();
        List<SuppliersEntity> listSuppliers = suppliersDao.GetListSuppliers();
        supplier.setId(listSuppliers.size() + 1);
        supplier.setNameSupplier(nameSupplier);
        suppliersDao.Insert(supplier);
    }
    public void InsertInEmployees()
    {
        EmployeesDao employeesDao = new EmployeesDao();
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
    public void InsertInEngineTypes()
    {
        System.out.println("Введите ниаименование двигателя");
        String nameEngine = in.next();
        System.out.println("Введите объем двигателя");
        Double capacity = in.nextDouble();
        System.out.println("Введите мощность двигателя");
        int power = in.nextInt();
        EngineTypesDao engineDao = new EngineTypesDao();
        EnginetypesEntity engineType = new EnginetypesEntity();
        List<EnginetypesEntity> listEngines = engineDao.GetListEngines();
        engineType.setId(listEngines.size() + 1);
        engineType.setNameEngine(nameEngine);
        engineType.setEngineCapacity(capacity);
        engineType.setEnginePower(power);
        engineDao.Insert(engineType);
    }
    public void InsertInTransmissionType()
    {
        System.out.println("Введите наименование трансимссии");
        String nameT = in.next();
        System.out.println("Введите количство передач");
        int countGears = in.nextInt();
        TransmissionTypesDao transmissionTypesDao = new TransmissionTypesDao();
        TransmissiontypesEntity transmission = new TransmissiontypesEntity();
        List<TransmissiontypesEntity> listTransmission = transmissionTypesDao.GetListTransmissions();
        transmission.setId(listTransmission.size() + 1);
        transmission.setNameTransmission(nameT);
        transmission.setNumberOfGears(countGears);
        transmissionTypesDao.Insert(transmission);
    }
    public void InsertInSales() throws ParseException
    {
        SalesDao salesDao = new SalesDao();
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
        ClientsEntity client = listClients.get(idClient);
        CarsEntity car = listCars.get(idCar);
        EmployeersEntity employee = listEmployee.get(idEmployee);
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