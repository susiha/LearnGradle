package com.susiha;

import com.susiha.utils.CommandLineInput;
import com.susiha.utils.CommandLineInputHandler;

public class ToDoApp {

    public static final char DEFAULT_INPUT = 'e';



    public static void main(String args[]){

        CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler();
        commandLineInputHandler.printOptions();

        String firstInput = commandLineInputHandler.readInput();
        char[] firstInputChars = firstInput.length() ==1?firstInput.toCharArray():new char[]{DEFAULT_INPUT};
        char command = firstInputChars[0];
        while(CommandLineInput.EXIT.getShortCmd()!=command){
            String input = commandLineInputHandler.readInput();
            char[] inputChars = input.length() ==1?input.toCharArray():new char[]{DEFAULT_INPUT};
            command = inputChars[0];
            CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);
            commandLineInputHandler.processInput(commandLineInput);
        }



    }

}
