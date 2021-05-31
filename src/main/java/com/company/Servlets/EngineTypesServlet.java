package com.company.Servlets;

import com.company.EnginetypesEntity;
import com.company.Handlers.InsertHandler;
import com.company.Handlers.UpdateHandler;
import com.company.dao.EngineTypesDao;

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
public class EngineTypesServlet extends HttpServlet
{
    private static final long serialVersionUID = 1;
    private EngineTypesDao engineTypesDao;

    public void  init()
    {
        engineTypesDao = new EngineTypesDao();
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
                    insertEngine(request, response);
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
                    listEngineTypes(request, response);
                    break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void listEngineTypes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        List <EnginetypesEntity> listEngines = engineTypesDao.GetListEngines();
        request.setAttribute("listEngines", listEngines);
        RequestDispatcher dispatcher = request.getRequestDispatcher("engine-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("engine-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        EnginetypesEntity existingEngine = engineTypesDao.GetObjectWithID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("engine-form.jsp");
        request.setAttribute("engine", existingEngine);
        dispatcher.forward(request, response);
    }

    private void insertEngine(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        String nameEngine = request.getParameter("nameEngine");
        Double capacity = new Double(request.getParameter("capacity"));
        int power = new Integer(request.getParameter("power"));
        InsertHandler insertHandler = new InsertHandler();
        insertHandler.InsertInEngineTypes(nameEngine, capacity, power);
        response.sendRedirect("list");
    }

    private void updateEngine(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = new Integer(request.getParameter("id"));
        String nameEngine = request.getParameter("nameEngine");
        Double capacity = new Double(request.getParameter("capacity"));
        int power = new Integer(request.getParameter("power"));
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.UpdateEngineType(id, nameEngine, capacity, power);
        response.sendRedirect("list");
    }

    private void deleteEngine(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        engineTypesDao.Delete(id);
        response.sendRedirect("list");
    }
}
