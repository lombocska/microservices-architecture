package io.lombocska.edgeservice.client;

import io.lombocska.edgeservice.dto.CatDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;

//feign client name must be the exact name of the spring-boot-app name for the routing
@FeignClient("cat-catalog-service")
public interface CatClient {

    @GetMapping("/cats")
    CollectionModel<CatDTO> getCats();
}
