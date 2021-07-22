package com.test.trimix;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.test.trimix.entity.Persona;
import com.test.trimix.service.IPersonaService;

@SpringBootTest
class PersonaTest {

	@Autowired
	private IPersonaService personaService;
	
	
	@ParameterizedTest
	@CsvSource({"Marcos,Figal,DNI,25325954,12/05/1985",
				"Cristian,Ferreira,Cedula,18547962,12/09/1972"})
	public void testPersona(String perNombre, String perApellido, String perTipoDocumento, Long perNumeroDocumento, String perFechaNacimiento)
	{
		Persona persona = new Persona();
		persona.setPerNombre(perNombre);
		persona.setPerApellido(perApellido);
		persona.setPerTipoDocumento(perTipoDocumento);
		persona.setPerNumeroDocumento(perNumeroDocumento);
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			persona.setPerFechaNacimiento(formatoFecha.parse(perFechaNacimiento));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Long id = personaService.save(persona).getPerId();
		
		assertEquals(persona, personaService.findById(id));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"null,Figal,DNI,25325954,12/05/1985",
				"Cristian,null,Cedula,18547962,12/09/1972",
				"Miguel,Lopez,null,21845965,04/09/1979",
				"Pablo,Suarez,Pasporte,null,11/05/1972",
				"Fernando,Figal,Cedula,15546962,null",}, nullValues = {"null"})
	public void testPersonaNulos(String perNombre, String perApellido, String perTipoDocumento, Long perNumeroDocumento, String perFechaNacimiento)
	{
		Persona persona = new Persona();
		persona.setPerNombre(null);
		persona.setPerApellido(perApellido);
		persona.setPerTipoDocumento(perTipoDocumento);
		persona.setPerNumeroDocumento(perNumeroDocumento);
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			persona.setPerFechaNacimiento(perFechaNacimiento==null?null:formatoFecha.parse(perFechaNacimiento));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThrows(DataIntegrityViolationException.class, () -> personaService.save(persona).getPerId());
	}

}
