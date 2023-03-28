package com.duvalhub.google.autoconfiguration;

import com.duvalhub.google.GoogleAuthentication;
import com.duvalhub.google.GoogleLocationManagement;
import com.duvalhub.google.GoogleProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    GoogleAuthentication.class,
    GoogleProperties.class,
    GoogleLocationManagement.class
})
public class GoogleAutoConfiguration {
}
