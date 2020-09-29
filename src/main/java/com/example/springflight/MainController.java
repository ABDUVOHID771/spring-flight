package com.example.springflight;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.opensky.api.OpenSkyApi;
import org.opensky.model.OpenSkyStates;
import org.opensky.model.StateVector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;

@Slf4j
@Controller
public class MainController {
  private final RestTemplate rest;

  public MainController(RestTemplate rest) {
    this.rest = rest;
  }

  @GetMapping("/location")
  public String getLocation(Model model) throws IOException {
    log.info("CONNECTING...");
    OpenSkyApi api = new OpenSkyApi("", "");
    OpenSkyStates os =
        api.getStates(0, null, new OpenSkyApi.BoundingBox(45.8389, 47.8229, 5.9962, 10.5226));
    String os_ = os.getStates().toString().replaceAll("=", ":");
    Gson gson = new Gson();
    Collection<StateVector> stateVector = os.getStates();
    for (StateVector vector : stateVector) {
      model.addAttribute(
          "bodyy",
          rest.getForObject(
              "https://www.latlong.net/c/?lat="
                  + vector.getLatitude()
                  + "&long="
                  + vector.getLongitude(),
              String.class));
      return "index";
    }
    return "NOT WORKED";
    //        log.info("CONNECTED");
    //        log.info("================================================AVAILABLE
    // FLIGHTS============================================== \n{}", stateVector.toString());
    //        log.warn("CONNECTION DOWN");
  }
}
