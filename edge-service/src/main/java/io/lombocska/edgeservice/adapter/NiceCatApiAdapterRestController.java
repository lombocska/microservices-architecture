package io.lombocska.edgeservice.adapter;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.lombocska.edgeservice.client.CatClient;
import io.lombocska.edgeservice.dto.CatDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
public class NiceCatApiAdapterRestController {

    private CatClient catClient;

    public NiceCatApiAdapterRestController(final CatClient catClient) {
        this.catClient = catClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/nice-cats")
    public Collection<CatDTO> niceCats() {
        final Predicate<? super CatDTO> isNice = catDto -> catDto.getName().startsWith("K");
        return catClient.getCats()
                .getContent()
                .stream()
                .filter(isNice)
                .collect(Collectors.toList());
    }

    public Collection<CatDTO> fallback() {
        return Collections.emptyList();
    }

}
