package com.OldageHomeApp.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OldageHomeApp.service.entity.DoctorEntity;

@Repository
public interface DoctorRepositor  extends JpaRepository<DoctorEntity, Long>
{

}
