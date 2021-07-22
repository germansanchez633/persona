package com.test.trimix.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long perId;
	
	@Column(nullable = false)
	private String perTipoDocumento;
	
	@Column(nullable = false)
	private Long perNumeroDocumento;
	
	@Column(nullable = false)
	private String perApellido;
	
	@Column(nullable = false)
	private String perNombre;
	
	@Column(nullable = false)
	private Date perFechaNacimiento;

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}

	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}

	public Long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}

	public void setPerNumeroDocumento(Long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}

	public String getPerApellido() {
		return perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perApellido == null) ? 0 : perApellido.hashCode());
		result = prime * result + ((perFechaNacimiento == null) ? 0 : perFechaNacimiento.hashCode());
		result = prime * result + ((perId == null) ? 0 : perId.hashCode());
		result = prime * result + ((perNombre == null) ? 0 : perNombre.hashCode());
		result = prime * result + ((perNumeroDocumento == null) ? 0 : perNumeroDocumento.hashCode());
		result = prime * result + ((perTipoDocumento == null) ? 0 : perTipoDocumento.hashCode());
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
		Persona other = (Persona) obj;
		if (perApellido == null) {
			if (other.perApellido != null)
				return false;
		} else if (!perApellido.equals(other.perApellido))
			return false;
		if (perFechaNacimiento == null) {
			if (other.perFechaNacimiento != null)
				return false;
		} else if (!perFechaNacimiento.equals(other.perFechaNacimiento))
			return false;
		if (perId == null) {
			if (other.perId != null)
				return false;
		} else if (!perId.equals(other.perId))
			return false;
		if (perNombre == null) {
			if (other.perNombre != null)
				return false;
		} else if (!perNombre.equals(other.perNombre))
			return false;
		if (perNumeroDocumento == null) {
			if (other.perNumeroDocumento != null)
				return false;
		} else if (!perNumeroDocumento.equals(other.perNumeroDocumento))
			return false;
		if (perTipoDocumento == null) {
			if (other.perTipoDocumento != null)
				return false;
		} else if (!perTipoDocumento.equals(other.perTipoDocumento))
			return false;
		return true;
	}
	
	
}
