package com.test.trimix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.trimix.service.ITipoDocumentoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("tipodocumento")
public class TipoDocumentoRestController {
	
	@Autowired
	ITipoDocumentoService tipoDocumentoService;
	
	@GetMapping
	public List<String> getTipoDocumentos()
	{
		return tipoDocumentoService.getTipoDocumentos();
	}
}
