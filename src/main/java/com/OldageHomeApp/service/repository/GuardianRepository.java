package com.OldageHomeApp.service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OldageHomeApp.service.entity.GuardianEntity;

@Repository
public interface GuardianRepository extends JpaRepository<GuardianEntity, Long> 
{

	Page<GuardianEntity> findAll(Specification<GuardianEntity> spec, Pageable pageable);
	List<GuardianEntity> findAll(Specification<GuardianEntity> spec);
}
