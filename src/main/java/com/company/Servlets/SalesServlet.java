package com.company.Servlets;

import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.SalesEntity;
import com.company.dao.SalesDao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalesServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private SalesDao salesDao;
    public void  init()
    {
        salesDao = new SalesDao();
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
                    insertSale(request, response);
                    break;
                case "/delete":
                    deleteSale(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSale(request, response);
                    break;
                default:
                    listSales(request, response);
                    break;
            }
        }
        catch (SQLException | ParseException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <SalesEntity> listSales = salesDao.GetListSales();
        request.setAttribute("listSales", listSales);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sales-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("sales-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        SalesEntity existingSale = salesDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sales-form.jsp");
        request.setAttribute("sale", existingSale);
        dispatcher.forward(request, response);
    }

    private void insertSale(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        int idClient = new Integer(request.getParameter("idClient"));
        int idCar = new Integer(request.getParameter("idCar"));
        int idEmployee = new Integer(request.getParameter("idEmployee"));
        String date = request.getParameter("date");
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInSales(idClient, idCar, idEmployee, date);
        response.sendRedirect("list");
    }

    private void updateSale(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        int id = new Integer(request.getParameter("id"));
        int idClient = new Integer(request.getParameter("idClient"));
        int idCar = new Integer(request.getParameter("idCar"));
        int idEmployee = new Integer(request.getParameter("idEmployee"));
        String date = request.getParameter("date");
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateSale(id, idClient, idCar, idEmployee, date);
        response.sendRedirect("list");
    }

    private void deleteSale(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        salesDao.Delete(id);
        response.sendRedirect("list");
    }
}
