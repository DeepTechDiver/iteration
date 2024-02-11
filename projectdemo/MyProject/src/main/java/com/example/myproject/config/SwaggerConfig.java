package com.example.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        ParameterBuilder builder = new ParameterBuilder();
        List<Parameter> paramenterList = new ArrayList<Parameter>();
        Parameter build = builder.name("Authorization").description("Authorization").modelRef(new ModelRef("String")).parameterType("header").required(false).build();
        paramenterList.add(build);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.myproject"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(paramenterList);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-api 文档")
                .description("API")
                .version("1.0")
                .build();
    }
}


