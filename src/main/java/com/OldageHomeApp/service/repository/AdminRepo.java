package com.OldageHomeApp.service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.OldageHomeApp.service.entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, Long>
{
	Page<AdminEntity> findAll(Specification<AdminEntity> spec, Pageable pageable);
	List<AdminEntity> findAll(Specification<AdminEntity> spec);

}
