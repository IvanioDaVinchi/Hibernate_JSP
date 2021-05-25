package com.company.dao;

import com.company.SuppliersEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SuppliersDao
{
    public List<SuppliersEntity> GetListSuppliers()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<SuppliersEntity>) session.getSessionFactory().openSession().createQuery("From SuppliersEntity ").list();
    }
    public void Update(SuppliersEntity supplier)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(supplier);
        tx1.commit();
        session.close();
    }
    public void Delete(SuppliersEntity supplier)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(supplier);
        tx1.commit();
        session.close();
    }
    public void Insert(SuppliersEntity supplier)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(supplier);
        tx1.commit();
        session.close();
    }
}