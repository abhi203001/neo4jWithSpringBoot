package com.example.neo4j.demoNeo4j.Model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Topic {

    @Id
    private Long id;
    private String name;
    @Relationship(type = "DATA_FROM", direction = Relationship.OUTGOING)
    private List<Source> sources;
	
    public Long getId() {
		return id;
	}
	public List<Source> getSources() {
		return sources;
	}
	public void setSources(List<Source> sources) {
		this.sources = sources;
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
