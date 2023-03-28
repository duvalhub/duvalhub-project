package com.duvalhub.google;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Getter
@Setter
@Validated
public class GoogleCredentialsProperties {
  @NotEmpty
  private String clientId;
  @NotEmpty
  private String clientEmail;
  @NotEmpty
  private String privateKey;
  @NotEmpty
  private String privateKeyId;

  public void setPrivateKey(String privateKey) {
    this.privateKey = new String(Base64.getDecoder().decode(privateKey), StandardCharsets.UTF_8);
  }
}

