package com.OldageHomeApp.service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OldageHomeApp.service.entity.DoctorEntity;

@Repository
public interface DoctorRepositor  extends JpaRepository<DoctorEntity, Long>
{
	Page<DoctorEntity> findAll(Specification<DoctorEntity> spec, Pageable pageable);
	List<DoctorEntity> findAll(Specification<DoctorEntity> spec);

}
