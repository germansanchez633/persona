package com.test.trimix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.trimix.dao.IPersonaDao;
import com.test.trimix.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	public List<Persona> FindNombreTipoDocumento(String perNombre, String perTipoDocumento) {
		return personaDao.findByPerNombreContainsAndPerTipoDocumentoContains(perNombre, perTipoDocumento);
	}

	@Override
	public Persona save(Persona persona) {
		return personaDao.save(persona);
	}

	@Override
	public void delete(Long id) {
		personaDao.deleteById(id);
	}

	@Override
	public Persona findById(Long id) {
		return (Persona)personaDao.findById(id).orElseThrow();
	}

}
