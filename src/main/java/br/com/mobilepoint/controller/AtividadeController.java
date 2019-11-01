package br.com.mobilepoint.controller;

import java.util.List;

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

import br.com.mobilepoint.model.Atividade;
import br.com.mobilepoint.repository.AtividadeRepository;
import br.com.mobilepoint.utils.NegocioException;

@RestController
@RequestMapping("api/mobilepoint/atividades")
@CrossOrigin("*")
public class AtividadeController {
	
	@Autowired
	private AtividadeRepository repo;
	
	@GetMapping
	public List<Atividade> getAll() {
		return repo.findAll();
	}
	
	@PostMapping
	public String create(@RequestBody Atividade nova) {
		repo.save(nova);
		return nova.getId();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Atividade getById(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") String id, @RequestBody Atividade atividade) {
		if (!id.equals(atividade.getId())) {
			throw new NegocioException("Id da atividade está incorreto!");
		}
		repo.save(atividade);
	}
}