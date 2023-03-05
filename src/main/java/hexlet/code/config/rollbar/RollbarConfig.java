package hexlet.code.config.rollbar;

import com.rollbar.notifier.Rollbar;
import com.rollbar.notifier.config.Config;
import com.rollbar.spring.webmvc.RollbarSpringConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan({
    "hexlet.code.app"
})
public class RollbarConfig {
//    @Value("${ROLLBAR_TOKEN}")
//    private String rollbarToken;
//    @Value("${spring.profiles.active:}")
//    private String activeProfile;

    @Bean
    public Rollbar rollbar() {
        return new Rollbar(getRollbarConfigs("7077e9822a80484d9f1870e7f6b96946"));
    }

    private Config getRollbarConfigs(String accessToken) {
        return RollbarSpringConfigBuilder.withAccessToken(accessToken)
                .environment("production")
//                .enabled(activeProfile.equals("prod"))
                .build();
    }
}
