package com.siemens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siemens.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer>{
}
