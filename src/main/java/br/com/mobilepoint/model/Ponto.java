package br.com.mobilepoint.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="ponto")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Ponto {

	@Id
	private String id;
	
	private Date chegada; 
	
	private Integer tempoAtraso;
	
	private String latitude;
	
	private String longitude;
	
	@ManyToOne(targetEntity = Funcionario.class)
	@JoinColumn(name = "funcionario_fk")
	private Funcionario funcionario;
	
	private String tipoPonto;
	
	public Ponto() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getChegada() {
		return chegada;
	}

	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}

	public Integer getTempoAtraso() {
		return tempoAtraso;
	}

	public void setTempoAtraso(Integer tempoAtraso) {
		this.tempoAtraso = tempoAtraso;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(String tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chegada == null) ? 0 : chegada.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((tempoAtraso == null) ? 0 : tempoAtraso.hashCode());
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
		Ponto other = (Ponto) obj;
		if (chegada == null) {
			if (other.chegada != null)
				return false;
		} else if (!chegada.equals(other.chegada))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
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
		if (tempoAtraso == null) {
			if (other.tempoAtraso != null)
				return false;
		} else if (!tempoAtraso.equals(other.tempoAtraso))
			return false;
		return true;
	}
}
