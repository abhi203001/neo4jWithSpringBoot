package com.example.neo4j.demoNeo4j.Model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Country {
	
	@Id
	private Long id;
	private String name;
	@Relationship(type = "HAVE", direction = Relationship.OUTGOING)
	private List<IndiaData> indiaData;
	


	public List<IndiaData> getIndiaData() {
		return indiaData;
	}

	public void setIndiaData(List<IndiaData> indiaData) {
		this.indiaData = indiaData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
