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
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getServletPath();
        try
        {
            //listCars(request, response);
            switch (action)
            {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertCar(request, response);
                    break;
                case "/delete":
                    deleteCar(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCar(request, response);
                    break;
                default:
                    listCars(request, response);
                    break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listCars(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <CarsEntity> listCars = carsDao.GetListCars();
        request.setAttribute("listCars", listCars);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cars-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cars-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        CarsEntity existingCar = carsDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cars-form.jsp");
        request.setAttribute("car", existingCar);
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
        response.sendRedirect("list");
    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("id"));
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
        response.sendRedirect("list");
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        carsDao.Delete(id);
        response.sendRedirect("list");
    }
}
