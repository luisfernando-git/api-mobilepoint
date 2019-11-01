package br.com.mobilepoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mobilepoint.model.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, String> {

}
