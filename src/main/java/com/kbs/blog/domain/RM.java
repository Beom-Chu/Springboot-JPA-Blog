package com.kbs.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="RML_RM", indexes=@Index(name="idx_rm_file_id", columnList="fileId"))
public class RM {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rmId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fileId")
	private RmlFile rmlfile_rm;
	
	@Column(length=200)
	private String description;		// 설명
	
	@Column(length = 20)
	private String target;			// 변환대상

	private Boolean isEnabled;		// 변환유무

	@Column(length = 50)
	private String hasLicense;		// 라이선스
	
	@Column(length = 30)
	private String source;			// 출처
	
	@Column(length = 20)
	private String publisher;		// 발행자
	
	@Column(length = 200)
	private String resultFilePath;	// 결과 파일경로
	
	@Column(length = 10)
	private String resultType;		// 결과타입
	
	@Column(length = 20)
	private String hasSchema; 		// 스키마파일명
	

	public Long getRmId() {
		return rmId;
	}

	public void setRmId(Long rmId) {
		this.rmId = rmId;
	}


	public RmlFile getRmlfile_rm() {
		return rmlfile_rm;
	}
	
	public void setRmlfile_rm(RmlFile rmlfile_rm) {
		this.rmlfile_rm = rmlfile_rm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getHasLicense() {
		return hasLicense;
	}

	public void setHasLicense(String hasLicense) {
		this.hasLicense = hasLicense;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getResultFilePath() {
		return resultFilePath;
	}

	public void setResultFilePath(String resultFilePath) {
		this.resultFilePath = resultFilePath;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getHasSchema() {
		return hasSchema;
	}

	public void setHasSchema(String hasSchema) {
		this.hasSchema = hasSchema;
	}
}
