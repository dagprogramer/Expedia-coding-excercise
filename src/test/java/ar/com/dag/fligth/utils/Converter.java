package ar.com.dag.fligth.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Converter {
    public static <T> List<T> getMockList(String JSON_OBJECT) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(JSON_OBJECT,new TypeReference<List<T>>(){});
    }
}
