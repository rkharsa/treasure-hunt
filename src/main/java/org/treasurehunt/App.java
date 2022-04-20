package org.treasurehunt;

import org.treasurehunt.parser.CommandFactory;
import org.treasurehunt.parser.CommandLineCode;
import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.universe.Universe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws CommandLineInvalidArgumentException {
        try {
            CommandFactory commandFactory = new CommandFactory();
            Universe universe = new Universe();
            Scanner scanner = new Scanner(new File("/Users/ranikharsa/Desktop/treasure hunt/treasure-hunt/src/main/java/org/treasurehunt/command.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] command = line.split("-");
                if (command.length > 0) {
                    String commandLineCodeStr = command[0];
                    CommandLineCode commandLineCode = CommandLineCode.valueOf(commandLineCodeStr);
                    commandFactory.getCommand(commandLineCode).execute(line, universe);
                }
            }
            scanner.close();
            universe.display();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CommandLineInvalidArgumentException e) {
            throw new CommandLineInvalidArgumentException();
        }

    }
}
