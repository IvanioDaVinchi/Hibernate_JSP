package com.company.Servlets;

import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.SuppliersEntity;
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

public class SuppliersServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private SuppliersDao suppliersDao;

    public void  init()
    {
        suppliersDao = new SuppliersDao();
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
                    insertSupplier(request, response);
                    break;
                case "/delete":
                    deleteSupplier(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSupplier(request, response);
                    break;
                default:
                    listSuppliers(request, response);
                    break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listSuppliers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <SuppliersEntity> listSuppliers = suppliersDao.GetListSuppliers();
        request.setAttribute("listSuppliers", listSuppliers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("suppliers-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("supplier-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        SuppliersEntity existingSupplier = suppliersDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("supplier-form.jsp");
        request.setAttribute("supplier", existingSupplier);
        dispatcher.forward(request, response);
    }

    private void insertSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        String nameSupplier = request.getParameter("nameSupplier");
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInSuppliers(nameSupplier);
        response.sendRedirect("list");
    }

    private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("id"));
        String nameSupplier = request.getParameter("nameSupplier");
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateSupplier(id,nameSupplier);
        response.sendRedirect("list");
    }

    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        suppliersDao.Delete(id);
        response.sendRedirect("list");
    }
}
