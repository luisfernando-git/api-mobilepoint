package br.com.mobilepoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mobilepoint.model.Funcionario;
import br.com.mobilepoint.model.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, String> {

	List<Ponto> findByFuncionario(Funcionario funcionario);
}
