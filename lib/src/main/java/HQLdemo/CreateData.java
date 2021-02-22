package HQLdemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateData {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Gadgets.class);
        // builder give the object of registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Save  DATA

        
        Gadgets gdt = new Gadgets();
        gdt.setId(1);
        gdt.setName("Ipad pro");
        gdt.setPrice(85000);
        gdt.setYearOfPurchase(2019);
        session.save(gdt);

        gdt = new Gadgets();
        gdt.setId(2);
        gdt.setName("Lenovo Y50-70");
        gdt.setPrice(80000);
        gdt.setYearOfPurchase(2014);
        session.save(gdt);

        gdt = new Gadgets();
        gdt.setId(3);
        gdt.setName("One Plus 5");
        gdt.setPrice(27000);
        gdt.setYearOfPurchase(2017);
        session.save(gdt);

        tx.commit();

    }
}


