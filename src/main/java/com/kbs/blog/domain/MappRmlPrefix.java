package com.kbs.blog.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RML_MAPP_RML_PREIFX")
public class MappRmlPrefix {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mappId;
	
	private boolean base;		// 베이스 URI 여부
	
  @ManyToOne
  @JoinColumns({@JoinColumn(name = "fileId", referencedColumnName = "fileId"),
      @JoinColumn(name = "rmId", referencedColumnName = "rmId")})
  private RM rm;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "prefixId") 
	private Prefix prefix;

  public Long getMappId() {
    return mappId;
  }

  public void setMappId(Long mappId) {
    this.mappId = mappId;
  }

  public boolean isBase() {
    return base;
  }

  public void setBase(boolean base) {
    this.base = base;
  }

  public RM getRm() {
    return rm;
  }

  public void setRm(RM rm) {
    this.rm = rm;
  }

  public Prefix getPrefix() {
    return prefix;
  }

  public void setPrefix(Prefix prefix) {
    this.prefix = prefix;
  }
	
}
