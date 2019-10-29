package br.com.mobilepoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.mobilepoint.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String>{

	@Query("select e from empresa e")
	Empresa find();
}
