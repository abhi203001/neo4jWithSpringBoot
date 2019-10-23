package com.example.neo4j.demoNeo4j.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.neo4j.demoNeo4j.Model.Country;
import com.example.neo4j.demoNeo4j.Model.IndiaData;
import com.example.neo4j.demoNeo4j.Model.Source;
import com.example.neo4j.demoNeo4j.Model.Topic;
import com.example.neo4j.demoNeo4j.Service.TopicService;


@RestController
public class TopicController {
	
	@Autowired
	TopicService ts;
	
	@RequestMapping(value="/listAllTopics",method = RequestMethod.GET)
	@ResponseBody
	 public Collection<Topic> getDataTopic() {
       return ts.getAllTopic();
	}
	
	@RequestMapping(value="/listAllSources",method = RequestMethod.GET)
	@ResponseBody
	 public Collection<Source> getDataSource() {
       return ts.getAllSource();
	}
	
	@RequestMapping(value="/listAllCountries",method = RequestMethod.GET)
	@ResponseBody
	 public Collection<Country> getDataCountries() {
       return ts.getAllCountries();
	}
	
	@RequestMapping(value="/getIndiaData",method = RequestMethod.GET)
	@ResponseBody
	 public Collection<IndiaData> getIndiaData() {
       return ts.getIndiaData();
	}
	
	@RequestMapping(value="/abc",method = RequestMethod.GET)
	@ResponseBody
	 public Iterable<Topic> getAll() {
       return ts.getAll();
	}
	
}
