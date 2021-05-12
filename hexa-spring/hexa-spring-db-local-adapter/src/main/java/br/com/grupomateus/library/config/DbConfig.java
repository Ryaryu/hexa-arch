package br.com.grupomateus.library.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("br.com.grupomateus.library.repository.mapper")
public class DbConfig {

}
