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
import br.com.mobilepoint.model.Ponto;
import br.com.mobilepoint.repository.FuncionarioRepository;
import br.com.mobilepoint.repository.PontoRepository;
import br.com.mobilepoint.utils.NegocioException;

@RestController
@RequestMapping("api/mobilepoint/pontos")
@CrossOrigin("*")
public class PontoController {
	
	@Autowired
	private PontoRepository repo;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public List<Ponto> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("/byFuncionario/{idFuncionario}")
	public List<Ponto> getByFuncionario(@PathVariable("idFuncionario") String idFuncionario) {
		Funcionario funcionario = funcionarioRepository.getOne(idFuncionario);
		return repo.findByFuncionario(funcionario);
	}
	
	@PostMapping
	public String create(@RequestBody Ponto novo) {
		repo.save(novo);
		return novo.getId();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Ponto getById(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") String id, @RequestBody Ponto ponto) {
		if (!id.equals(ponto.getId())) {
			throw new NegocioException("Id do ponto está incorreto!");
		}
		repo.save(ponto);
	}
}