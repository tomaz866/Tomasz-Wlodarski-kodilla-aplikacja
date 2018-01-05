package com.crud.tasks.task.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskMapperTestSuite {

    @Test
    public void  mapToTaskTest() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        TaskDto taskDto = new TaskDto(1L,"title","content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Given
        Assert.assertEquals(taskDto.getId(),task.getId());
        Assert.assertEquals(taskDto.getTitle(),task.getTitle());
        Assert.assertEquals(taskDto.getContent(),task.getContent());
    }

    @Test
    public void  mapToTaskDtoTest() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L,"title","content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Given
        Assert.assertEquals(taskDto.getId(),task.getId());
        Assert.assertEquals(taskDto.getTitle(),task.getTitle());
        Assert.assertEquals(taskDto.getContent(),task.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        List<Task> tasks = new ArrayList<>();
        Task task = new Task(1L,"title","content");
        Task task1 = new Task(2L, "title2", "content2");
        tasks.add(task);
        tasks.add(task1);

        //When
        List<TaskDto> tasksDto = taskMapper.mapToTaskDtoList(tasks);

        //Given
        Assert.assertEquals(2,tasksDto.size());
        Assert.assertEquals(tasks.get(0).getId(),tasksDto.get(0).getId());
        Assert.assertEquals(tasks.get(0).getTitle(),tasksDto.get(0).getTitle());
        Assert.assertEquals(tasks.get(0).getContent(),tasksDto.get(0).getContent());
        Assert.assertEquals(tasks.get(1).getId(),tasksDto.get(1).getId());
        Assert.assertEquals(tasks.get(1).getTitle(),tasksDto.get(1).getTitle());
        Assert.assertEquals(tasks.get(1).getContent(),tasksDto.get(1).getContent());
    }
}
