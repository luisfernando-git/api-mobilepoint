package br.com.mobilepoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mobilepoint.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, String> {

}
