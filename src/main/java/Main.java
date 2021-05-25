import com.company.Handlers.MenuHandler;
import com.company.OutTable;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main
{
    private static final SessionFactory ourSessionFactory;
    static
    {
        try
        {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException
    {
        return ourSessionFactory.openSession();
    }
    static Scanner in = new Scanner(System.in);
    public static void main(final String[] args) throws Exception
    {
        final Session session = getSession();
        try
        {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities())
            {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list())
                {
                    System.out.println("  " + o);
                }
            }
        }
        finally
        {
            session.close();
        }
        MenuHandler menuHandler = new MenuHandler();
        while(true)
        {
            menuHandler.PrintMenu();
            int sw = in.nextInt();
            menuHandler.SwitchForMenu(sw);
        }
    }
}