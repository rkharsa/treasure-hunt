package org.treasurehunt.parser.exceptions;

public class CommandLineInvalidArgumentException extends Exception{
    public CommandLineInvalidArgumentException() {
        super("Invalid options");
    }
}
