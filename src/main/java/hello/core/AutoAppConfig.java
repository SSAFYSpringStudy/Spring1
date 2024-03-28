package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정 정보이므로 적어주기
@ComponentScan( //사용시 @Component가 붙은 스프링 빈을 모두 찾아서 자동으로 등록해준다.

        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //여러개 자동 등록 중 뺄것들을 지정해준다.
        //저 Configuration은 자동으로 등록되면 안된다.
)
public class AutoAppConfig {
}
