package com.company.dao;

import com.company.CarSupplierEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarsSupplerDao
{
    public List<CarSupplierEntity> GetListCarsSupplers()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<CarSupplierEntity>) session.getSessionFactory().openSession().createQuery("From CarSupplierEntity ").list();
    }
    public void Update(CarSupplierEntity o)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(o);
        tx1.commit();
        session.close();
    }
    public void Delete(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session.get(CarSupplierEntity.class, id));
        tx1.commit();
        session.close();
    }
    public void Insert(CarSupplierEntity o)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(o);
        tx1.commit();
        session.close();
    }
    public CarSupplierEntity GetObjectWithID(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        CarSupplierEntity carSupplier = session.get(CarSupplierEntity.class, id);
        session.close();
        return  carSupplier;
    }
}