package com.company.Servlets;

import com.company.ClientsEntity;
import com.company.EmployeersEntity;
import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.dao.EmployeesDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeesServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private EmployeesDao employeesDao;
    public void  init()
    {
        employeesDao = new EmployeesDao();
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
                    insertEmployee(request, response);
                    break;
                case "/delete":
                    deleteEmployee(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <EmployeersEntity> listEmployee = employeesDao.GetListEmployeers();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employees-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeersEntity existingEmployee = employeesDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        String patronymic = request.getParameter("patronymic");
        String phoneNumber = request.getParameter("phoneNumber");
        String position = request.getParameter("position");
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInEmployees(fName, sName, patronymic, phoneNumber,position);
        response.sendRedirect("list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("id"));
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        String patronymic = request.getParameter("patronymic");
        String phoneNumber = request.getParameter("phoneNumber");
        String position = request.getParameter("position");
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateEmplooyee(id, fName, sName, patronymic, phoneNumber, position);
        response.sendRedirect("list");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        employeesDao.Delete(id);
        response.sendRedirect("list");
    }
}