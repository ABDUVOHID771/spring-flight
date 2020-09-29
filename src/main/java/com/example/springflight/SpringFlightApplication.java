package com.example.springflight;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.opensky.api.OpenSkyApi;
import org.opensky.model.OpenSkyStates;
import org.opensky.model.StateVector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Slf4j
@SpringBootApplication
public class SpringFlightApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringFlightApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Component
  private class Init implements CommandLineRunner {

    private final RestTemplate rest;

    private Init(RestTemplate rest) {
      this.rest = rest;
    }

    @Override
    public void run(String... args) throws Exception {
      log.info("CONNECTING...");
      OpenSkyApi api = new OpenSkyApi("Abduvohid", "@Aristo070");
      OpenSkyStates os =
          api.getStates(0, null, new OpenSkyApi.BoundingBox(45.8389, 47.8229, 5.9962, 10.5226));
      String os_ = os.getStates().toString().replaceAll("=", ":");
      Gson gson = new Gson();
      Collection<StateVector> stateVector = os.getStates();
      //            for (StateVector vector : stateVector) {
      //                rest.getForObject("https://www.latlong.net/c/?lat=" + vector.getLatitude() +
      // "&long=" + vector.getLongitude(), String.class);
      //
      //            }
      //            OpenSkyStates os = api.getMyStates(0, null, null);
      //                    new OpenSkyApi.BoundingBox(45.8389, 47.8229, 5.9962, 10.5226));
      // filter for states of particular aircraft
      //            OpenSkyStates os = api.getMyStates(0, new String[]{"aabbcc", "cafeca"}, null);
      // or add another filter for a sub set of your receivers
      //            OpenSkyStates os = api.getMyStates(0, null, new Integer[]{12345678});
      // or do both
      //            OpenSkyStates os = api.getMyStates(0, new String[]{"aabbcc", "coffee"},
      //                    new Integer[]{12345678});

      //            OpenSkyStates os = api.getStates(0, null);
      log.info("CONNECTED");
      log.info(
          "\n================================================AVAILABLE FLIGHTS============================================== \n{}",
          stateVector.toString());
      log.warn("CONNECTION DOWN");
    }
  }
}
