package com.appcrm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcrm.entites.Lead;
import com.appcrm.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
private LeadRepository leadRepo;
	
	@PostMapping
	public Lead saveOne(@RequestBody Lead lead) {
		 Lead save = leadRepo.save(lead);
	return save;
	}
	
	@GetMapping
	public List<Lead> getAll(){
		List<Lead> findAll = leadRepo.findAll();
	    return findAll;
	}
	
	@PutMapping("/{id}")
	public Lead updateLead(@RequestBody Lead lead,@PathVariable("id")long id) {
    Optional<Lead> findById = leadRepo.findById(id);		
       Lead leads = findById.get();	
	    leads.setId(lead.getId());
	    leads.setName(lead.getName());
	    leads.setAge(lead.getAge());
    Lead save = leadRepo.save(leads);	
	return save;
	}
	
}
