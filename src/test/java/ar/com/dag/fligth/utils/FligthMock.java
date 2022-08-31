package ar.com.dag.fligth.utils;

import ar.com.dag.fligth.entities.Fligth;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class FligthMock {

    public static final String JSON_FLIGTH_OBJECT = "[\n" +
            "  {\n" +
            "    \"flightNumber\": \"115\",\n" +
            "    \"airlineCode\": \"AA\",\n" +
            "    \"airlineName\": \"United Airlines\",\n" +
            "    \"departureCityCode\": \"NYC\",\n" +
            "    \"departureCityName\": \"New York\",\n" +
            "    \"arrivalCityCode\": \"LAX\",\n" +
            "    \"arrivalCityName\": \"Los Angeles\",\n" +
            "    \"departureDate\": \"12/18/2021 11:00 AM\",\n" +
            "    \"arrivalDate\": \"12/18/2021 03:00 PM\",\n" +
            "    \"gate\" : 12\n" +
            "  },\n" +
            "  {\n" +
            "    \"flightNumber\": \"99\",\n" +
            "    \"airlineCode\": \"AR\",\n" +
            "    \"airlineName\": \"Aerolineas Argentinas\",\n" +
            "    \"departureCityCode\": \"BUE\",\n" +
            "    \"departureCityName\": \"Buenos Aires\",\n" +
            "    \"arrivalCityCode\": \"LAX\",\n" +
            "    \"arrivalCityName\": \"Los Angeles\",\n" +
            "    \"departureDate\": \"12/18/2021 11:00 PM\",\n" +
            "    \"arrivalDate\": \"12/19/2021 06:00 AM\",\n" +
            "    \"gate\" : 22\n" +
            "  },\n" +
            "  {\n" +
            "    \"flightNumber\": \"776\",\n" +
            "    \"airlineCode\": \"AA\",\n" +
            "    \"airlineName\": \"American Airlines\",\n" +
            "    \"departureCityCode\": \"ORD\",\n" +
            "    \"departureCityName\": \"Chicago\",\n" +
            "    \"arrivalCityCode\": \"SEA\",\n" +
            "    \"arrivalCityName\": \"Seattle \",\n" +
            "    \"departureDate\": \"12/25/2021 11:00 AM\",\n" +
            "    \"arrivalDate\": \"12/26/2021 06:00 PM\",\n" +
            "    \"gate\" : 12\n" +
            "  },\n" +
            "  {\n" +
            "    \"flightNumber\": \"456\",\n" +
            "    \"airlineCode\": \"DD\",\n" +
            "    \"airlineName\": \"Delta Airlines\",\n" +
            "    \"departureCityCode\": \"MAD\",\n" +
            "    \"departureCityName\": \"Madrid\",\n" +
            "    \"arrivalCityCode\": \"LON\",\n" +
            "    \"arrivalCityName\": \"London\",\n" +
            "    \"departureDate\": \"12/26/2021 11:00 AM\",\n" +
            "    \"arrivalDate\": \"12/27/2021 01:00 AM\",\n" +
            "    \"gate\" : 44\n" +
            "  }\n" +
            "]";

    public static List<Fligth>getFligthDtoList() throws JsonProcessingException {
        return Converter.getMockList(JSON_FLIGTH_OBJECT);
    }
}
