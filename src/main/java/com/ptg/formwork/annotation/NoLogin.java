package com.ptg.formwork.annotation;

import java.lang.annotation.*;

/**
 * Description: 不需要登录拦截器放行注解
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NoLogin {
    boolean open() default true;
}
