package com.OldageHomeApp.service.repository.specification;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.OldageHomeApp.service.entity.DoctorAppointmentEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
public class DoctorAppointmentSpecification 
{
  public static Specification<DoctorAppointmentEntity> getQuestionSpec(String searchParam) 
  {
    return new Specification<DoctorAppointmentEntity>() 
    {
      @Override
      public Predicate toPredicate(Root<DoctorAppointmentEntity> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        Predicate finalPredicate = null;
        JSONParser parser = new JSONParser();
        JSONObject searchObject;
        try {
          if (searchParam != null && !searchParam.isEmpty()) { //to avoid end file at position 0
              searchObject = (JSONObject) parser.parse(searchParam);
          
          
            String patientName = (String) searchObject.get("patientName");
            String doctorName = (String) searchObject.get("doctorName");
            String appointmentDDate = (String) searchObject.get("appointmentDDate");
            String appointmentTime = (String) searchObject.get("appointmentTime");

          
            if (!StringUtils.isEmpty(patientName)) {
                Predicate patientNamePredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("patientName")),patientName.toUpperCase()+"%");
              
              finalPredicate = criteriaBuilder.and(patientNamePredicate);
              
            }
            
          
            if (!StringUtils.isEmpty(doctorName)) {
              Predicate doctorNamePredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("doctorName")),doctorName.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, doctorNamePredicate);
              }else {
              finalPredicate = criteriaBuilder.and(doctorNamePredicate);
              }
            }
            
            if (!StringUtils.isEmpty(appointmentDDate)) {
              Predicate appointmentDDatePredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("appointmentDDate")),appointmentDDate.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, appointmentDDatePredicate);
              }else {
              finalPredicate = criteriaBuilder.and(appointmentDDatePredicate);
              }
            }
            if (!StringUtils.isEmpty(appointmentTime)) {
              Predicate appointmentTimePredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("appointmentTime")),"%"+appointmentTime.toUpperCase()+"%");
              if (finalPredicate != null) {
              finalPredicate = criteriaBuilder.and(finalPredicate, appointmentTimePredicate);
              }else {
              finalPredicate = criteriaBuilder.and(appointmentTimePredicate);
              }
            }
  
//            Order proTimeOrder = criteriaBuilder.desc(root.get("userpatientpatientpatientpatientName"));
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

