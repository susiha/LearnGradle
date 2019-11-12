package com.susiha.repository;

import com.susiha.demo.ToDoItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;

public class InMemoryToDoRespositoryTest {
    private ToDoRepository inmemoryToDoRespository;

    @Before //
    public void setUp(){
        inmemoryToDoRespository = new InMemoryToDoRepository();
    }

    @Test
    public void insertToDoItem(){


        int items = System.getProperty("items")!=null?Integer.parseInt(System.getProperty("items")):1;
        createAndInsertToDoItems(items);
        List<ToDoItem> toDoItems = inmemoryToDoRespository.findAll();
        assertEquals(items,toDoItems.size());
    }
    private void createAndInsertToDoItems(int items){
        System.out.println("Creating "+items+" To Do Items");
        for(int i=1;i<= items;i++){
            ToDoItem toDoItem = new ToDoItem();
            toDoItem.setName("To Do Task "+i);
            inmemoryToDoRespository.insert(toDoItem);
        }

    }

}
