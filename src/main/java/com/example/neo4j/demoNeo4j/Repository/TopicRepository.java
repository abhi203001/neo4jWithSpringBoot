package com.example.neo4j.demoNeo4j.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

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
	
	@Query("MATCH (i:IndiaData) return avg(i.Sentiment) as sentiment")
	Double averageSentiment();
	
	@Query("MATCH (t:Topic),(c:Country),(s:Source),(i:IndiaData) "
			+ "WHERE t.name = \"Economy\" and s.name = \"Reddit\" and c.name=\"INDIA\" and i.Date >= '2019-10-01' AND i.Date <= '2019-10-03'"
			+ " RETURN  i.Title as title,i.Sentiment as sentiment,i.Date as date,s.name as source,c.name as country ")
	List<Map<String, Object>> customData();
	
	@Query("MATCH (t:Topic)-[:DATA_FROM]->(s:Source)-[:FROM]->(c:Country)-[:HAVE]->(i:IndiaData)"
			+ " WHERE t.name={0} and c.name={1} and s.name={2} and i.Keyword = {3} RETURN t.name as TopicName,s.name as SourceName,"
			+ " c.name as CountryName, i.Keyword as keyword , i.Title as title , i.Sentiment as sentiment,i.Date as date,"
			+ "i.URL as url")
	List<Map<String,Object>> getDataByKeyword(@Param("TopicName") String TopicName,@Param("CountryName") String CountryName,@Param("SourceName") String SourceName,@Param("keyword") String keyword);
	
	@Query("MATCH (c:Country),(i:IndiaData) WHERE c.name = {0} RETURN c.name as country,i.Topic as topic , i.Title as title , i.Sentiment as sentiment")
	List<Map<String,Object>> getDataByCountry(@Param("country") String country);
	
	@Query("MATCH (i:IndiaData) WHERE s.name = {0} RETURN i.Topic as topic , i.Title as title , i.Sentiment as sentiment")
	List<Map<String,Object>> getDataBySource(@Param("source") String source);
}
