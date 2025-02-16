package com.OldageHomeApp.service.repository.specification;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.OldageHomeApp.service.entity.DoctorEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
public class DoctorSpecification 
{
  public static Specification<DoctorEntity> getQuestionSpec(String searchParam) 
  {
    return new Specification<DoctorEntity>() 
    {
      @Override
      public Predicate toPredicate(Root<DoctorEntity> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        Predicate finalPredicate = null;
        JSONParser parser = new JSONParser();
        JSONObject searchObject;
        try {
          if (searchParam != null && !searchParam.isEmpty()) { //to avoid end file at position 0
              searchObject = (JSONObject) parser.parse(searchParam);
          
          
            String name = (String) searchObject.get("name");
            String phoneNumber = (String) searchObject.get("phoneNumber");
            String aadharNumber = (String) searchObject.get("aadharNumber");
            String email = (String) searchObject.get("email");
            String specialization = (String) searchObject.get("specialization");
            String address = (String) searchObject.get("address");
            String hospitalName = (String) searchObject.get("hospitalName");
            String age = (String) searchObject.get("age");
          
            if (!StringUtils.isEmpty(name)) {
              Predicate userNamePredicate = criteriaBuilder.equal(root.get("username"), name);
              
              finalPredicate = criteriaBuilder.and(userNamePredicate);
              
            }
          
            if (!StringUtils.isEmpty(phoneNumber)) {
              Predicate questionidPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("phoneNumber")),phoneNumber.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, questionidPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(questionidPredicate);
              }
            }
            if (!StringUtils.isEmpty(aadharNumber)) {
              Predicate questiontypePredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("aadharNumber")),aadharNumber.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, questiontypePredicate);
              }else {
              finalPredicate = criteriaBuilder.and(questiontypePredicate);
              }
            }
            if (!StringUtils.isEmpty(email)) {
              Predicate questionHeadingPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("email")),"%"+email.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, questionHeadingPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(questionHeadingPredicate);
              }
            }
            if (!StringUtils.isEmpty(specialization)) {
              Predicate questionPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("specialization")),"%"+specialization.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, questionPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(questionPredicate);
              }
            }
          
            if (!StringUtils.isEmpty(address)) {
              Predicate statusPredicate = criteriaBuilder.equal(root.get("address"), address);
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, statusPredicate);
              }else {
              finalPredicate = criteriaBuilder.and(statusPredicate);
              }
            }
            
            if (!StringUtils.isEmpty(hospitalName)) {
              Predicate createdDatePredicate = criteriaBuilder.equal(root.get("createdDate"), hospitalName);
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, createdDatePredicate);
              }else {
              finalPredicate = criteriaBuilder.and(createdDatePredicate);
              }
            }
  
//            Order proTimeOrder = criteriaBuilder.desc(root.get("userName"));
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
