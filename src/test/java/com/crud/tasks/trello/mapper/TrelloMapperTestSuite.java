package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTestSuite {

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("id", "go", "test", "12");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(trelloCard.getName(),trelloCardDto.getName());
        Assert.assertEquals(trelloCard.getDescription(),trelloCardDto.getDescription());
        Assert.assertEquals(trelloCard.getPos(),trelloCardDto.getPos());
        Assert.assertEquals(trelloCard.getListId(),trelloCardDto.getListId());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCardDto trelloCardDto = new TrelloCardDto("id", "go", "test", "12");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals(trelloCard.getName(),trelloCardDto.getName());
        Assert.assertEquals(trelloCard.getDescription(),trelloCardDto.getDescription());
        Assert.assertEquals(trelloCard.getPos(),trelloCardDto.getPos());
        Assert.assertEquals(trelloCard.getListId(),trelloCardDto.getListId());
    }

    @Test
    public void mapToListTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloListDto trelloListDto = new TrelloListDto("id", "go", true);
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();

        trelloListDtoList.add(trelloListDto);

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDtoList);

        //Then
        Assert.assertEquals(trelloList.get(0).getName(),trelloListDto.getName());
        Assert.assertEquals(trelloList.get(0).getId(),trelloListDto.getId());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList trelloList = new TrelloList("id", "go", true);
        List<TrelloList> trelloListList = new ArrayList<>();

        trelloListList.add(trelloList);

        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloListList);

        //Then
        Assert.assertEquals(trelloListDtoList.get(0).getName(),trelloList.getName());
        Assert.assertEquals(trelloListDtoList.get(0).getId(),trelloList.getId());
    }

    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloListDto trelloListDto = new TrelloListDto("id", "go", true);
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("11", "aa", trelloListDtoList);
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        Assert.assertEquals(trelloBoards.get(0).getName(),trelloBoardDto.getName());
        Assert.assertEquals(trelloBoards.get(0).getId(),trelloBoardDto.getId());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList trelloList = new TrelloList("id", "go", true);
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("11", "aa", trelloListList);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        Assert.assertEquals(trelloBoardsDto.get(0).getName(),trelloBoard.getName());
        Assert.assertEquals(trelloBoardsDto.get(0).getId(),trelloBoard.getId());
    }
}
