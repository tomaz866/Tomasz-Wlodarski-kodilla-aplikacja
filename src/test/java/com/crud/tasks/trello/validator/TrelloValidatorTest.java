package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloValidatorTest {

    @Test
    public void validateTrelloBoardsTest() {
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();
        List<TrelloList> list = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("11","test", list);
        TrelloBoard trelloBoard1 = new TrelloBoard("12", "nowa", list);
        List<TrelloBoard> lists = new ArrayList<>();
        lists.add(trelloBoard);
        lists.add(trelloBoard1);

        //When
        List<TrelloBoard> newList = trelloValidator.validateTrelloBoards(lists);

        //Then
        Assert.assertEquals(1,newList.size());
    }
}
