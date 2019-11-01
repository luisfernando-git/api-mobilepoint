package br.com.mobilepoint.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mobilepoint.model.Funcionario;
import br.com.mobilepoint.model.Turno;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String>{

	@Query("select f from funcionario f where f.id =:id")
	Optional<Funcionario> findById(@Param("id") String id);
	
	Funcionario findByUsername(String username);
	
	List<Funcionario> findByTurno(Turno turno);
}
