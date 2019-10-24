package com.example.neo4j.demoNeo4j.Model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class IndiaData {

	@Id
	private Long id;
	private String Title;
	private Float Upvote_Ratio;
	private String Keyword;
	private Float Sentiment;
	private String Date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Float getUpvote_Ratio() {
		return Upvote_Ratio;
	}
	public void setUpvote_Ratio(Float upvote_Ratio) {
		Upvote_Ratio = upvote_Ratio;
	}
	public String getKeyword() {
		return Keyword;
	}
	public void setKeyword(String keyword) {
		Keyword = keyword;
	}
	public Float getSentiment() {
		return Sentiment;
	}
	public void setSentiment(Float sentiment) {
		Sentiment = sentiment;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
	
	
	
}
