package org.codi.autoapi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientRetry {

    /**
     * Maximum number of retry attempts
     */
    int max() default 0;

    /**
     * Minimum delay between any 2 attempts
     */
    int delay() default 0;

    /**
     * Additional http status codes to perform retries on
     */
    int[] status() default {};
}
