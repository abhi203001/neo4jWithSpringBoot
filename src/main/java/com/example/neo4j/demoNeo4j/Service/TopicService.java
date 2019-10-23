package com.example.neo4j.demoNeo4j.Service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.neo4j.demoNeo4j.Model.Country;
import com.example.neo4j.demoNeo4j.Model.IndiaData;
import com.example.neo4j.demoNeo4j.Model.Source;
import com.example.neo4j.demoNeo4j.Model.Topic;
import com.example.neo4j.demoNeo4j.Repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository tr;
	
	public Collection<Topic> getAllTopic() {
		return tr.getAllTopic();
	}
	
	public Collection<Source> getAllSource() {
		return tr.getAllSource();
	}
	
	public Collection<Country> getAllCountries(){
		return tr.getAllCountries();
	}
	
	public Collection<IndiaData> getIndiaData(){
		return tr.getAllIndiaData();
	}
	
	public Iterable<Topic> getAll() {
		return tr.findAll();
	}

}