package org.example;

import org.apache.log4j.Logger;
import org.example.db.FlywayMigration;
import org.example.entity.Resident;
import org.example.entity.ResidentsInfo;
import org.example.service.FindResident;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    final private static Logger logger = Logger.getLogger(Main.class);
    public static <residentsInfoList> void main(String[] args) {
        logger.info("Program is started");
        FlywayMigration.migration();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitOSBB");
        EntityManager em = emf.createEntityManager();
        List<ResidentsInfo> residentsInfoList = FindResident.findResidentWithCriteriaAPI(em);
        emf.close();
        for ( ResidentsInfo list: residentsInfoList) {
            System.out.println(residentsInfoList);
        }
    }
}