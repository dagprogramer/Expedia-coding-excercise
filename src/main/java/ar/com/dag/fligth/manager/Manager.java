package ar.com.dag.fligth.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Component
public class Manager {
    @Autowired
    private WebClient.Builder client;

    public <T> List<T>getRequestWithQueryParamsList(String endpoint, MultiValueMap<String,String>multiValueMap){
       return WebClient.builder().build()
               .get()
               .uri(uriBuilder -> uriBuilder.path(endpoint)
                       .queryParams(multiValueMap).build())
               .retrieve()
               .bodyToMono(new ParameterizedTypeReference<List<T>>() {
               }).block();
    }

    public <T> List<T> getRequestFromUrl(String endpoint){
      return this.client.build()
              .get()
              .uri(endpoint)
              .retrieve()
              .bodyToMono(new ParameterizedTypeReference<List<T>>(){})
              .block();
    }
}
