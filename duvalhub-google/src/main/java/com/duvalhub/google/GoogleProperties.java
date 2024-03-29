package com.duvalhub.google;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;


@Configuration
@ConfigurationProperties("google")
@Getter
@Setter
@Validated
public class GoogleProperties {
  @NotEmpty
  private String googleApplicationName;
  @NotEmpty
  private String accountId;
  @NotEmpty
  private String locationId;
  private GoogleCredentialsProperties credentials;
}

