package org.treasurehunt.parser;

import org.junit.Test;
import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {
    @Test
    public void whenGetCommandHasCommandLineCodeT_thenReturnCommandTreasure() throws CommandLineInvalidArgumentException {
        CommandFactory commandFactory = new CommandFactory();
        CommandLineCode commandLineCode = CommandLineCode.T;

        Class<CommandTreasure> expected = CommandTreasure.class;
        assertEquals(commandFactory.getCommand(commandLineCode).getCommandHandlerStrategy().getClass(), expected);

    }

    @Test
    public void whenGetCommandHasCommandLineCodeM_thenReturnCommandMountain() throws CommandLineInvalidArgumentException {
        CommandFactory commandFactory = new CommandFactory();
        CommandLineCode commandLineCode = CommandLineCode.M;

        Class<CommandMountain> expected = CommandMountain.class;
        assertEquals(commandFactory.getCommand(commandLineCode).getCommandHandlerStrategy().getClass(), expected);

    }

    @Test
    public void whenGetCommandHasCommandLineCodeC_thenReturnCommandMap() throws CommandLineInvalidArgumentException {
        CommandFactory commandFactory = new CommandFactory();
        CommandLineCode commandLineCode = CommandLineCode.C;

        Class<CommandMap> expected = CommandMap.class;
        assertEquals(commandFactory.getCommand(commandLineCode).getCommandHandlerStrategy().getClass(), expected);

    }

    @Test
    public void whenGetCommandHasCommandLineCodeA_thenReturnCommandPlayer() throws CommandLineInvalidArgumentException {
        CommandFactory commandFactory = new CommandFactory();
        CommandLineCode commandLineCode = CommandLineCode.A;

        Class<CommandPlayer> expected = CommandPlayer.class;
        assertEquals(commandFactory.getCommand(commandLineCode).getCommandHandlerStrategy().getClass(), expected);

    }

}