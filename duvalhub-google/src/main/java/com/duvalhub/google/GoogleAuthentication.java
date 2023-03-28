package com.duvalhub.google;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleAuthentication {
  private final GoogleProperties googleProperties;
  private static final String BUSINESS_MANAGEMENT_SCOPE = "https://www.googleapis.com/auth/business.manage";

  public GoogleCredentials authenticate() {
    try {
      GoogleCredentialsProperties credentials = googleProperties.getCredentials();
      return ServiceAccountCredentials.fromPkcs8(credentials.getClientId(), credentials.getClientEmail(), credentials.getPrivateKey(), credentials.getPrivateKeyId(), Collections.singleton(BUSINESS_MANAGEMENT_SCOPE));
    } catch (IOException exception) {
      throw new GoogleAPIAuthenticationException("Failed to authenticate", exception);
    }
  }
}
