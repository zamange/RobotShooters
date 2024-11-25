package BriTests;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.Server.Commands.Command;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void invalidCommandShouldBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testInvalid = Command.create("jump", args);
        assertNull(testInvalid);
    }


    @Test
    void createLaunchCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("launch", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Launch", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createStateCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("state", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("State", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createLookCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("look", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Look", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createForwardCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("forward", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Forward", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createBackCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("back", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Back", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createLeftCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("left", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Left", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createRightCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("right", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Right", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createRepairCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("repair", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Repair", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createReloadCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("reload", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Reload", args);
        assertNotNull(testUppercase);
    }

    @Test
    void createFireCommandShouldNotBeNull() {
        List<String> args = new ArrayList<>(List.of("10"));
        Command testLowercase = Command.create("fire", args);
        assertNotNull(testLowercase);
        Command testUppercase = Command.create("Fire", args);
        assertNotNull(testUppercase);
    }
}