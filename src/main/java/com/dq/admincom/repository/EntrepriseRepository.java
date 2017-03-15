package com.dq.admincom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dq.admincom.model.Entreprise;



public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

}
