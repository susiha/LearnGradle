package com.susiha.repository;

import com.susiha.demo.ToDoItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 集成测试
 */
public class InMemoryToDoRespositoryIntegTest {

    private InMemoryToDoRepository inmemoryToDoRespository;



    @Before
    public void setUp(){
        inmemoryToDoRespository = new InMemoryToDoRepository();
    }


    @Test
    public void insertToDoItem(){
        ToDoItem newToDoItem = new ToDoItem();
        newToDoItem.setName("Write unit tests");
        Long newId = inmemoryToDoRespository.insert(newToDoItem);
        assertNotNull(newId);

        ToDoItem persistedToDoItem  = inmemoryToDoRespository.findById(newId);
        assertNotNull(persistedToDoItem);
        assertEquals(newToDoItem,persistedToDoItem);


    }
}
