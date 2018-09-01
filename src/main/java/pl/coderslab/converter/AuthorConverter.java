package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.DTO.AuthorDTO;
import pl.coderslab.Service.ServiceDTO.AuthorServiceDTO;


public class AuthorConverter implements Converter<String, AuthorDTO>{
	
	@Autowired
	private AuthorServiceDTO service;


	@Override
	public AuthorDTO convert(String source) {
		return service.getAuthorByID(Long.valueOf(source));
	}

}