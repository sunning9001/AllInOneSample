/**
 * @author chenwei
 * @date: 2018年8月21日 下午8:09:03
 * 
 */
package com.panli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicate;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenwei
 * @date: 2018年8月8日 下午5:44:30
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer  {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

	
	@Bean
    public Docket openApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
              
                if (input.getHandlerMethod().hasMethodAnnotation(ApiOperation.class))//只有添加了ApiOperation注解的method才在API中显示
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("openApi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis(predicate)
//                .apis(RequestHandlerSelectors.basePackage("com.yug.appController.activity"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(apiInfo());
    }
	
//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                // 自行修改为自己的包路径
//                .apis(RequestHandlerSelectors.basePackage("com.yug.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api文档")
                .description("restfun 风格接口")
                //服务条款网址
                //.termsOfServiceUrl("http://blog.csdn.net/forezp")
                .version("1.0")
                .description("描述")
//                .contact(new Contact("yugyg","http://www.yugyg.com","yg@yugyg.com"))
                .build();
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }
  

    
}

