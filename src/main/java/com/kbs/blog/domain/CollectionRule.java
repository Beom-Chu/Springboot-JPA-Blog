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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="RML_COLLECTION_RULE", indexes=@Index(name="idx_collection_rm_id", columnList="rmId"))
public class CollectionRule {

	 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long collectionRuleId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rmId")
	@JsonIgnoreProperties({"collection"}) // RM 모델의 collectionRule 프로퍼티는 제외
	private RM rm;						// RM (FK)
		
	@Column(length = 30)
	private String label;				// 규칙명
	
	@Column(length = 1000)
	private String query;				// 질의문
	
	@Column(length = 20)
	private String rootObject;			// JSON 최상위 오브젝트
	
	@Column(length = 20)
	private String parentObject;		// JSON 부모 오브젝트
	
	private Integer sheetNumber;		// Excel 시트번호
	
	private Integer startRowNumber; 	// Excel, CSV 시작행 번호

	@Column(length = 20)
	private String recursiveRoot;		// XML 반복 태그

	@Column(length = 20)
	private String separater;			// 구분자
	
	@Column(length = 20)
	private String target;			// 변환대상

  public Long getCollectionRuleId() {
    return collectionRuleId;
  }

  public void setCollectionRuleId(Long collectionRuleId) {
    this.collectionRuleId = collectionRuleId;
  }

  public RM getRm() {
    return rm;
  }

  public void setRm(RM rm) {
    this.rm = rm;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public String getRootObject() {
    return rootObject;
  }

  public void setRootObject(String rootObject) {
    this.rootObject = rootObject;
  }

  public String getParentObject() {
    return parentObject;
  }

  public void setParentObject(String parentObject) {
    this.parentObject = parentObject;
  }

  public Integer getSheetNumber() {
    return sheetNumber;
  }

  public void setSheetNumber(Integer sheetNumber) {
    this.sheetNumber = sheetNumber;
  }

  public Integer getStartRowNumber() {
    return startRowNumber;
  }

  public void setStartRowNumber(Integer startRowNumber) {
    this.startRowNumber = startRowNumber;
  }

  public String getRecursiveRoot() {
    return recursiveRoot;
  }

  public void setRecursiveRoot(String recursiveRoot) {
    this.recursiveRoot = recursiveRoot;
  }

  public String getSeparater() {
    return separater;
  }

  public void setSeparater(String separater) {
    this.separater = separater;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }
	


}
