package com.test.trimix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.trimix.entity.Persona;
import com.test.trimix.service.IPersonaService;
import com.test.trimix.service.ITipoDocumentoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("persona")
public class PersonaRestController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping
	public List<Persona> listaPersonas()
	{
		return personaService.findAll();
	}
	
	@GetMapping("/{id}")
	public Persona getPersona(@PathVariable Long id)
	{
		return personaService.findById(id);
	}
	
	@GetMapping("/filtro")
	public List<Persona> listaPersonas(@RequestParam String nombre, @RequestParam String tipoDocumento)
	{
		return personaService.FindNombreTipoDocumento(nombre, tipoDocumento);
	}
	
	@PostMapping
	public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona)
	{
		Persona personaNueva = personaService.save(persona);
		return ResponseEntity.ok(personaNueva);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarPersona(@PathVariable Long id)
	{
		personaService.delete(id);
	}
}
