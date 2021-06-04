package com.company.Servlets;

import com.company.ClientsEntity;
import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.dao.ClientsDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientsServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private ClientsDao clientsDao;

    public void  init()
    {
        clientsDao = new ClientsDao();
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
                    insertClient(request, response);
                    break;
                case "/delete":
                    deleteClient(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateClient(request, response);
                    break;
                default:
                    listClients(request, response);
                    break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listClients(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <ClientsEntity> listCars = clientsDao.GetListClients();
        request.setAttribute("listClient", listCars);
        RequestDispatcher dispatcher = request.getRequestDispatcher("clients-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("clients-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        ClientsEntity existingClient = clientsDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("clients-form.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        String patronymic = request.getParameter("patronymic");
        String phoneNumber = request.getParameter("phoneNumber");
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInClient(fName, sName, patronymic, phoneNumber);
        response.sendRedirect("list");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("id"));
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        String patronymic = request.getParameter("patronymic");
        String phoneNumber = request.getParameter("phoneNumber");
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateClients(id, fName, sName, patronymic, phoneNumber);
        response.sendRedirect("list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        clientsDao.Delete(id);
        response.sendRedirect("list");
    }
}