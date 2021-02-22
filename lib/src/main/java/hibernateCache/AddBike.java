package hibernateCache;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddBike {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Bike.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Save  DATA

        Bike bike = new Bike();
        bike.setId(101);
        bike.setName("R15");
        bike.setCompany("Yamaha");
        session.save(bike);

        // car.getDr().add(driver);

        bike = new Bike();
        bike.setId(102);
        bike.setName("R6");
        bike.setCompany("Yamaha");
        session.save(bike);

        // car.getDr().add(driver);

        session.save(bike);

        // to save data
        bike = new Bike();
        bike.setId(103);
        bike.setName("R1");
        bike.setCompany("Yamaha");
        session.save(bike);

        tx.commit();
    }
}
