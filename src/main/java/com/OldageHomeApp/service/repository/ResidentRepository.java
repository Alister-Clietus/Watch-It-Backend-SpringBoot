package com.OldageHomeApp.service.repository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.OldageHomeApp.service.entity.ResidentEntity;

@Repository
public interface ResidentRepository extends JpaRepository<ResidentEntity, Long>
{

	Page<ResidentEntity> findAll(Specification<ResidentEntity> spec, Pageable pageable);
	List<ResidentEntity> findAll(Specification<ResidentEntity> spec);


}
