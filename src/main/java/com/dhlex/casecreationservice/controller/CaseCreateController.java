package com.dhlex.casecreationservice.controller;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhlex.casecreationservice.Service.CaseCreateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;



@RestController
public class CaseCreateController {
	
	Logger logger =  LoggerFactory.getLogger(CaseCreateController.class);
	
	@Autowired
	CaseCreateService caseCreateService;
	
	

	@RequestMapping("/check")
	public String healthCheck()
	{
		logger.info("testing the heath check");
		return "Hi...";
	}

	
	@RequestMapping(path ="/create" , method = RequestMethod.POST)
	public void caseCreate(@RequestBody String json) throws JsonMappingException, JsonProcessingException, ParseException {
	//	logger.info("inside case creta cntroller");
		logger.info("json .. {} ", json);
		caseCreateService.extractSIR(json);
		
	}

}
