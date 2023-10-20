package com.example.membre.proxies;


import com.example.membre.beans.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PUBLICATION-SERVICE")
public interface PublicationProxyService {
    @GetMapping("/publications/{id}")
    public PublicationBean recupererUnePublication(@PathVariable(name = "id") Long id);
}
