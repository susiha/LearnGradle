package com.susiha.utils;

public enum CommandLineInput {
    ALL("all items"),
    FIND("find a specific item"),
    INSERT("insert a new item"),
    UPDATE("update an exiting item"),
    DELETE("delete an exiting item"),
    EXIT("exit");

    CommandLineInput(String value) {
        mValue = value;
    }

    private final String mValue;
    public char getShortCmd() {
        return mValue.toCharArray()[0];
    }

    public String getValue(){
        return mValue;
    }

    public String getLastDesc() {
        return mValue.substring(1);
    }

    public static CommandLineInput getCommandLineInputForInput(char command) {
        switch (command) {
            case 'a':
                return ALL;
            case 'e':
                return EXIT;
            case 'f':
                return FIND;
            case 'i':
                return INSERT;
            case 'u':
                return UPDATE;
            case 'd':
                return DELETE;
            default:
                return EXIT;
        }
    }
}
