/**
 * 
 */
package spring.configuration.javacode.config2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import spring.configuration.javacode.interfaces.Coach;
import spring.configuration.javacode.interfaces.FortuneService;
import spring.configuration.javacode.interfaces.impl.SadFortuneService;
import spring.configuration.javacode.interfaces.impl.SwimCoach;

/**
 * @author Jonathan Vinh
 */
@Configuration
@PropertySource("classpath:application.properties")
public class SportConfig {
    
    @Bean
    public LoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
		@Value("${printed.logger.level}") String printedLoggerLevel) {

	LoggerConfig myLoggerConfig = new LoggerConfig(rootLoggerLevel, printedLoggerLevel);

	return myLoggerConfig;
    }

    // Define bean for sadFortuneService
    // IMPORTANT : the method NAME will be the BEAN ID
    @Bean
    public FortuneService sadFortuneService() {
	return new SadFortuneService();
    }

    // Define bean for swimCoach AND inject dependency
    @Bean
    public Coach swimCoach() {
	return new SwimCoach(sadFortuneService());
    }

}
