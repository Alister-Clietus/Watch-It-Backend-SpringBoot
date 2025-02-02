package com.OldageHomeApp.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OldageHomeApp.service.entity.ResidentHealthEntity;

@Repository
public interface ResidentHealthRepositoy extends JpaRepository<ResidentHealthEntity, Long>
{

}
