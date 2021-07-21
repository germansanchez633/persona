package com.test.trimix.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.trimix.entity.Persona;

@Repository
public interface IPersonaDao extends CrudRepository<Persona, Long> {
	List<Persona> findByPerNombreContainsAndPerTipoDocumentoContains(String perNombre, String perTipoDocumento);
}
