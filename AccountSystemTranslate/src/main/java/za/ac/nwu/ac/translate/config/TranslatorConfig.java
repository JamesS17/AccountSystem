package za.ac.nwu.ac.translate.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {"za.ac.nwu.ac.translate"})
public class TranslatorConfig {
}
