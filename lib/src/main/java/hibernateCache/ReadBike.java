package hibernateCache;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReadBike {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Bike.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // by default the level 1 caching / session caching will work

        Bike bike = (Bike) session.get(Bike.class, 101);
        System.out.println(bike.getName() + " : " + bike.getCompany());
        tx.commit();
        session.close();

        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        bike = (Bike) session2.get(Bike.class, 101);
        System.out.println(bike.getName() + " : " + bike.getCompany());
        tx2.commit();
        session2.close();

    }
}


