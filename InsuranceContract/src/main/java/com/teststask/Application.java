package com.teststask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;


/**
 * Аннотация @EnableCaching запускает post processor,
 * 	который проверяет каждый Spring бин на наличие аннотаций кеширования для public методов.
 * Если такая аннотация найдена, то автоматически созданный прокси перехватает вызов метода
 * 	и обрабатывает в соответствии споведением кеширования.
 */
@EnableCaching
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * В основе своей, аннотации требуется CacheManager как поставщика соответствующего кэша.
     * В данном примере вы используете реализацию,
     * 	которая возвращает ConcurrentHashMap. Интерфейс CachingConfigurer предоставляет более расширенные варианты настройки.
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("contracts");
    }
}
