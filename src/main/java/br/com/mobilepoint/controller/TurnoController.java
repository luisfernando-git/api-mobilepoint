package br.com.mobilepoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.mobilepoint.repository.TurnoRepository;
import br.com.mobilepoint.utils.NegocioException;

@RestController
@RequestMapping("/api/mobilepoint/turnos")
public class TurnoController {

	@Autowired
	private TurnoRepository repo;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public List<Turno> getAll() {
		return repo.findAll();
	}
	
	@PostMapping
	public String create(@RequestBody Turno novo) {
		repo.save(novo);
		
		if (novo.getFuncionarios() != null && !novo.getFuncionarios().isEmpty()) {
			for (Funcionario func : novo.getFuncionarios()) {
				func.setTurno(novo);
				funcionarioRepository.save(func);
			}
		}
		
		return novo.getId();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Turno getById(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") String id, @RequestBody Turno turno) {
		if (!id.equals(turno.getId())) {
			throw new NegocioException("Id do turno está incorreto!");
		}
		
		if (turno.getFuncionarios() != null && !turno.getFuncionarios().isEmpty()) {
			for (Funcionario func : turno.getFuncionarios()) {
				func.setTurno(turno);
				funcionarioRepository.save(func);
			}
		}
		
		repo.save(turno);
	}
	
	@DeleteMapping("/{id}/funcionarios/{idFuncionario}")
	public void deleteFuncionario(@PathVariable("id") String id, @PathVariable("idFuncionario") String idFuncionario) {
		Turno turno = repo.findById(id).get();
		turno.removerFuncionario(idFuncionario);
		repo.save(turno);
		Funcionario funcionario = funcionarioRepository.findById(idFuncionario).get();
		funcionario.setTurno(null);
		funcionarioRepository.save(funcionario);
	}
}
