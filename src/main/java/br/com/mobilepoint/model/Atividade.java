package br.com.mobilepoint.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity(name="atividade")
public class Atividade {

	@Id
	private String id;
	
	private String descricao;
	
	private Date horarioInicio = new Date();
	
	private Date horarioFim = new Date();
	
	private Integer tempoTolerancia;
	
	@OneToMany(targetEntity = Funcionario.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinTable(name="atividade_funcionarios", joinColumns = @JoinColumn(name = "atividade_id"), inverseJoinColumns = @JoinColumn(name = "funcionarios_id"))
	@OrderColumn(name="atividade")
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private String observacoes;
	
	private String latitude;
	
	private String longitude;
	
	private boolean concluido = false;
	
	public Atividade() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public Integer getTempoTolerancia() {
		return tempoTolerancia;
	}

	public void setTempoTolerancia(Integer tempoTolerancia) {
		this.tempoTolerancia = tempoTolerancia;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (concluido ? 1231 : 1237);
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((funcionarios == null) ? 0 : funcionarios.hashCode());
		result = prime * result + ((horarioFim == null) ? 0 : horarioFim.hashCode());
		result = prime * result + ((horarioInicio == null) ? 0 : horarioInicio.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((tempoTolerancia == null) ? 0 : tempoTolerancia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (concluido != other.concluido)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (funcionarios == null) {
			if (other.funcionarios != null)
				return false;
		} else if (!funcionarios.equals(other.funcionarios))
			return false;
		if (horarioFim == null) {
			if (other.horarioFim != null)
				return false;
		} else if (!horarioFim.equals(other.horarioFim))
			return false;
		if (horarioInicio == null) {
			if (other.horarioInicio != null)
				return false;
		} else if (!horarioInicio.equals(other.horarioInicio))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (tempoTolerancia == null) {
			if (other.tempoTolerancia != null)
				return false;
		} else if (!tempoTolerancia.equals(other.tempoTolerancia))
			return false;
		return true;
	}
}
