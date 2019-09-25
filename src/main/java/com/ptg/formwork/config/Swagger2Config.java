/**
 * 
 */
package com.ptg.formwork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 的配置注入
 * @author ligj
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger.enabled}")
    private boolean enable;
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ptg.formwork.controller"))
                .paths(PathSelectors.any())
                .build();
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("老人手机助手")
                .description("老人手机助手API文档")
                .termsOfServiceUrl("...")
                .version("1.0")
                .build();
    }

	
}
