package com.example.springflight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateVector {
  private String geoAltitude;
  private Double longitude;
  private Double latitude;
  private Double velocity;
  private Double heading;
  private Double verticalRate;
  private String icao24;
  private String callsign;
  private boolean onGround;
  private Double lastContact;
  private Double lastPositionUpdate;
  private String originCountry;
  private String squawk;
  private boolean spi;
  private String baroAltitude;
  private String positionSource;
  private String serials;

  @Override
  public String toString() {
    return "StateVector{"
        + "geoAltitude='"
        + geoAltitude
        + '\''
        + ", longitude="
        + longitude
        + ", latitude="
        + latitude
        + ", velocity="
        + velocity
        + ", heading="
        + heading
        + ", verticalRate="
        + verticalRate
        + ", icao24='"
        + icao24
        + '\''
        + ", callsign='"
        + callsign
        + '\''
        + ", onGround="
        + onGround
        + ", lastContact="
        + lastContact
        + ", lastPositionUpdate="
        + lastPositionUpdate
        + ", originCountry='"
        + originCountry
        + '\''
        + ", squawk='"
        + squawk
        + '\''
        + ", spi="
        + spi
        + ", baroAltitude='"
        + baroAltitude
        + '\''
        + ", positionSource='"
        + positionSource
        + '\''
        + ", serials='"
        + serials
        + '\''
        + '}';
  }
}
