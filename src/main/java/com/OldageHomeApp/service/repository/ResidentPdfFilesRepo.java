package com.OldageHomeApp.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OldageHomeApp.service.entity.ResidentPdfFilesEntity;

public interface ResidentPdfFilesRepo extends JpaRepository<ResidentPdfFilesEntity, Long> 
{
	Optional<ResidentPdfFilesEntity> findByName(String name);

}
