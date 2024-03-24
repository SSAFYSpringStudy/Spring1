package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("애플리케이션 모든 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames =ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition= ac.getBeanDefinition(beanDefinitionName);

            // 스프링의 내부에서 뭔가를 하기 위해 등록한 빈들이 아니라, 애플리케이션을 개발하기 위해서 등록한 빈들 / 외부 라이브러리
            if(beanDefinition.getRole() ==BeanDefinition.ROLE_APPLICATION) {
                Object bean= ac.getBean(beanDefinitionName);
                System.out.println("name= "+beanDefinitionName+" object= "+bean);
            }
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames =ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean= ac.getBean(beanDefinitionName);
            System.out.println("name= "+beanDefinitionName+" object= "+bean);
        }
    }

}
