package com.company.Handlers;

import com.company.OutTable;

import java.text.ParseException;
import java.util.Scanner;

public class MenuHandler
{
    static Scanner in = new Scanner(System.in);
    public void PrintMenu()
    {
        System.out.println("1) Вывод таблиц");
        System.out.println("2) Добавление");
        System.out.println("3) Удаление");
        System.out.println("4) Редактирование");
    }
    public void PrintTablesName()
    {
        System.out.println("Введите номер таблицы");
        System.out.println("1) Cars");
        System.out.println("2) Clients ");
        System.out.println("3) EngineTypes");
        System.out.println("4) TransmissionTypes");
        System.out.println("5) Employeers");
        System.out.println("6) Suppliers");
        System.out.println("7) Sales");
        System.out.println("8) Car_Supplier");
    }
    public void SwitchForMenu(int sw) throws ParseException
    {
        switch (sw)
        {
            case 1:
            {
                PrintTablesName();
                int sww = in.nextInt();
                SwitchForTablePrint(sww);
                break;
            }
            case 2:
            {
                PrintTablesName();
                int sww = in.nextInt();
                SwitchForInsertInTables(sww);
                break;
            }
            case 3:
            {
                PrintTablesName();
                int sww = in.nextInt();
                SwitchForDelete(sww);
                break;
            }
            case 4:
            {
                PrintTablesName();
                int sww = in.nextInt();
                SwitchForUpdate(sww);
                break;
            }
        }
    }
    public void SwitchForTablePrint(int sw)
    {
        OutTable outTable = new OutTable();
        switch (sw)
        {
            case 1:
            {
                outTable.PrintCarsTable();
                break;
            }
            case 2:
            {
                outTable.PrintClientsTable();
                break;
            }
            case 3:
            {
                outTable.PrintEngineTypesTable();
                break;
            }
            case 4:
            {
                outTable.PrintTransmissionTypesTable();
                break;
            }
            case 5:
            {
                outTable.PrintEmployeersTable();
                break;
            }
            case 6:
            {
                outTable.PrintSuppliersTable();
                break;
            }
            case 7:
            {
                outTable.PrintSalesTable();
                break;
            }
            case 8:
            {
                outTable.PrintCarSupplierTable();
                break;
            }
        }
    }
    public void SwitchForInsertInTables(int sw) throws ParseException
    {
        InsertHandler insertHandler = new InsertHandler();
        switch (sw)
        {
            case 1:
            {
                insertHandler.InsertInCars();
                break;
            }
            case 2:
            {
                insertHandler.InsertInClient();
                break;
            }
            case 3:
            {
                insertHandler.InsertInEngineTypes();
                break;
            }
            case 4:
            {
                insertHandler.InsertInTransmissionType();
                break;
            }
            case 5:
            {
                insertHandler.InsertInEmployees();
                break;
            }
            case 6:
            {
                insertHandler.InsertInSuppliers();
                break;
            }
            case 7:
            {
                insertHandler.InsertInSales();
                break;
            }
            case 8:
            {
                insertHandler.InsertInCarSupplier();
                break;
            }
        }
    }
    public void SwitchForUpdate(int sw) throws ParseException
    {
        UpdateHandler updateHandler = new UpdateHandler();
        switch (sw)
        {
            case 1:
            {
                updateHandler.UpdateCars();
                break;
            }
            case 2:
            {
                updateHandler.UpdateClients();
                break;
            }
            case 3:
            {
                updateHandler.UpdateEngineType();
                break;
            }
            case 4:
            {
                updateHandler.UpdateTransmissionType();
                break;
            }
            case 5:
            {
                updateHandler.UpdateEmplooyee();
                break;
            }
            case 6:
            {
                updateHandler.UpdateSupplier();
                break;
            }
            case 7:
            {
                updateHandler.UpdateSale();
                break;
            }
            case 8:
            {
                updateHandler.UpdateCarsSupplier();
                break;
            }
        }
    }
    public void SwitchForDelete(int sw)
    {
        DeleteHandler deleteHandler = new DeleteHandler();
        UpdateHandler updateHandler = new UpdateHandler();
        switch (sw)
        {
            case 1:
            {
                deleteHandler.DeleteFromCars();
                break;
            }
            case 2:
            {
                deleteHandler.DeleteFromClient();
                break;
            }
            case 3:
            {
                deleteHandler.DeleteFromEngineTypes();
                break;
            }
            case 4:
            {
                deleteHandler.DeleteFromTransmissionTypes();
                break;
            }
            case 5:
            {
                deleteHandler.DeleteFromEmployee();
                break;
            }
            case 6:
            {
                deleteHandler.DeleteFromSupplier();
                break;
            }
            case 7:
            {
                deleteHandler.DeleteFromSales();
                break;
            }
            case 8:
            {
                deleteHandler.DeleteFromCarSuppliers();
                break;
            }
        }
    }
}