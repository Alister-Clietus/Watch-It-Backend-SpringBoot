package com.OldageHomeApp.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OldageHomeApp.service.entity.LoginEntity;

public interface LoginRepo extends JpaRepository<LoginEntity, String>{

}
