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
@Table(name="RML_ORIGINAL_SOURCE", indexes=@Index(name="idx_originalsource_rm_id", columnList="rmId"))
public class OriginalSource {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long originalSourceId;
	
	@Column(length = 20)
	private String sourceType;		// 변환대상 종류
	
	@Column(length = 100)
	private String fileName; 		// 파일명
	
	@Column(length = 100)
	private String fileUniqueName; 		// 파일명-중복방지 처리
	
	@Column(length = 100)
	private String filePath;		// 파일 경로
	
	@Column(length = 20)
	private String dbUser;			// DB 사용자명
	
	@Column(length = 20)
	private String dbPassword; 	// DB 비밀번호
	
	@Column(length = 20)
	private String ip;				// DB IP
	
	@Column(length = 20)
	private String port; 			// DB Port
	
	@Column(length = 20)
	private String serviceName;		// DB 서비스명
	
	@Column(length = 20)
	private String driverName;		// DB 드라이버명
	
	@Column(length = 50)
	private String apiUrl;			// api url 주소
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="rmId")
	private RM rm;

  public Long getOriginalSourceId() {
    return originalSourceId;
  }

  public void setOriginalSourceId(Long originalSourceId) {
    this.originalSourceId = originalSourceId;
  }

  public String getSourceType() {
    return sourceType;
  }

  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileUniqueName() {
    return fileUniqueName;
  }

  public void setFileUniqueName(String fileUniqueName) {
    this.fileUniqueName = fileUniqueName;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getDbUser() {
    return dbUser;
  }

  public void setDbUser(String dbUser) {
    this.dbUser = dbUser;
  }

  public String getDbPassword() {
    return dbPassword;
  }

  public void setDbPassword(String dbPassword) {
    this.dbPassword = dbPassword;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public String getApiUrl() {
    return apiUrl;
  }

  public void setApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
  }

  public RM getRm() {
    return rm;
  }

  public void setRm(RM rm) {
    this.rm = rm;
  }
	
}
