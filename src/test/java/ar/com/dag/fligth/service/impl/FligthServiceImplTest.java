package ar.com.dag.fligth.service.impl;

import ar.com.dag.fligth.dto.FligthDto;
import ar.com.dag.fligth.entities.Fligth;
import ar.com.dag.fligth.manager.Manager;
import ar.com.dag.fligth.service.FligthServiceImpl;
import ar.com.dag.fligth.utils.Converter;
import ar.com.dag.fligth.utils.FligthDtoMock;
import ar.com.dag.fligth.utils.FligthMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

class FligthServiceImplTest {

    @Mock
    private Manager manager;

    private ObjectMapper objectMapper;

    @InjectMocks
    private FligthServiceImpl fligthService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getFligthDtoWithoutParameter() throws JsonProcessingException {
        String endpoint="http://demo0656547.mockable.io/flights";
        List<Fligth> fligthList = FligthMock.getFligthDtoList();
        String departuredate=null;
        String airlinecode=null;
        doReturn(fligthList).when(manager).getRequestFromUrl(endpoint);
        verify(manager,atMostOnce()).getRequestFromUrl(endpoint);
        assertThat(fligthService.getFligthDto(departuredate,airlinecode).get(0)).isInstanceOf(FligthDto.class);
    }

    @Test
    void getFligthDtoWhitDeparturedateParam() throws JsonProcessingException {
        String endpoint="http://demo0656547.mockable.io/flights";
        List<Fligth> fligthList = FligthMock.getFligthDtoList();
        String departuredate="12/18/2021 11:00 AM";
        String airlinecode=null;
        doReturn(fligthList).when(manager).getRequestFromUrl(endpoint);
        verify(manager,atMostOnce()).getRequestFromUrl(endpoint);
        assertThat(fligthService.getFligthDto(departuredate,airlinecode).get(0)).isInstanceOf(FligthDto.class);
    }
}