package com.kbs.blog.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="RML_MAPPING_RULE", indexes=@Index(name="idx_mapping_collection_rule_id", columnList="collectionRuleId"))
public class MappingRule {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mappingRuleId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
	  @JoinColumn(name="collectionRuleId", referencedColumnName = "collectionRuleId"), 
	  @JoinColumn(name="rmId", referencedColumnName = "rmId")})
	private CollectionRule collectionRule;		// CollectionRule (FK)
	
	@Column(length = 50)
	private String label;				// 규칙명
	
	@Column(length = 100)
	private String subject;				// 주어
	
	@Column(length = 100)
	private String predicate;			// 술어
	
	@Column(length = 100)
	private String object;				// 목적어
	
	@Column(length = 50)
	private String subjectBox;			// 주어 셀렉트박스 
	
	@Column(length = 50)
	private String predicateBox;			// 술어 셀렉트박스 
	
	@Column(length = 50)
	private String objectBox;			// 목적어 셀렉트박스 
	
	@Column(length = 20)
	private String conformType;			// 조합 유형
	
	@Column(length = 50)
	private String classNameOfSubject;	// 주어 클래스명
	
	@Column(length = 50)
	private String classNameOfObject;	// 목적어 클래스명
	
	@Column(length = 50)
	private String classNameOfSubjectBox;	// 주어 클래스명 셀렉트박스
	
	@Column(length = 50)
	private String classNameOfObjectBox;	// 목적어 클래스명 셀렉트박스
	
	@Column(length = 30)
	private String extFunctionToSubject;	// 주어 확장함수
	
	@Column(length = 30)
	private String extFunctionToPredicate; 	// 술어 확장함수
	
	@Column(length = 30)
	private String extFunctionToObject;		// 목적어 확장함수
	
	@Column(length = 20)
	private String prefixOfSubject;			// 주어 접두어
	
	@Column(length = 20)
	private String prefixOfObject;			// 목적어 접두어
	
	@Column(length = 20)
	private String suffixOfSubject;			// 주어 접미어
	
	@Column(length = 20)
	private String suffixOfObject;			// 목적어 접미어
	
	/*
	규칙에는 접미어 컴포넌트가 있더라고 DB에 저장시에는 컴포넌트의 resourceName을 가져와 모두 스트링값으로 저장한다.  
	@Column(length = 20)
	private String suffixOfSubjectInComponent;	// 주어 접미어 컴포넌트
	
	@Column(length = 20)
	private String suffixOfObjectInComponent;	// 목적어 접미어 컴포넌트
	*/	
	
	@Column(length = 20)
	private String tokenizer;				// (목적어) 구분자
	
	@Column(length = 20)
	private String tokenizerForSubject;		// 주어 구분자
	
	@Column(length = 20)
	private String dataTypeOfObject;		// 데이터타입 유형
	
	@Column(length = 20)
	private String langTypeOfObject;		// 언어 유형
	
	@Column(length = 50)
	private String reversePredicate;		// 역관계 프로퍼티
	
	@Column(length = 50)
	private String reversePredicateBox;		// 역관계 프로퍼티 셀렉트박스
	
	@Column(length = 100)
	private String ifNotNull;				// 조건 not null => 길이를 100으로 변경함 .
	
	@Column(length = 20)
	private String target;			// 변환대상

  public Long getMappingRuleId() {
    return mappingRuleId;
  }

  public void setMappingRuleId(Long mappingRuleId) {
    this.mappingRuleId = mappingRuleId;
  }

  public CollectionRule getCollectionRule() {
    return collectionRule;
  }

  public void setCollectionRule(CollectionRule collectionRule) {
    this.collectionRule = collectionRule;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getPredicate() {
    return predicate;
  }

  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public String getSubjectBox() {
    return subjectBox;
  }

  public void setSubjectBox(String subjectBox) {
    this.subjectBox = subjectBox;
  }

  public String getPredicateBox() {
    return predicateBox;
  }

  public void setPredicateBox(String predicateBox) {
    this.predicateBox = predicateBox;
  }

  public String getObjectBox() {
    return objectBox;
  }

  public void setObjectBox(String objectBox) {
    this.objectBox = objectBox;
  }

  public String getConformType() {
    return conformType;
  }

  public void setConformType(String conformType) {
    this.conformType = conformType;
  }

  public String getClassNameOfSubject() {
    return classNameOfSubject;
  }

  public void setClassNameOfSubject(String classNameOfSubject) {
    this.classNameOfSubject = classNameOfSubject;
  }

  public String getClassNameOfObject() {
    return classNameOfObject;
  }

  public void setClassNameOfObject(String classNameOfObject) {
    this.classNameOfObject = classNameOfObject;
  }

  public String getClassNameOfSubjectBox() {
    return classNameOfSubjectBox;
  }

  public void setClassNameOfSubjectBox(String classNameOfSubjectBox) {
    this.classNameOfSubjectBox = classNameOfSubjectBox;
  }

  public String getClassNameOfObjectBox() {
    return classNameOfObjectBox;
  }

  public void setClassNameOfObjectBox(String classNameOfObjectBox) {
    this.classNameOfObjectBox = classNameOfObjectBox;
  }

  public String getExtFunctionToSubject() {
    return extFunctionToSubject;
  }

  public void setExtFunctionToSubject(String extFunctionToSubject) {
    this.extFunctionToSubject = extFunctionToSubject;
  }

  public String getExtFunctionToPredicate() {
    return extFunctionToPredicate;
  }

  public void setExtFunctionToPredicate(String extFunctionToPredicate) {
    this.extFunctionToPredicate = extFunctionToPredicate;
  }

  public String getExtFunctionToObject() {
    return extFunctionToObject;
  }

  public void setExtFunctionToObject(String extFunctionToObject) {
    this.extFunctionToObject = extFunctionToObject;
  }

  public String getPrefixOfSubject() {
    return prefixOfSubject;
  }

  public void setPrefixOfSubject(String prefixOfSubject) {
    this.prefixOfSubject = prefixOfSubject;
  }

  public String getPrefixOfObject() {
    return prefixOfObject;
  }

  public void setPrefixOfObject(String prefixOfObject) {
    this.prefixOfObject = prefixOfObject;
  }

  public String getSuffixOfSubject() {
    return suffixOfSubject;
  }

  public void setSuffixOfSubject(String suffixOfSubject) {
    this.suffixOfSubject = suffixOfSubject;
  }

  public String getSuffixOfObject() {
    return suffixOfObject;
  }

  public void setSuffixOfObject(String suffixOfObject) {
    this.suffixOfObject = suffixOfObject;
  }

  public String getTokenizer() {
    return tokenizer;
  }

  public void setTokenizer(String tokenizer) {
    this.tokenizer = tokenizer;
  }

  public String getTokenizerForSubject() {
    return tokenizerForSubject;
  }

  public void setTokenizerForSubject(String tokenizerForSubject) {
    this.tokenizerForSubject = tokenizerForSubject;
  }

  public String getDataTypeOfObject() {
    return dataTypeOfObject;
  }

  public void setDataTypeOfObject(String dataTypeOfObject) {
    this.dataTypeOfObject = dataTypeOfObject;
  }

  public String getLangTypeOfObject() {
    return langTypeOfObject;
  }

  public void setLangTypeOfObject(String langTypeOfObject) {
    this.langTypeOfObject = langTypeOfObject;
  }

  public String getReversePredicate() {
    return reversePredicate;
  }

  public void setReversePredicate(String reversePredicate) {
    this.reversePredicate = reversePredicate;
  }

  public String getReversePredicateBox() {
    return reversePredicateBox;
  }

  public void setReversePredicateBox(String reversePredicateBox) {
    this.reversePredicateBox = reversePredicateBox;
  }

  public String getIfNotNull() {
    return ifNotNull;
  }

  public void setIfNotNull(String ifNotNull) {
    this.ifNotNull = ifNotNull;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mappingRule", fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"mappingRule"}) // ConditionSubject 모델의 mappingRule 프로퍼티는 제외
//	private List<ConditionSubject> conditionSubject = new ArrayList<ConditionSubject>();
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mappingRule", fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"mappingRule"}) // ConditionPredicate 모델의 mappingRule 프로퍼티는 제외
//	private List<ConditionPredicate> conditionPredicate = new ArrayList<ConditionPredicate>();
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mappingRule", fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"mappingRule"}) // ConditionObject 모델의 mappingRule 프로퍼티는 제외
//	private List<ConditionObject> conditionObject = new ArrayList<ConditionObject>();
	
	
//	@OneToOne(mappedBy = "mappingRule")
//	private ConditionSubject conditionSubject;
//	
//	@OneToOne(mappedBy = "mappingRule")
//	private ConditionObject conditionObject;
//	
//	@OneToOne(mappedBy = "mappingRule")
//	private ConditionPredicate condtitionPredicate;
	
	
}
