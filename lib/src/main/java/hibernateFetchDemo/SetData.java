package hibernateFetchDemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SetData {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Album.class).addAnnotatedClass(Artist.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Save  DATA

        Artist artist = new Artist();
        artist.setId(1);
        artist.setName("Enrique Iglesias");
        artist.setNationality("Spain");
        artist.setDob("12-03-1986");

        // car.getDr().add(driver);

        Album album = new Album();
        album.setId(101);
        album.setTitle("Euphoria");
        album.setLanguage("English");
        album.setNumberOfTracks(10);
        album.setArtist(artist);

        // car.getDr().add(driver);

        session.save(album);


        // to save data
        album = new Album();
        album.setId(102);
        album.setTitle("Insomniac");
        album.setLanguage("English");
        album.setNumberOfTracks(8);
        album.setArtist(artist);

        // car.getDr().add(driver);

        session.save(album);
        
        session.save(artist);

        tx.commit();

    }
}


