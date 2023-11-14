package org.example.service;

import org.example.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class FindResident {
    public static List<ResidentsInfo> findResidentWithCriteriaAPI(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitOSBB");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ResidentsInfo> residentsInfoCQ = criteriaBuilder.createQuery(ResidentsInfo.class);

        Root<Resident> residentRoot = residentsInfoCQ.from(Resident.class);
        Join<Resident, Apartment> apartmentJoin = residentRoot.join("apartments");
        Join<Apartment, Building> buildingJoin = apartmentJoin.join("buildings");
        Join<Resident, PropertyRights> propertyRightsJoin = residentRoot.join("propertyRights");

        Predicate driveIntoTheTerritoryPredicate = criteriaBuilder.equal(residentRoot.get("driveIntoTheTerritory"), 0);
        Predicate checkCountLess = criteriaBuilder.lessThan(residentRoot.get("property_right_id"), 3);



        List<ResidentsInfo> residents = em.createQuery(residentsInfoCQ).getResultList();

        em.close();
        emf.close();
        return residents;
    }
}
