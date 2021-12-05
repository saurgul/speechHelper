package com.speechhelper.databasemanager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(SpeechID.class)
@Table(name="Report")
public class ReportEntity {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name="reportId")
	  private Long reportId;
	
	  @Id
	  @Column(name="speechId")
	  private Long speechId;
	  
	  @Id
	  @Column(name="userId")
	  private Long userId;
	  
	  public ReportEntity() {}
	
	  @Override
	  public String toString() {
	    return String.format(
	        "User[reportId=%d, speechId=%d, userId=%d]",
	        reportId, speechId, userId);
	  }
	  
	public Long getReportId() {
		return reportId;
	}
	
	public void setReportId(Long reportId) {
		this.reportId = reportId;
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
}
