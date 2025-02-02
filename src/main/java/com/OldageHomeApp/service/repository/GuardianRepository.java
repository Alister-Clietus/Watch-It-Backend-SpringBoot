package com.OldageHomeApp.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OldageHomeApp.service.entity.GuardianEntity;

@Repository
public interface GuardianRepository extends JpaRepository<GuardianEntity, Long> 
{

}
