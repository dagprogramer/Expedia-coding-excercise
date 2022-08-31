package ar.com.dag.fligth.utils;

import ar.com.dag.fligth.dto.FligthDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class FligthDtoMock {

    private static final String JSON_FLIGTH_DTO_OBJECT="[\n" +
            "    {\n" +
            "        \"from\": \"NYC\",\n" +
            "        \"to\": \"LAX\",\n" +
            "        \"airline\": \"United Airlines\",\n" +
            "        \"flight_number\": \"115\",\n" +
            "        \"departure_datetime\": \"12/18/2021 11:00 AM\",\n" +
            "        \"gate\": \"12\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"from\": \"BUE\",\n" +
            "        \"to\": \"LAX\",\n" +
            "        \"airline\": \"Aerolineas Argentinas\",\n" +
            "        \"flight_number\": \"99\",\n" +
            "        \"departure_datetime\": \"12/18/2021 11:00 PM\",\n" +
            "        \"gate\": \"22\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"from\": \"ORD\",\n" +
            "        \"to\": \"SEA\",\n" +
            "        \"airline\": \"American Airlines\",\n" +
            "        \"flight_number\": \"776\",\n" +
            "        \"departure_datetime\": \"12/25/2021 11:00 AM\",\n" +
            "        \"gate\": \"12\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"from\": \"MAD\",\n" +
            "        \"to\": \"LON\",\n" +
            "        \"airline\": \"Delta Airlines\",\n" +
            "        \"flight_number\": \"456\",\n" +
            "        \"departure_datetime\": \"12/26/2021 11:00 AM\",\n" +
            "        \"gate\": \"44\"\n" +
            "    }\n" +
            "]";

    public static List<FligthDto>getFligthDtoMockList() throws JsonProcessingException {
        List<FligthDto>list=Converter.getMockList(JSON_FLIGTH_DTO_OBJECT);
        return list;
    }
}
