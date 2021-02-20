package hibernateDemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Launcher {
    public static void main(String[] args) {
        
        // Save  DATA

        Dish dish = new Dish();
        dish.setId(101);
        dish.setName("Latte");
        dish.setPrice(110);
        dish.setServing(1);
        Provider pro = new Provider();
        pro.setRestroName("Matteo Cafe");
        pro.setRestroLocation("Indranager, Banglore");
        pro.setRestroContactNumber("909989898");
        dish.setSupplier(pro);
        System.out.println(dish);

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Dish.class);
        // builder give the object of registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // to save data
        session.save(dish);

        Dish d;
        d = (Dish) session.get(Dish.class, 101);

        tx.commit();
        System.out.println(d);

    }
}
