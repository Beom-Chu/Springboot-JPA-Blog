package com.kbs.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
  
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
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
}