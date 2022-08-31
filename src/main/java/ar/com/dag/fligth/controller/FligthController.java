package ar.com.dag.fligth.controller;

import ar.com.dag.fligth.dto.FligthDto;
import ar.com.dag.fligth.service.FligthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FligthController {

    @Autowired
    private FligthService fligthService;

    @ResponseBody
    @GetMapping()
    public List<FligthDto> getFligthDto(@RequestParam(name = "departuredate",required = false) String departuredate,
                                        @RequestParam(name = "airlinecode",required = false) String airlinecode){
      return fligthService.getFligthDto(departuredate,airlinecode);
    }
}
