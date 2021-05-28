package com.company.dao;

import com.company.CarsEntity;
import com.company.EnginetypesEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EngineTypesDao
{
    public List<EnginetypesEntity> GetListEngines()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<EnginetypesEntity>) session.getSessionFactory().openSession().createQuery("From EnginetypesEntity ").list();
    }
    public void Update(EnginetypesEntity engine)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(engine);
        tx1.commit();
        session.close();
    }
    public void Delete(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session.get(EnginetypesEntity.class, id));
        tx1.commit();
        session.close();
    }
    public void Insert(EnginetypesEntity engine)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(engine);
        tx1.commit();
        session.close();
    }
    public EnginetypesEntity GetObjectWithID(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        EnginetypesEntity engine = session.get(EnginetypesEntity.class, id);
        session.close();
        return engine;
    }
}