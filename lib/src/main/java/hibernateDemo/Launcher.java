package hibernateDemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Launcher {
    public static void main(String[] args) {
        Dish dish = new Dish();
        dish.setId(101);
        dish.setName("Cappachino");
        dish.setPrice(120);
        dish.setServing(1);

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Dish.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(dish);
        tx.commit();

    }
}
