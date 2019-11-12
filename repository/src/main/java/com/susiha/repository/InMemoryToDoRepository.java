package com.susiha.repository;


import com.susiha.demo.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryToDoRepository implements ToDoRepository {

    private AtomicLong currentId = new AtomicLong();
    private ConcurrentMap<Long, ToDoItem> todos
            = new ConcurrentHashMap<Long, ToDoItem>() ;

    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> toDoItems = new ArrayList<ToDoItem>(todos.values());
        Collections.sort(toDoItems);
        return toDoItems;
    }

    @Override
    public ToDoItem findById(Long id) {
        return todos.get(id);
    }

    @Override
    public Long insert(ToDoItem toDoItem) {
        Long id = currentId.incrementAndGet();
        toDoItem.setId(id);
        todos.putIfAbsent(id,toDoItem);
        return id;
    }

    @Override
    public void update(ToDoItem toDoItem) {

        todos.replace(toDoItem.getId(),toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        todos.remove(toDoItem.getId());
    }
}
