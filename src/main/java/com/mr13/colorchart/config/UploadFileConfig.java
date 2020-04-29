package com.mr13.colorchart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class UploadFileConfig {

  @Bean(name = "multipartResolver")
  public CommonsMultipartResolver multipartResolver() {

    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(1_000_000);

    return multipartResolver;
  }
}
