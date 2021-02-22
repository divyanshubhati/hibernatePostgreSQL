package hibernateFetchDemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Launcher {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Album.class).addAnnotatedClass(Artist.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Artist artist = (Artist) session.get(Artist.class, 1);

        // System.out.println(artist.getName() + " : " + artist.getNationality());

        // for(Album i : artist.getAlbums()){
        //     System.out.println(i.getTitle());
        // }

        Album album = (Album) session.get(Album.class, 101);

        System.out.println(album.getTitle() + " : " + album.getLanguage());
        System.out.println(album.getArtist().getName());

        tx.commit();
        session.close();

    }
}


