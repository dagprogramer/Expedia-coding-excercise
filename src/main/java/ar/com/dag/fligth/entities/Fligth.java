package ar.com.dag.fligth.entities;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Fligth {
    private String flightNumber;
    private String airlineCode;
    private String airlineName;
    private String departureCityCode;
    private String departureCityName;
    private String arrivalCityCode;
    private String arrivalCityName;
    private String departureDate;
    private String arrivalDate;
    private Integer gate;
}
