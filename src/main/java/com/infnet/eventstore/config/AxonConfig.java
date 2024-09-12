package com.infnet.eventstore.config;


import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.config.EventProcessingModule;
import org.axonframework.eventhandling.EventProcessor;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    public EventProcessingConfigurer eventProcessingConfigurer() {
        return new EventProcessingConfigurer() {
            @Override
            public void configure(EventProcessingModule module) {
                // Configurações personalizadas do processador de eventos
                module.registerEventProcessor("myProcessor", configuration ->
                        TrackingEventProcessorConfiguration.forSingleThreadedProcessing());
            }
        };
    }
}