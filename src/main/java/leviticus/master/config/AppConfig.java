package leviticus.master.config;

import leviticus.master.enums.ClassificationModelType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public Map<ClassificationModelType, Integer> getRouter() {
        Map<ClassificationModelType, Integer> router = new HashMap<>();
        router.put(ClassificationModelType.LBP, 8000);
        router.put(ClassificationModelType.MINIVGG, 8001);
        return router;
    }

}
