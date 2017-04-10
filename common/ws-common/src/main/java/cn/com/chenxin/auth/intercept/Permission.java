package cn.com.chenxin.auth.intercept;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    
    /**
     * 权限集合，如果一个接口需要什么权限可以访问
     * @return
     */
    String[] value() default {};
    
    /**
     * 权限校验规则，如果type为AND，则必须规则里面的权限需同时满足<br/>
     * 如果为OR，则只需要包含其中一个权限就可以通过访问
     * @return
     */
    AuthType type() default AuthType.OR;
    
    /**
     * 权限标题，用于显示标注权限英文对应的中文名称，便于维护
     * @return
     */
    String[] title() default {};

}
