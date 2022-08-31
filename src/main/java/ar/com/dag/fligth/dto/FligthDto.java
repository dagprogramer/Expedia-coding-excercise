package ar.com.dag.fligth.dto;

import lombok.Data;

@Data
public class FligthDto {
    private String from;
    private String to;
    private String airline;
    private String flight_number;
    private String departure_datetime;
    private String gate;
}
