package hibernateMappingDemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Launcher {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Driver.class).addAnnotatedClass(Vehicle.class);
        // builder give the object of registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Save  DATA

        
        Vehicle car = new Vehicle();
        car.setId(102);
        car.setName("KIA seltos");
        car.setColour("silver");
        car.setModel("Top");
        car.setNumber("RJ19-CA-0367");

        // car.getDr().add(driver);

        Driver driver = new Driver();
        driver.setId(3);
        driver.setDob("12-04-1989");
        driver.setLicenseExpiresOn("12-12-2021");
        driver.setName("Happy Singh");
        driver.getCar().add(car);

        // car.getDr().add(driver);

        session.save(driver);


        // to save data
        driver = new Driver();
        driver.setId(4);
        driver.setDob("1-07-1990");
        driver.setLicenseExpiresOn("28-2-2021");
        driver.setName("Ronak Jain");
        driver.getCar().add(car);


        // car.getDr().add(driver);

        
        session.save(driver);


        
        session.save(car);

        tx.commit();

    }
}

