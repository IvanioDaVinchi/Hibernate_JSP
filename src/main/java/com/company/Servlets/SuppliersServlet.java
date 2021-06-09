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
        if(request.getParameter("insertKnopka") != null)
        {
            try
            {
                insertSupplier(request, response);
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
                deleteSupplier(request, response);
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
                updateSupplier(request, response);
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
            listSuppliers(request, response);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    private void listSuppliers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <SuppliersEntity> listSuppliers = suppliersDao.GetListSuppliers();
        request.setAttribute("listSuppliers", listSuppliers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("suppliers-list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        String nameSupplier = request.getParameter("nameSupplier");
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInSuppliers(nameSupplier);
        response.sendRedirect("list");
    }

    private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = new Integer(request.getParameter("id"));
        String nameSupplier = request.getParameter("nameSupplier");
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateSupplier(id,nameSupplier);
        listSuppliers(request, response);
    }

    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        suppliersDao.Delete(id);
        listSuppliers(request, response);
    }
}
