package com.appcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appcrm.entites.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
