package com.speechhelper.databasemanager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository <ReportEntity, Long> {
	List<ReportEntity> findAll();
	ReportEntity findByReportId(long reportId);
	ReportEntity findBySpeechId(long speechId);
}
