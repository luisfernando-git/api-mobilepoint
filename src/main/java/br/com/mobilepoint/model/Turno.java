package br.com.mobilepoint.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name="turno")
public class Turno {

	@Id
	private String id;
	
	private String descricao;
	
	private Date horarioInicio = new Date();
	
	private Date horarioTermino = new Date();
	
	private Date intervalo = new Date();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="turno_funcionarios", 
			   joinColumns = { @JoinColumn(name = "turno_id") },
			   inverseJoinColumns = { @JoinColumn(name = "funcionario_id") })
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private boolean ativo = false; 
	
	public Turno() {
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

	public Date getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(Date horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public Date getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Date intervalo) {
		this.intervalo = intervalo;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void removerFuncionario(String idFuncionario) {
		Funcionario paraRemover = null;
		for (Funcionario funcionario : this.getFuncionarios()) {
			if (funcionario.getId().equals(idFuncionario)) {
				paraRemover = funcionario;
			}
		}
		
		this.getFuncionarios().remove(paraRemover);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((funcionarios == null) ? 0 : funcionarios.hashCode());
		result = prime * result + ((horarioInicio == null) ? 0 : horarioInicio.hashCode());
		result = prime * result + ((horarioTermino == null) ? 0 : horarioTermino.hashCode());
		result = prime * result + ((intervalo == null) ? 0 : intervalo.hashCode());
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
		Turno other = (Turno) obj;
		if (ativo != other.ativo)
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
		if (horarioInicio == null) {
			if (other.horarioInicio != null)
				return false;
		} else if (!horarioInicio.equals(other.horarioInicio))
			return false;
		if (horarioTermino == null) {
			if (other.horarioTermino != null)
				return false;
		} else if (!horarioTermino.equals(other.horarioTermino))
			return false;
		if (intervalo == null) {
			if (other.intervalo != null)
				return false;
		} else if (!intervalo.equals(other.intervalo))
			return false;
		return true;
	}
}
