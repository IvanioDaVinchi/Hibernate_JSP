package com.company.Servlets;

import com.company.CarsEntity;
import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.dao.CarsDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarsServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private CarsDao carsDao;

    public void  init()
    {
        carsDao = new CarsDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getParameter("insertKnopka") != null)
        {
            try
            {
                insertCar(request, response);
            }
            catch
            (SQLException e)
            {
                e.printStackTrace();
            }
            try
            {
                listCars(request, response);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(request.getParameter("deleteKnopka") != null)
        {
            try
            {
                deleteCar(request, response);
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
                updateCar(request, response);
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
        List <CarsEntity> listCars = carsDao.GetListCars();
        request.setAttribute("listCars", listCars);
        getServletContext().getRequestDispatcher("/cars-list.jsp").forward(request,response);
    }
    private void listCars(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <CarsEntity> listCars = carsDao.GetListCars();
        request.setAttribute("listCars", listCars);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cars-list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        String carBrand = request.getParameter("carBrand");
        String carModel = request.getParameter("carModel");
        Double speed = new Double(request.getParameter("speed"));
        Double racing = new Double(request.getParameter("racing"));
        int engineType = new Integer(request.getParameter("engineType"));
        int transmissionType = new Integer(request.getParameter("transmissionType"));
        String color = request.getParameter("color");
        int price = new Integer(request.getParameter("price"));
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInCars(carBrand, carModel, speed, racing, engineType, transmissionType, color, price);
    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("idBoxUpdate"));
        String carBrand = request.getParameter("carBrand");
        String carModel = request.getParameter("carModel");
        Double speed = new Double(request.getParameter("speed"));
        Double racing = new Double(request.getParameter("racing"));
        int engineType = new Integer(request.getParameter("engineType"));
        int transmissionType = new Integer(request.getParameter("transmissionType"));
        String color = request.getParameter("color");
        int price = new Integer(request.getParameter("price"));
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateCars(id, carBrand, carModel, speed, racing, engineType, transmissionType, color, price);
        try
        {
            listCars(request, response);
        }
        catch (SQLException | ServletException e)
        {
            e.printStackTrace();
        }
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("idBox"));
        carsDao.Delete(id);
        try
        {
            listCars(request, response);
        }
        catch (SQLException | ServletException e)
        {
            e.printStackTrace();
        }
    }
}
