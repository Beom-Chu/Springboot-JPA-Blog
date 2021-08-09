package com.kbs.blog.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

  private static final String API_NAME = "Beom-Chu Blog API";
  private static final String API_VERSION = "0.0.1";
  private static final String API_DESCRIPTION = "BeomChu Blog API 입니다.";
  private static final String API_GROUP_NAME = "그룹1";
  
  private final TypeResolver typeResolver;
  
  public SwaggerConfig(TypeResolver typeResolver) {
    this.typeResolver = typeResolver;
  }
  
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .alternateTypeRules(AlternateTypeRules.newRule(typeResolver.resolve(Pageable.class), typeResolver.resolve(Page.class)))
              .apiInfo(apiInfo())
              .groupName(API_GROUP_NAME)
              .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build();
  }

  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
              .title(API_NAME)
              .version(API_VERSION)
              .description(API_DESCRIPTION)
              .build();
  }
  
  @ApiModel
  static class Page {
      @ApiModelProperty(value = "페이지 번호(0..N)", example = "0")
      private Integer page;

      @ApiModelProperty(value = "페이지 크기", allowableValues="range[0, 100]", example = "0")
      private Integer size;

      @ApiModelProperty(value = "정렬(사용법: 컬럼명,ASC|DESC)")
      private List<String> sort;

      public Integer getPage() {
        return page;
      }

      public void setPage(Integer page) {
        this.page = page;
      }

      public Integer getSize() {
        return size;
      }

      public void setSize(Integer size) {
        this.size = size;
      }

      public List<String> getSort() {
        return sort;
      }

      public void setSort(List<String> sort) {
        this.sort = sort;
      }
  }
}