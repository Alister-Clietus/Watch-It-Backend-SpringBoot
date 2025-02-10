package com.OldageHomeApp.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OldageHomeApp.service.entity.DoctorAppointmentEntity;


@Repository
public interface DoctorAppointmentRepo extends JpaRepository<DoctorAppointmentEntity, Long>
{

}
