package com.tw.pdd.swagger2;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
public class Api {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("老王阿彪").description("前后端联调api 文档").version("0.1.0")
                .build();
    }
}
