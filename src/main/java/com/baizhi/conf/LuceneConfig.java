package com.baizhi.conf;


import com.baizhi.mapper.LuceneMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LuceneConfig {
    @Bean
    public LuceneMapper getLuceneProductDao() {
        return new LuceneMapper();
    }

}
