package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    //Pole username
    @Value("${trello.app.username}")
    private String trelloUsername;

    @Autowired
    private RestTemplate restTemplate;

    //Oddzielna metoda do budowania adresu
    private URI urlBuild() {
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id").build().encode().toUri();
        return url;
    }

    //Wykorzystanie klasy Optional
    public Optional<List<TrelloBoardDto>> getTrelloBoards() {

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(urlBuild(),TrelloBoardDto[].class);

        List<TrelloBoardDto> boardsResponseList = Arrays.asList(boardsResponse);

        Optional<List<TrelloBoardDto>> boardsResponses = Optional.ofNullable(boardsResponseList);

        return boardsResponses;
    }
}