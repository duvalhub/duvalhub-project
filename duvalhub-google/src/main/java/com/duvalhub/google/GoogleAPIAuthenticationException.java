package com.duvalhub.google;

import java.io.IOException;

public class GoogleAPIAuthenticationException extends RuntimeException {
  public GoogleAPIAuthenticationException(String error, Throwable throwable) {
    super(error, throwable);
  }
}
