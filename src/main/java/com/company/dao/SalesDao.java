package com.company.dao;

import com.company.CarsEntity;
import com.company.SalesEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SalesDao
{
    public List<SalesEntity> GetListSales()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<SalesEntity>) session.getSessionFactory().openSession().createQuery("From SalesEntity ").list();
    }
    public void Update(SalesEntity sale)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(sale);
        tx1.commit();
        session.close();
    }
    public void Delete(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session.get(SalesEntity.class, id));
        tx1.commit();
        session.close();
    }
    public void Insert(SalesEntity sale)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(sale);
        tx1.commit();
        session.close();
    }
    public SalesEntity GetObjectWithID(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        SalesEntity sale = session.get(SalesEntity.class, id);
        session.close();
        return sale;
    }
}