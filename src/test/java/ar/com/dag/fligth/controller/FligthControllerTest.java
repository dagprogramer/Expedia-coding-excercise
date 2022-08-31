package ar.com.dag.fligth.controller;

import ar.com.dag.fligth.dto.FligthDto;
import ar.com.dag.fligth.service.FligthService;
import ar.com.dag.fligth.utils.FligthDtoMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = FligthController.class)
@WebMvcTest(FligthController.class)
class FligthControllerTest {

    private final ObjectMapper objectMapper=new ObjectMapper();
    private MockMvc mockMvc;
    private final String BASE_PATH="/flights";

    @MockBean
    private FligthService fligthService;

    @InjectMocks
    private FligthController fligthController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(fligthController)
                .setControllerAdvice(Exception.class)
                .build();
    }

    @Test
    void getFligthDtoWithoutParameter() throws Exception {
        List<FligthDto> fligthDtoList = FligthDtoMock.getFligthDtoMockList();
        when(fligthService.getFligthDto(null,null)).thenReturn(fligthDtoList);
        MockHttpServletResponse response = mockMvc.perform(get(BASE_PATH).contentType(MediaType.APPLICATION_JSON)
                        .param("departuredate", (String) null)
                        .param("airlinecode", (String) null))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertEquals(objectMapper.writeValueAsString(fligthDtoList),response.getContentAsString());
    }

    @Test
    void getFligthDtoWhitDeparturedateParam() throws Exception {
        List<FligthDto> fligthDtoList = FligthDtoMock.getFligthDtoMockList();
        List<FligthDto>fligthDtoListWithFilterByDeparturedate=new ArrayList<>();
        fligthDtoListWithFilterByDeparturedate.add(fligthDtoList.get(0));
        String param="12/18/2021 11:00 AM";
        when(fligthService.getFligthDto(param,null)).thenReturn(fligthDtoListWithFilterByDeparturedate);
        MockHttpServletResponse response = mockMvc.perform(get(BASE_PATH).contentType(MediaType.APPLICATION_JSON)
                        .param("departuredate", param)
                        .param("airlinecode", (String) null))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertEquals(objectMapper.writeValueAsString(fligthDtoListWithFilterByDeparturedate),response.getContentAsString());
    }

    @Test
    void getFligthDtoWhitAirlinecodeParam() throws Exception {
        List<FligthDto> fligthDtoList = FligthDtoMock.getFligthDtoMockList();
        List<FligthDto>fligthDtoListWithFilterByAirlinecode=new ArrayList<>();
        fligthDtoListWithFilterByAirlinecode.add(fligthDtoList.get(1));
        String param="AR";
        when(fligthService.getFligthDto(null,param)).thenReturn(fligthDtoListWithFilterByAirlinecode);
        MockHttpServletResponse response = mockMvc.perform(get(BASE_PATH).contentType(MediaType.APPLICATION_JSON)
                        .param("departuredate", (String) null)
                        .param("airlinecode", param))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertEquals(objectMapper.writeValueAsString(fligthDtoListWithFilterByAirlinecode),response.getContentAsString());
    }

    @Test
    void getFligthDtoWhitBothParam() throws Exception {
        List<FligthDto> fligthDtoList = FligthDtoMock.getFligthDtoMockList();
        List<FligthDto>fligthDtoListWithFilterBothParameter=new ArrayList<>();
        fligthDtoListWithFilterBothParameter.add(fligthDtoList.get(1));
        String param_airlinecode="AR";
        String param_departuredate="12/18/2021 11:00 PM";
        when(fligthService.getFligthDto(param_departuredate,param_airlinecode)).thenReturn(fligthDtoListWithFilterBothParameter);
        MockHttpServletResponse response = mockMvc.perform(get(BASE_PATH).contentType(MediaType.APPLICATION_JSON)
                        .param("departuredate", param_departuredate)
                        .param("airlinecode", param_airlinecode))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertEquals(objectMapper.writeValueAsString(fligthDtoListWithFilterBothParameter),response.getContentAsString());
    }
}