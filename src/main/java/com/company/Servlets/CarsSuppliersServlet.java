package com.company.Servlets;

import com.company.CarSupplierEntity;
import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.dao.CarsSupplerDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarsSuppliersServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private CarsSupplerDao carsSupplerDaoDao;

    public void  init()
    {
        carsSupplerDaoDao = new CarsSupplerDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getParameter("insertKnopka") != null)
        {
            try
            {
                insertCarSupplier(request, response);
            }
            catch
            (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(request.getParameter("deleteKnopka") != null)
        {
            try
            {
                deleteCarSupplier(request, response);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(request.getParameter("updateKnopka") != null)
        {
            try
            {
                updateCarSupplier(request, response);
            }
            catch
            (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            listCarSupplier(request, response);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    private void listCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <CarSupplierEntity> listCarsSupplier = carsSupplerDaoDao.GetListCarsSupplers();
        request.setAttribute("listCarsSupplier", listCarsSupplier);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliers-list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int idCar = new Integer(request.getParameter("idCar"));
        int idSupplier = new Integer(request.getParameter("idSupplier"));
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInCarSupplier(idCar, idSupplier);
        try
        {
            listCarSupplier(request, response);
        }
        catch (SQLException | ServletException e)
        {
            e.printStackTrace();
        }
    }

    private void updateCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("idBoxUpdate"));
        int idCar = new Integer(request.getParameter("idCar"));
        int idSupplier = new Integer(request.getParameter("idSupplier"));
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateCarsSupplier(id, idCar, idSupplier);
        try
        {
            listCarSupplier(request, response);
        }
        catch (SQLException | ServletException e)
        {
            e.printStackTrace();
        }
    }

    private void deleteCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idBox"));
        carsSupplerDaoDao.Delete(id);
        listCarSupplier(request, response);
    }
}