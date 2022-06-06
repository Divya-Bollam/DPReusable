package com.siemens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siemens.entity.Organization;
import com.siemens.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository organizationRepository;

	public Organization createOraganization(Organization organization) {
		return organizationRepository.save(organization);
	}

	public Organization getOrganizationById(int id) {
		Optional<Organization> optional = organizationRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteOrganizationById(int id) {
		organizationRepository.deleteById(id);
		return "deleted";
	}

	public Organization updateOrganization(int id, Organization organization) {
		Organization response = organizationRepository.findById(id).get();
		if (response != null) {
			response.setOrgId(organization.getOrgId());
			response.setOrgLocation(organization.getOrgLocation());
			response.setOrgName(organization.getOrgName());
			response.setEmployees(organization.getEmployees());
			response.setAssets(organization.getAssets());
			return organizationRepository.save(response);
		}
		return null;
	}
	
	public List<Organization> getOrganizations() {
		return organizationRepository.findAll();
	}
}
