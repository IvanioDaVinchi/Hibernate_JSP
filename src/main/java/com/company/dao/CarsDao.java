package com.company.dao;


import com.company.CarsEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarsDao
{
    public List<CarsEntity> GetListCars()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<CarsEntity>) session.getSessionFactory().openSession().createQuery("From CarsEntity ").list();
    }
    public void Update(CarsEntity car)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(car);
        tx1.commit();
        session.close();
    }
    public void Delete(CarsEntity car)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(car);
        tx1.commit();
        session.close();
    }
    public void Insert(CarsEntity car)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(car);
        tx1.commit();
        session.close();
    }
}