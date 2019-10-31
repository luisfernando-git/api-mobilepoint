package br.com.mobilepoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mobilepoint.model.Empresa;
import br.com.mobilepoint.repository.EmpresaRepository;
import br.com.mobilepoint.utils.NegocioException;

@RestController
@RequestMapping("api/mobilepoint/empresas")
@CrossOrigin("*")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository repo;
	
	@GetMapping
	public Empresa findOne() {
		return repo.find();
	}
	
	@PostMapping
	public String create(@RequestBody Empresa nova) {
		repo.save(nova);
		return nova.getId();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Empresa getById(@PathVariable("id") String id) {
		return repo.findById(id).get();	
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") String id, @RequestBody Empresa empresa) {
		if (!id.equals(empresa.getId())) {
			throw new NegocioException("Id da empresa está incorreto!");
		}
		repo.save(empresa);	
	}
}

