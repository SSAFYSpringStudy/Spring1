package hello.core.scan.filter;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented // 애노테이션 설정은 어려워 다음에
public @interface MyExcludeComponent {

}
