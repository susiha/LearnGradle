package com.susiha.utils;


import com.susiha.repository.InMemoryToDoRepository;

import java.util.Scanner;

public class CommandLineInputHandler {

    public void printOptions(){

        System.out.println("--- To Do Application ---");
        System.out.println("please make a choice:");
        for(CommandLineInput commandLineInput:CommandLineInput.values()){
            System.out.println("("+commandLineInput.getShortCmd()+")"+commandLineInput.getLastDesc());
        }
        System.out.print(">");


    }
    public String readInput(){

        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        return s;
    }

    public CommandLineInput mapInput(char input){
        return CommandLineInput.getCommandLineInputForInput(input);
    }


    public void processInput(CommandLineInput mappedInput){
        InMemoryToDoRepository inMemoryToDoRepository = new InMemoryToDoRepository();

        System.out.println(mappedInput.getValue());

    }



}
