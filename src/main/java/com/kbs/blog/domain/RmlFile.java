package com.kbs.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RML_FILE")
public class RmlFile {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileId;
	
	@Column(length = 50)
	private String fileName; 		// 파일명
	
	@Column(length = 200)
	private String description; 	// 파일 설명
	
	@Column(length = 50)
	private String fileUniqueName; 		// 파일명-중복방지 처리
	
	@Column(length = 100)
	private String filePath; 		// 파일 서버 경로

  public Long getFileId() {
    return fileId;
  }

  public void setFileId(Long fileId) {
    this.fileId = fileId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

}
