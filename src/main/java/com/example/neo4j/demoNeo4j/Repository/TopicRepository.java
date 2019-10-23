package com.example.neo4j.demoNeo4j.Repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.neo4j.demoNeo4j.Model.Country;
import com.example.neo4j.demoNeo4j.Model.IndiaData;
import com.example.neo4j.demoNeo4j.Model.Source;
import com.example.neo4j.demoNeo4j.Model.Topic;

public interface TopicRepository extends Neo4jRepository<Topic,Long>{
	
	@Query("MATCH (t:Topic)-[d:DATA_FROM]->(s:Source)-[f:FROM]->(c:Country)-[h:HAVE]->(i:IndiaData) RETURN h,i,f,c,t,s,d")
	Collection<Topic> getAllTopic();
	
	@Query("MATCH (s:Source)-[f:FROM]->(c:Country) RETURN c,f,s")
	Collection<Source> getAllSource();
	
	@Query("MATCH (c:Country) RETURN c")
	Collection<Country> getAllCountries();
	
	@Query("MATCH (c:Country)-[h:HAVE]->(i:IndiaData) RETURN c,h,i")
	Collection<IndiaData> getAllIndiaData();
	
	
	    
}
