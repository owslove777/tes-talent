package com.talent.application.config;

import com.talent.domain.ports.spi.TalentCategoryPersistencePort;
import com.talent.domain.ports.spi.TalentItemPersistencePort;
import com.talent.domain.ports.spi.TalentUserMapPersistencePort;
import com.talent.infrastructure.adapter.jpa.TalentCategoryJpaAdapter;
import com.talent.infrastructure.adapter.jpa.TalentItemJpaAdapter;
import com.talent.infrastructure.adapter.jpa.TalentUserMapJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TalentConfig {
    @Bean
    public TalentCategoryPersistencePort talentCategoryPersistence(){
        return new TalentCategoryJpaAdapter();
    }
    @Bean
    public TalentUserMapPersistencePort talentUserMapPersistence(){
        return new TalentUserMapJpaAdapter();
    }
    @Bean
    public TalentItemPersistencePort talentItemPersistence(){
        return new TalentItemJpaAdapter();
    }

//    @Bean
//    public StarRateServicePort bookService(){
//        return new StarRateServiceImpl(bookPersistence());
//    }
}
