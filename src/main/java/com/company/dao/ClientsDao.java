package com.company.dao;

import com.company.ClientsEntity;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientsDao
{
    public List<ClientsEntity> GetListClients()
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<ClientsEntity>) session.getSessionFactory().openSession().createQuery("From ClientsEntity ").list();
    }
    public void Update(ClientsEntity client)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(client);
        tx1.commit();
        session.close();
    }
    public void Delete(ClientsEntity client)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(client);
        tx1.commit();
        session.close();
    }
    public void Insert(ClientsEntity client)
    {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(client);
        tx1.commit();
        session.close();
    }
}