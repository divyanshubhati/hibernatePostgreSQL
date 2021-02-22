package HQLdemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NativeSQL {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Gadgets.class);
        // builder give the object of registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Save  DATA

        // will throw ClassCastException 
        // Query q = session.createSQLQuery("select * from Gadgets");
        // List<Gadgets> gdts = q.list();
        // for(Gadgets gdt : gdts){
        //     System.out.println(gdt);
        // }

        // SQLQuery q = session.createSQLQuery("select * from Gadgets");
        // // tell hibernate we want to fetch a list of Gadgets type
        // q.addEntity(Gadgets.class);
        // List<Gadgets> gdts = q.list();
        // for(Gadgets gdt : gdts){
        //     System.out.println(gdt);
        // }

        // For specific columns 

        // this will not work .. as it will give object address but we want details
        // SQLQuery q = session.createSQLQuery("select name, price from Gadgets");

        // List<Object> gdts = q.list();
        // for(Object gdt : gdts){
        //     System.out.println(gdt.getId());
        // }

        // so let fetch them as key value pair
        SQLQuery q = session.createSQLQuery("select name, price from Gadgets");
        // cast the result into key MAP
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List gdts = q.list();
        for(Object gdt : gdts){
            Map m = (Map)gdt;
            System.out.println(m.get("name") + " : "+ m.get("price"));
        }
        tx.commit();

    }
}


