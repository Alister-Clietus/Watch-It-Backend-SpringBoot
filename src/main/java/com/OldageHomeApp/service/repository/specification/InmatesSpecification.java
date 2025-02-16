package com.OldageHomeApp.service.repository.specification;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.OldageHomeApp.service.entity.ResidentEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class InmatesSpecification 
{
  public static Specification<ResidentEntity> getno_of_childrensSpec(String searchParam) 
  {
    return new Specification<ResidentEntity>() 
    {
      @Override
      public Predicate toPredicate(Root<ResidentEntity> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        Predicate finalPredicate = null;
        JSONParser parser = new JSONParser();
        JSONObject searchObject;
        try {
          if (searchParam != null && !searchParam.isEmpty()) { //to avoid end file at position 0
              searchObject = (JSONObject) parser.parse(searchParam);
          
          
            String firstName = (String) searchObject.get("firstName");
            String lastName = (String) searchObject.get("lastName");
            String adhaarNumber = (String) searchObject.get("adhaarNumber");
            String panId = (String) searchObject.get("panId");
            String no_of_childrens = (String) searchObject.get("no_of_childrens");
            String nativeplace = (String) searchObject.get("nativeplace");
            String guardian = (String) searchObject.get("guardian");
            String birthPlace = (String) searchObject.get("birthPlace");
            String dateOfBirth = (String) searchObject.get("dateOfBirth");
            String gender = (String) searchObject.get("gender");
            String address = (String) searchObject.get("address");
            String joineddate = (String) searchObject.get("joineddate");
            String bloodGroup = (String) searchObject.get("bloodGroup");
            String weight = (String) searchObject.get("weight");
            String height = (String) searchObject.get("height");
          
            if (!StringUtils.isEmpty(firstName)) {
              Predicate firstNamePredicate = criteriaBuilder.equal(root.get("firstName"), firstName);
              
              finalPredicate = criteriaBuilder.and(firstNamePredicate);
              
            }
          
            if (!StringUtils.isEmpty(lastName)) {
              Predicate lastNamePredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("lastName")),lastName.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, lastNamePredicate);
              }else {
              finalPredicate = criteriaBuilder.and(lastNamePredicate);
              }
            }
            if (!StringUtils.isEmpty(adhaarNumber)) {
              Predicate adhaarNumberPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("adhaarNumber")),adhaarNumber.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, adhaarNumberPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(adhaarNumberPredicate);
              }
            }
            if (!StringUtils.isEmpty(panId)) {
              Predicate panIdPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("panId")),"%"+panId.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, panIdPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(panIdPredicate);
              }
            }
            if (!StringUtils.isEmpty(no_of_childrens)) {
              Predicate no_of_childrensPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("no_of_childrens")),"%"+no_of_childrens.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, no_of_childrensPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(no_of_childrensPredicate);
              }
            }
          
            if (!StringUtils.isEmpty(nativeplace)) {
              Predicate nativeplacePredicate = criteriaBuilder.equal(root.get("nativeplace"), nativeplace);
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, nativeplacePredicate);
              }else {
              finalPredicate = criteriaBuilder.and(nativeplacePredicate);
              }
            }
            
            if (!StringUtils.isEmpty(guardian)) {
              Predicate guardianPredicate = criteriaBuilder.equal(root.get("guardian"), guardian);
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, guardianPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(guardianPredicate);
              }
            }
            
            if (!StringUtils.isEmpty(birthPlace)) {
                Predicate birthPlacePredicate = criteriaBuilder.equal(root.get("birthPlace"), birthPlace);
                if (finalPredicate != null) {
                finalPredicate = criteriaBuilder.and(finalPredicate, birthPlacePredicate);
                }else {
                finalPredicate = criteriaBuilder.and(birthPlacePredicate);
                }
              }
            
            if (!StringUtils.isEmpty(dateOfBirth)) {
                Predicate dateOfBirthPredicate = criteriaBuilder.equal(root.get("dateOfBirth"), dateOfBirth);
                if (finalPredicate != null) {
                finalPredicate = criteriaBuilder.and(finalPredicate, dateOfBirthPredicate);
                }else {
                finalPredicate = criteriaBuilder.and(dateOfBirthPredicate);
                }
              }
            
            if (!StringUtils.isEmpty(gender)) {
                Predicate genderPredicate = criteriaBuilder.equal(root.get("gender"), gender);
                if (finalPredicate != null) {
                finalPredicate = criteriaBuilder.and(finalPredicate, genderPredicate);
                }else {
                finalPredicate = criteriaBuilder.and(genderPredicate);
                }
              }
            
            if (!StringUtils.isEmpty(address)) {
                Predicate addressPredicate = criteriaBuilder.equal(root.get("address"), address);
                if (finalPredicate != null) {
                finalPredicate = criteriaBuilder.and(finalPredicate, addressPredicate);
                }else {
                finalPredicate = criteriaBuilder.and(addressPredicate);
                }
              }
            
            if (!StringUtils.isEmpty(bloodGroup)) {
                Predicate bloodGroupPredicate = criteriaBuilder.equal(root.get("bloodGroup"), bloodGroup);
                if (finalPredicate != null) {
                finalPredicate = criteriaBuilder.and(finalPredicate, bloodGroupPredicate);
                }else {
                finalPredicate = criteriaBuilder.and(bloodGroupPredicate);
                }
              }
            if (!StringUtils.isEmpty(weight)) {
                Predicate weightPredicate = criteriaBuilder.equal(root.get("weight"), weight);
                if (finalPredicate != null) {
                finalPredicate = criteriaBuilder.and(finalPredicate, weightPredicate);
                }else {
                finalPredicate = criteriaBuilder.and(weightPredicate);
                }
              }
            if (!StringUtils.isEmpty(height)) {
                Predicate heightPredicate = criteriaBuilder.equal(root.get("height"), height);
                if (finalPredicate != null) {
                finalPredicate = criteriaBuilder.and(finalPredicate, heightPredicate);
                }else {
                finalPredicate = criteriaBuilder.and(heightPredicate);
                }
              }
  
//            Order proTimeOrder = criteriaBuilder.desc(root.get("firstName"));
//            query.orderBy(proTimeOrder);
            
          } else {
            searchObject = null;
          }
        } catch (ParseException e) {
          e.printStackTrace();
        }
        return finalPredicate;
      }
    };
  }
  
}
