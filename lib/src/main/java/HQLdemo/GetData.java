package HQLdemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GetData {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Gadgets.class);
        // builder give the object of registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Save  DATA

        // Query q = session.createQuery("From Gadgets");
        // Query q = session.createQuery("From Gadgets where id=1");
        // List<Gadgets> gdts = q.list();
        // for(Gadgets gdt : gdts){
        //     System.out.println(gdt);
        // }

        // Query q = session.createQuery("select id, name from Gadgets where id=1");
        // Object[] gdt = (Object[]) q.uniqueResult();
        // System.out.println(gdt[0] + " : "+gdt[1]);

            // Query q = session.createQuery("select id , name from Gadgets");
            // // we get list of object array
            // List<Object[]> gdts = (List<Object[]>) q.list();
            // for (Object[] o : gdts) {
            //     System.out.println(o[0] + " : "+o[1]);
            // }
        
        // prepare statement --> positional parameters
        int x = 50000;
        Query q = session.createQuery("select sum(price) from Gadgets g where g.price> :price");
        q.setParameter("price", x);
        Long sum = (Long) q.uniqueResult();
        System.out.println("Sum is >> " + sum);

        tx.commit();

    }
}


