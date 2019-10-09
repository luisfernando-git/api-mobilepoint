package br.com.mobilepoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mobilepoint.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String>{

}
