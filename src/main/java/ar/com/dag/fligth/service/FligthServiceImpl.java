package ar.com.dag.fligth.service;

import ar.com.dag.fligth.dto.FligthDto;
import ar.com.dag.fligth.entities.Fligth;
import ar.com.dag.fligth.manager.Manager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class FligthServiceImpl implements FligthService{

    @Autowired
    private Manager manager;
    private String endpoint;

    public FligthServiceImpl() {
        this.endpoint = "http://demo0656547.mockable.io/flights";
    }


    @Override
    public List<FligthDto> getFligthDto(String departuredate,String airlinecode) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Fligth>fligthList=objectMapper.convertValue(manager.getRequestFromUrl(endpoint), new TypeReference<List<Fligth>>() {
        });
        return this.getFligthDtoFromClient(fligthList,departuredate,airlinecode);
    }

    private List<FligthDto> getFligthDtoFromClient(List<Fligth> fligthList,String departuredate,String airlinecode) {
        List<FligthDto>fligthDtos = null;
        Predicate<Fligth>isAirlinecode=fligth -> airlinecode.equalsIgnoreCase(fligth.getAirlineCode());
        Predicate<Fligth>isDeparturedate=fligth -> departuredate.equalsIgnoreCase(fligth.getDepartureDate());
        Predicate<Fligth>isBothParameter=fligth -> departuredate.equalsIgnoreCase(fligth.getDepartureDate())
                                                   && airlinecode.equalsIgnoreCase(fligth.getAirlineCode());
        if(departuredate == null && airlinecode == null){
            fligthDtos=this.getFligthDtoListWithoutFilter(fligthList);
        } else if(departuredate == null && airlinecode.length()>0) {
            fligthDtos=this.getFligthDtoListWithFilter(fligthList,isAirlinecode);
        } else if (airlinecode == null && departuredate.length()>0) {
            fligthDtos=this.getFligthDtoListWithFilter(fligthList,isDeparturedate);
        } else if (departuredate.length()>0 && airlinecode.length()>0){
            fligthDtos=this.getFligthDtoListWithFilter(fligthList,isBothParameter);
        }
        return fligthDtos;
    }

    private List<FligthDto> getFligthDtoListWithFilter(List<Fligth> fligthList, Predicate<Fligth>predicate){
        return fligthList.stream()
                .filter(predicate)
                .map(this::mappingFligthDto)
                .collect(Collectors.toList());
    }

    private List<FligthDto> getFligthDtoListWithoutFilter(List<Fligth> fligthList){
        return fligthList.stream()
                .map(this::mappingFligthDto)
                .collect(Collectors.toList());
    }

    public FligthDto mappingFligthDto(Fligth fligth) {
        FligthDto fligthDto = new FligthDto();
        fligthDto.setFrom(fligth.getDepartureCityCode());
        fligthDto.setTo(fligth.getArrivalCityCode());
        fligthDto.setAirline(fligth.getAirlineName());
        fligthDto.setFlight_number(fligth.getFlightNumber());
        fligthDto.setDeparture_datetime(fligth.getDepartureDate());
        fligthDto.setGate(String.valueOf(fligth.getGate()));
        return fligthDto;
    }
}
