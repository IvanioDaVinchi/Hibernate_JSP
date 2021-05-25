package com.company.dao;

import com.company.EmployeersEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeesDao
{
    public List<EmployeersEntity> GetListEmployeers()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<EmployeersEntity>) session.getSessionFactory().openSession().createQuery("From EmployeersEntity ").list();
    }
    public void Update(EmployeersEntity empl)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(empl);
        tx1.commit();
        session.close();
    }
    public void Delete(EmployeersEntity empl)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(empl);
        tx1.commit();
        session.close();
    }
    public void Insert(EmployeersEntity empl)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(empl);
        tx1.commit();
        session.close();
    }
}