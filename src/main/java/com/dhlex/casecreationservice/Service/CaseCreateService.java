package com.dhlex.casecreationservice.Service;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public interface CaseCreateService {
	
public void extractSIR(String json) throws JsonMappingException, JsonProcessingException, ParseException;
}
