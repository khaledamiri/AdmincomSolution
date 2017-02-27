package com.dq.admincom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dq.admincom.model.Entreprise;



public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
