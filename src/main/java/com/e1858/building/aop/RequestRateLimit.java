package com.e1858.building.aop;


import com.e1858.building.domain.enums.RateLimitEnum;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestRateLimit {
    RateLimitEnum limit() default RateLimitEnum.RRLimit_5_1;
}
