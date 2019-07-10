package com.ladyishenlong.consultestspr.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019-07-10 11:38
 */
@Data
@Component
@RefreshScope //添加该注解才能进行动态刷新
public class Config {

    @Value("${project-name}")
    private String projectName;
}
