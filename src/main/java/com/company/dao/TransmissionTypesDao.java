package com.company.dao;

import com.company.CarsEntity;
import com.company.TransmissiontypesEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TransmissionTypesDao
{
    public List<TransmissiontypesEntity> GetListTransmissions()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<TransmissiontypesEntity>) session.getSessionFactory().openSession().createQuery("From TransmissiontypesEntity ").list();
    }
    public void Update(TransmissiontypesEntity transmis)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(transmis);
        tx1.commit();
        session.close();
    }
    public void Delete(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session.get(TransmissiontypesEntity.class, id));
        tx1.commit();
        session.close();
    }
    public void Insert(TransmissiontypesEntity transmis)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(transmis);
        tx1.commit();
        session.close();
    }
    public TransmissiontypesEntity GetObjectWithID(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        TransmissiontypesEntity transmission = session.get(TransmissiontypesEntity.class, id);
        session.close();
        return transmission;
    }
}