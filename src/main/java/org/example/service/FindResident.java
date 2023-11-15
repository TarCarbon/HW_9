package org.example.service;

import org.example.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class FindResident {
    public static List<ResidentsInfo> findResidentWithCriteriaAPI(EntityManager em){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ResidentsInfo> criteriaQuery = criteriaBuilder.createQuery(ResidentsInfo.class);

        Root<Resident> residentRoot = criteriaQuery.from(Resident.class);
        Join<Resident, Apartment> apartmentJoin = residentRoot.join("apartments");
        Join<Apartment, Building> buildingJoin = apartmentJoin.join("buildings");
        Join<Resident, PropertyRights> propertyRightsJoin = residentRoot.join("propertyRights");

        Predicate driveIntoTheTerritoryPredicate = criteriaBuilder.equal(residentRoot.get("driveIntoTheTerritory"), 0);
        Predicate checkCountLess = criteriaBuilder.lessThan(residentRoot.get("property_right_id"), 3);

        criteriaQuery.multiselect(
                residentRoot.get("id"),
                residentRoot.get("name"),
                residentRoot.get("surname"),
                residentRoot.get("email"),
                apartmentJoin.get("number"),
                apartmentJoin.get("area"),
                buildingJoin.get("address")).where(driveIntoTheTerritoryPredicate, checkCountLess);

        TypedQuery<ResidentsInfo> typedQuery = em.createQuery(criteriaQuery);
        List<ResidentsInfo> residents = typedQuery.getResultList();
        em.close();
        return residents;
    }
}
