package br.com.danielamaral.mineradora.ativos.config;


import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import br.com.danielamaral.mineradora.ativos.util.LoggerUtil;

@Configuration
public class TimeZoneConfig {
    @Primary
    @Bean
    public void setTimeZone(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        LoggerUtil.logInfo(
                "Default TimeZone: " + TimeZone.getDefault().getDisplayName(), "TimeZoneConfig.setTimeZone");
    }
}
