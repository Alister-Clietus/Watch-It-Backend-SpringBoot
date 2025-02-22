package com.OldageHomeApp.service.repository.specification;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.OldageHomeApp.service.entity.AdminEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AdminSpecification 
{
	public static Specification<AdminEntity> getemailSpec(String searchParam) 
	  {
	    return new Specification<AdminEntity>() 
	    {
	      @Override
	      public Predicate toPredicate(Root<AdminEntity> root, CriteriaQuery<?> query,
	          CriteriaBuilder criteriaBuilder) {
	        Predicate finalPredicate = null;
	        JSONParser parser = new JSONParser();
	        JSONObject searchObject;
	        try {
	          if (searchParam != null && !searchParam.isEmpty()) { //to avoid end file at position 0
	              searchObject = (JSONObject) parser.parse(searchParam);
	          
	          
	            String firstName = (String) searchObject.get("firstName");
	            String lastName = (String) searchObject.get("lastName");
	            String address = (String) searchObject.get("address");
	            String gender = (String) searchObject.get("gender");
	            String email = (String) searchObject.get("email");
	            String phone = (String) searchObject.get("phone");
	            String adhaarNumber = (String) searchObject.get("adhaarNumber");
	            String panId = (String) searchObject.get("panId");
	            String nativeplace = (String) searchObject.get("nativeplace");
	            String joineddate = (String) searchObject.get("joineddate");

	            
	          
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
	            if (!StringUtils.isEmpty(address)) {
	              Predicate addressPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("address")),address.toUpperCase()+"%");
	              if (finalPredicate != null) {
	              finalPredicate = criteriaBuilder.and(finalPredicate, addressPredicate);
	              }else {
	              finalPredicate = criteriaBuilder.and(addressPredicate);
	              }
	            }
	            if (!StringUtils.isEmpty(gender)) {
	              Predicate genderPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("gender")),"%"+gender.toUpperCase()+"%");
	              if (finalPredicate != null) {
	              finalPredicate = criteriaBuilder.and(finalPredicate, genderPredicate);
	              }else {
	              finalPredicate = criteriaBuilder.and(genderPredicate);
	              }
	            }
	            if (!StringUtils.isEmpty(email)) {
	              Predicate emailPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("email")),"%"+email.toUpperCase()+"%");
	              if (finalPredicate != null) {
	              finalPredicate = criteriaBuilder.and(finalPredicate, emailPredicate);
	              }else {
	              finalPredicate = criteriaBuilder.and(emailPredicate);
	              }
	            }
	          
	            if (!StringUtils.isEmpty(phone)) {
	              Predicate phonePredicate = criteriaBuilder.equal(root.get("phone"), phone);
	              if (finalPredicate != null) {
	              finalPredicate = criteriaBuilder.and(finalPredicate, phonePredicate);
	              }else {
	              finalPredicate = criteriaBuilder.and(phonePredicate);
	              }
	            }
	            
	            if (!StringUtils.isEmpty(adhaarNumber)) {
	              Predicate adhaarNumberPredicate = criteriaBuilder.equal(root.get("adhaarNumber"), adhaarNumber);
	              if (finalPredicate != null) {
	              finalPredicate = criteriaBuilder.and(finalPredicate, adhaarNumberPredicate);
	              }else {
	              finalPredicate = criteriaBuilder.and(adhaarNumberPredicate);
	              }
	            }
	            if (!StringUtils.isEmpty(panId)) {
	                Predicate panIdPredicate = criteriaBuilder.equal(root.get("panId"), panId);
	                if (finalPredicate != null) {
	                finalPredicate = criteriaBuilder.and(finalPredicate, panIdPredicate);
	                }else {
	                finalPredicate = criteriaBuilder.and(panIdPredicate);
	                }
	              }
	            if (!StringUtils.isEmpty(joineddate)) {
	                Predicate joineddatePredicate = criteriaBuilder.equal(root.get("joineddate"), joineddate);
	                if (finalPredicate != null) {
	                finalPredicate = criteriaBuilder.and(finalPredicate, joineddatePredicate);
	                }else {
	                finalPredicate = criteriaBuilder.and(joineddatePredicate);
	                }
	              }
	            if (!StringUtils.isEmpty(nativeplace)) {
	                Predicate nativeplacePredicate = criteriaBuilder.equal(root.get("nativeplace"), joineddate);
	                if (finalPredicate != null) {
	                finalPredicate = criteriaBuilder.and(finalPredicate, nativeplacePredicate);
	                }else {
	                finalPredicate = criteriaBuilder.and(nativeplacePredicate);
	                }
	              }
	  
//	            Order proTimeOrder = criteriaBuilder.desc(root.get("firstName"));
//	            query.orderBy(proTimeOrder);
	            
	          } else 
	          {
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
