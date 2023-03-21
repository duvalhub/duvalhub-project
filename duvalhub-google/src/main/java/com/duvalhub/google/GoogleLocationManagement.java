package com.duvalhub.google;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.mybusinessaccountmanagement.v1.MyBusinessAccountManagement;
import com.google.api.services.mybusinessaccountmanagement.v1.model.ListAccountsResponse;
import com.google.api.services.mybusinessbusinessinformation.v1.MyBusinessBusinessInformation;
import com.google.api.services.mybusinessbusinessinformation.v1.model.ListLocationsResponse;
import com.google.api.services.mybusinessbusinessinformation.v1.model.Location;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;


@Service
public class GoogleLocationManagement {
  private final GoogleProperties googleProperties;
  private final MyBusinessAccountManagement myBusinessAccountManagement;
  private final MyBusinessBusinessInformation myBusinessBusinessInformation;
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

  public GoogleLocationManagement(GoogleProperties googleProperties, GoogleAuthentication googleAuthentication) throws GeneralSecurityException, IOException {
    this.googleProperties = googleProperties;
    GoogleCredentials credentials = googleAuthentication.authenticate();
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    HttpRequestInitializer credential = new HttpCredentialsAdapter(credentials);
    myBusinessAccountManagement = new MyBusinessAccountManagement.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(googleProperties.getGoogleApplicationName()).build();
    myBusinessBusinessInformation = new MyBusinessBusinessInformation.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(googleProperties.getGoogleApplicationName()).build();
  }

  public Location getLocation() throws IOException {
    String locationId = googleProperties.getLocationId();
    return getLocation(locationId);
  }

  public Location getLocation(String locationId) throws IOException {
    return myBusinessBusinessInformation.locations().get("locations/" + locationId).setReadMask("name,regularHours,specialHours,moreHours,openInfo").execute();
  }

  public ListLocationsResponse getLocations() throws IOException {
    return myBusinessBusinessInformation.accounts().locations().list("accounts/" + googleProperties.getAccountId()).setReadMask("name").execute();
  }

  public ListAccountsResponse getAccounts() throws IOException {
    return myBusinessAccountManagement.accounts().list().execute();
  }
}
