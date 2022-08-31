package ar.com.dag.fligth.service;

import ar.com.dag.fligth.dto.FligthDto;

import java.util.List;

public interface FligthService {
    public List<FligthDto> getFligthDto(String departuredate,String airlinecode);
}
