/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author test
 */
public class City {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //creating configuration object  
        //Configuration cfg=new Configuration();  
        //cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
        //creating seession factory object  
        //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
        //SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //creating session object  

        String csvFile = "/Users/test/desktop/geo.csv";
        String line = "";
        String cvsSplitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            br.readLine();
            //int count=1;
            while ((line = br.readLine()) != null) {
                Session session = factory.openSession();
                //creating transaction object  

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                //System.out.println(line);
                Transaction t = session.beginTransaction();
                perCity c1 = new perCity();
                
                c1.setId(Integer.valueOf(country[0])); // setting the value of id
                c1.setLat(Double.valueOf(country[5])); // setting the value of Latitude
                c1.setLon(Double.valueOf(country[6])); // setting the value of Longitude
                c1.setCountry(country[1]); // Srtting the value of Country code
                session.persist(c1);//persisting the object  
                t.commit();//transaction is commited  

                session.close();  // Closing the session after 
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
