package com.company.Servlets;

import com.company.CarSupplierEntity;
import com.company.CarsEntity;
import com.company.SuppliersEntity;
import com.company.dao.CarsDao;
import com.company.dao.CarsSupplerDao;
import com.company.dao.SuppliersDao;

import java.io.IOException;
import java.sql.SQLException;
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
        List <CarsEntity> listCars = carsDao.GetListCars();
        List <SuppliersEntity> listSupplier = suppliersDao.GetListSuppliers();
        request.setAttribute("listCarsSupplier", listCarsSupplier);
        request.setAttribute("listCars", listCars);
        request.setAttribute("listSupplier", listSupplier);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliersGui-list.jsp");
        dispatcher.forward(request, response);
    }
    private void ShowCars()
    {

    }
}
