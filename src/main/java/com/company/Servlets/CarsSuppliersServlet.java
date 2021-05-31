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

@WebServlet("/")
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
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getServletPath();
        try
        {
            switch (action)
            {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertCarSupplier(request, response);
                    break;
                case "/delete":
                    deleteCarSupplier(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCarSupplier(request, response);
                    break;
                default:
                    listCarSupplier(request, response);
                    break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <CarSupplierEntity> listCarsSupplier = carsSupplerDaoDao.GetListCarsSupplers();
        request.setAttribute("listCarsSupplier", listCarsSupplier);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliers-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliers-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        CarSupplierEntity existingCarSupplier = carsSupplerDaoDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carsSuppliers-form.jsp");
        request.setAttribute("carSupplier", existingCarSupplier);
        dispatcher.forward(request, response);

    }

    private void insertCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int idCar = new Integer(request.getParameter("idCar"));
        int idSupplier = new Integer(request.getParameter("idSupplier"));
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInCarSupplier(idCar, idSupplier);
        response.sendRedirect("list");
    }

    private void updateCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("id"));
        int idCar = new Integer(request.getParameter("idCar"));
        int idSupplier = new Integer(request.getParameter("idSupplier"));
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateCarsSupplier(id, idCar, idSupplier);
        response.sendRedirect("list");
    }

    private void deleteCarSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        carsSupplerDaoDao.Delete(id);
        response.sendRedirect("list");
    }
}
