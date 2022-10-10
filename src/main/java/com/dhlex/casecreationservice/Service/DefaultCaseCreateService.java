package com.dhlex.casecreationservice.Service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.json.XML;  

@Service
public class DefaultCaseCreateService implements CaseCreateService{
	
	Logger logger =  LoggerFactory.getLogger(DefaultCaseCreateService.class);

	@Override
	public void extractSIR(String json) throws JsonMappingException, JsonProcessingException, ParseException {
		
		getSIR(json);
	    
	}
	
	private String getSIR(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
	    JSONObject jsonObject =	(JSONObject) jsonParser.parse(json);
	  JSONObject shpJsonObject=  (JSONObject) jsonObject.get("ShpInfReqMsg");
	  logger.info("shpJsonObject ..{} ", shpJsonObject);
	  JSONObject  bdJsonObject = (JSONObject) shpJsonObject.get("Bd");
	  logger.info("bdJsonObject ... {} ", bdJsonObject);
	JSONArray shpJsonArray = (JSONArray)  bdJsonObject.get("Shp");
	 logger.info("shpJsonArray ... {} ", shpJsonArray);
		for(int i=0; i<shpJsonArray.size();i++) {
		JSONObject zObj = (JSONObject)shpJsonArray.get(0);
		 logger.info("zObj ... {} ", zObj);
		JSONArray shpJObject = (JSONArray)  zObj.get("ShpInfReqGrp");
		 logger.info("shpJObject ... {} ", shpJObject);
		for(int j = 0;j<shpJObject.size();j++) {
		JSONObject jObject =(JSONObject)	shpJObject.get(j);
		
		logger.info("jObject... {} ", jObject);
	
		
		}
		}
		return shpJsonObject.toJSONString();
	}

}
