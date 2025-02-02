package com.OldageHomeApp.service.repository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OldageHomeApp.service.entity.ResidentEntity;

@Repository
public interface ResidentRepository extends JpaRepository<ResidentEntity, Long>
{

}
