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

import br.com.mobilepoint.model.Funcionario;
import br.com.mobilepoint.model.Turno;
import br.com.mobilepoint.repository.FuncionarioRepository;
import br.com.mobilepoint.utils.NegocioException;

@RestController
@RequestMapping("api/mobilepoint/funcionarios")
@CrossOrigin("*")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repo;
	
	@GetMapping
	public List<Funcionario> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("/byUsername/{username}")
	public Funcionario getByUsername(@PathVariable("username") String username) {
		return repo.findByUsername(username);
	}
	
	@GetMapping("/byTurno/{turno}")
	public List<Funcionario> getByTurno(@PathVariable("turno") Turno turno) {
		return repo.findByTurno(turno);
	}
	
	@PostMapping
	public String create(@RequestBody Funcionario novo) {
		repo.save(novo);
		return novo.getId();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Funcionario getById(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") String id, @RequestBody Funcionario funcionario) {
		if (!id.equals(funcionario.getId())) {
			throw new NegocioException("Id do funcionario está incorreto!");
		}
		repo.save(funcionario);
	}
}
