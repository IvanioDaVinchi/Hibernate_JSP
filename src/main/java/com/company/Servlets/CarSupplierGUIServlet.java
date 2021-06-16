package com.company.Servlets;

import com.company.CarSupplierEntity;
import com.company.CarsEntity;
import com.company.SuppliersEntity;
import com.company.dao.CarsDao;
import com.company.dao.CarsSupplerDao;
import com.company.dao.SuppliersDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CarSupplierGUIServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private CarsSupplerDao carsSupplerDao;
    private CarsDao carsDao;
    private SuppliersDao suppliersDao;

    public void  init()
    {
        carsSupplerDao = new CarsSupplerDao();
        carsDao = new CarsDao();
        suppliersDao = new SuppliersDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getParameter("filterKnopkaCars") != null)
        {
            String brand = request.getParameter("spisokCars");
            System.out.println(brand);
            List <CarsEntity> listCars = carsDao.GetListCars();
            List<CarsEntity> listCarsWithFilters = new ArrayList<CarsEntity>();
            List<CarSupplierEntity> listCarsSuppliersWithFilters = new ArrayList<CarSupplierEntity>();
            for(int i = 0; i < listCars.size(); i++) // берем все машины по названию
            {
                System.out.println(listCars.get(i).getCarBrand());
                if(listCars.get(i).getCarBrand().equals(brand))
                {
                    listCarsWithFilters.add(listCars.get(i));
                }
            }
            List <CarSupplierEntity> listCarsSupplier = carsSupplerDao.GetListCarsSupplers();
            for(int i = 0; i < listCarsSupplier.size(); i++) // берем все поставки по машинам
            {
                for(int j = 0; j < listCarsWithFilters.size(); j++)
                {
                    System.out.println(listCarsSupplier.get(i).getCarsByIdCar().getId() + " - - - " + listCarsWithFilters.get(j).getId());
                    if(Integer.valueOf(listCarsSupplier.get(i).getCarsByIdCar().getId()).equals(listCarsWithFilters.get(j).getId()))
                    {
                        System.out.println("yvoyvoy");
                        listCarsSuppliersWithFilters.add(listCarsSupplier.get(i));
                    }
                }
            }
            request.setAttribute("listCarsSupplier", listCarsSuppliersWithFilters);
            RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliersGui-list.jsp");
            dispatcher.forward(request, response);
        }
        if(request.getParameter("filterKnopkaSuppliers") != null)
        {
            String supplier = request.getParameter("spisokSuppliers");
            System.out.println(supplier);
            List <SuppliersEntity> listSuppliers = suppliersDao.GetListSuppliers();
            List<SuppliersEntity> listSuppliersWithFilters = new ArrayList<SuppliersEntity>();
            List<CarSupplierEntity> listCarsSuppliersWithFilters = new ArrayList<CarSupplierEntity>();
            for(int i = 0; i < listSuppliers.size(); i++) // берем все машины по названию
            {
                if(listSuppliers.get(i).getNameSupplier().equals(supplier))
                {
                    listSuppliersWithFilters.add(listSuppliers.get(i));
                }
            }
            List <CarSupplierEntity> listCarsSupplier = carsSupplerDao.GetListCarsSupplers();
            for(int i = 0; i < listCarsSupplier.size(); i++) // берем все поставки по машинам
            {
                for(int j = 0; j < listSuppliersWithFilters.size(); j++)
                {
                    System.out.println(listCarsSupplier.get(i).getSupplierByIdSupplier().getId() + " - - - " + listSuppliersWithFilters.get(j).getId());
                    if(Integer.valueOf(listCarsSupplier.get(i).getSupplierByIdSupplier().getId()).equals(listSuppliersWithFilters.get(j).getId()))
                    {
                        System.out.println("yvoyvoy");
                        listCarsSuppliersWithFilters.add(listCarsSupplier.get(i));
                    }
                }
            }
            request.setAttribute("listCarsSupplier", listCarsSuppliersWithFilters);
            RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliersGui-list.jsp");
            dispatcher.forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            listCarSupplier(request,response);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    private void listCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <CarSupplierEntity> listCarsSupplier = carsSupplerDao.GetListCarsSupplers();
        request.setAttribute("listCarsSupplier", listCarsSupplier);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliersGui-list.jsp");
        dispatcher.forward(request, response);
    }
}
