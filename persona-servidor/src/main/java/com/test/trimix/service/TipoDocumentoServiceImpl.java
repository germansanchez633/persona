package com.test.trimix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.trimix.entity.TipoDocumento;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

	@Override
	public List<String> getTipoDocumentos() {
		List<String> listaTipoDocumentos = new ArrayList<>();
		listaTipoDocumentos.add("DNI");
		listaTipoDocumentos.add("Pasaporte");
		listaTipoDocumentos.add("Cedula");
		
		return listaTipoDocumentos;
	}

}
