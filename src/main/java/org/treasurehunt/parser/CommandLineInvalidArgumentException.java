package org.treasurehunt.parser;

public class CommandLineInvalidArgumentException extends Exception{
    public CommandLineInvalidArgumentException() {
        super("Invalid options");
    }
}
