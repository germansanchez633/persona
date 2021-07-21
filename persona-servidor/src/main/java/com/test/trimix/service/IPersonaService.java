package com.test.trimix.service;

import java.util.List;

import com.test.trimix.entity.Persona;

public interface IPersonaService {
	public List<Persona> findAll();
	public Persona findById(Long id);
	public List<Persona> FindNombreTipoDocumento(String perNombre, String perTipoDocumento);
	public Persona save(Persona persona);
	public void delete(Long id);
}
