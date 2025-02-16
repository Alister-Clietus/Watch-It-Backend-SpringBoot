package com.OldageHomeApp.service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OldageHomeApp.service.entity.DoctorAppointmentEntity;


@Repository
public interface DoctorAppointmentRepo extends JpaRepository<DoctorAppointmentEntity, Long>
{
	
	Page<DoctorAppointmentEntity> findAll(Specification<DoctorAppointmentEntity> spec, Pageable pageable);
	List<DoctorAppointmentEntity> findAll(Specification<DoctorAppointmentEntity> spec);

}
