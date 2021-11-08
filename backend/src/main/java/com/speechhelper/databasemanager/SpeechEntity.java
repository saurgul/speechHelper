package com.speechhelper.databasemanager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Speech")
public class SpeechEntity {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name="speechId")
	  private Long speechId;
	  
	  @Id
	  @Column(name="userId")
	  private Long userId;
	  
	  @Column(name="transcriberSpeechText")
	  private String transcribedSpeechText;
	  
	  @Column(name="convertedSpeechText")
	  private String convertedSpeechText;

	  protected SpeechEntity() {}

	  public SpeechEntity(Long userId, String transcribedSpeechText, String convertedSpeechText) {
		  this.userId = userId;
		  this.transcribedSpeechText = transcribedSpeechText;
		  this.convertedSpeechText = convertedSpeechText;
	  }

	  @Override
	  public String toString() {
	    return String.format(
	        "Speech[speechId=%d, userId='%d', transcribedSpeechText='%s', convertedSpeechText='%s']",
	        speechId, userId, transcribedSpeechText, convertedSpeechText );
	  }
	  
	  public Long getSpeechId() {
		    return speechId;
		  }
		  
	  public void setSpeechId(Long speechId) {
		  	this.speechId = speechId;
	  }
	  
	  public Long getUserId() {
		    return userId;
		  }
		  
	  public void setUserId(Long userId) {
		  	this.userId = userId;
	  }
	  
	  public String getTranscribedSpeechText() {
		  return transcribedSpeechText;
	  }
	  
	  public void setTranscribedSpeechText(String transcribedSpeechText) {
		  this.transcribedSpeechText = transcribedSpeechText;
	  }
	
	  public String getConvertedSpeechText() {
		  return convertedSpeechText;
	  }
	  
	  public void setConvertedSpeechText(String convertedSpeechText) {
		  this.convertedSpeechText = convertedSpeechText;
	  }
	  
}
