package com.siemens.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siemens.dto.OrganizationDto;
import com.siemens.entity.Organization;
import com.siemens.service.OrganizationService;

@RestController
@RequestMapping("/org")
public class OrganizationResource {

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/organization/{id}")
	public ResponseEntity<Organization> getOrganizationById(@PathVariable("id") int id) {
		try {
			Organization response = organizationService.getOrganizationById(id);
			return response != null ? new ResponseEntity<>(response, HttpStatus.OK)
					: new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/organization", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Organization> createOrganization(@RequestBody OrganizationDto organizationDto) {
		Organization organization = mapper.map(organizationDto, Organization.class);
		Organization response = organizationService.createOraganization(organization);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/organization/{id}")
	public ResponseEntity<String> deleteOrganization(@PathVariable("id") int id) {
		try {
			String response = organizationService.deleteOrganizationById(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/organization/{id}", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Organization> updateOrganization(@PathVariable("id") int id,
			@RequestBody OrganizationDto organizationDto) {
		Organization organization = mapper.map(organizationDto, Organization.class);
		Organization response = organizationService.updateOrganization(id, organization);
		return response != null ? new ResponseEntity<>(response, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

}
