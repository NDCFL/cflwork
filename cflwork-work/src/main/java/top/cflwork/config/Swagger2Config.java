package top.cflwork.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * ${DESCRIPTION}
 *
 * @author edison
 * @create 2017-01-02 23:53
 */
@EnableSwagger2
@Component
@ComponentScan("top.cflwork.controller")
public class Swagger2Config {

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //为当前包路径
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    //构建 api文档的详细信息函数
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                //页面标题
//                .title("功能测试")
//                //创建人
//                .contact(new Contact("Edison", "xxx@qq.com", "xxx@qq.com"))
//                //版本号
//                .version("1.0")
//                //描述
//                .description("API 描述")
//                .build();
//    }

    @Bean
    public Docket contractMastApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("业主模块")
                .apiInfo(apiInfo())
                .select()
                .paths(contractMastPaths())
                .build();
    }

    private Predicate<String> contractMastPaths() {
        return or(
                regex("/contractMaster/.*")
        );
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("瑞蓝酒店后台")
                .description("<h4>瑞蓝酒店系统的所有接口文档</h4>")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("名字", "www.mykefang.com", "275300091@qq.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("1.0")
                .build();
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("77777").parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return pars;
    }
}