package com.company.Servlets;

import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.TransmissiontypesEntity;
import com.company.dao.TransmissionTypesDao;

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
public class TransmissionTypesServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private TransmissionTypesDao transmissionTypesDao;

    public void  init()
    {
        transmissionTypesDao = new TransmissionTypesDao();
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
                    insertTransmission(request, response);
                    break;
                case "/delete":
                    deleteEngine(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateEngine(request, response);
                    break;
                default:
                    listTransmission(request, response);
                    break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listTransmission(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <TransmissiontypesEntity> listTransmission = transmissionTypesDao.GetListTransmissions();
        request.setAttribute("listTransmission", listTransmission);
        RequestDispatcher dispatcher = request.getRequestDispatcher("transmission-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("transmission-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        TransmissiontypesEntity existingTransmission = transmissionTypesDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("transmission-form.jsp");
        request.setAttribute("transmission", existingTransmission);
        dispatcher.forward(request, response);
    }

    private void insertTransmission(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        String nameT = request.getParameter("nameT");
        int countGears = new Integer(request.getParameter("countGears"));
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInTransmissionType(nameT, countGears);
        response.sendRedirect("list");
    }

    private void updateEngine(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("id"));
        String nameT = request.getParameter("nameT");
        int countGears = new Integer(request.getParameter("countGears"));
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateTransmissionType(id, nameT, countGears);
        response.sendRedirect("list");
    }

    private void deleteEngine(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        transmissionTypesDao.Delete(id);
        response.sendRedirect("list");
    }
}