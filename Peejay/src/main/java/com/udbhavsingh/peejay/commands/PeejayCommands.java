package com.udbhavsingh.peejay.commands;

import com.udbhavsingh.peejay.client.PeejayClient;
import com.udbhavsingh.peejay.model.PeejayJokeResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class PeejayCommands {

    private final PeejayClient peejayClient;

    public PeejayCommands(PeejayClient peejayClient) {
        this.peejayClient = peejayClient;
    }

    @ShellMethod(key = "random", value = "I will return a random joke")
    public String getRandomPeejayJoke() {
        PeejayJokeResponse random = peejayClient.random();
        return random.joke();
    }

    @ShellMethod(
            key = "hello",
            value = "I will say hello"
    )
    public String hello(@ShellOption(defaultValue = "World") String arg) {
        return "Hello " + arg;
    }

    @ShellMethod(
            key = "goodbye",
            value = "I will say goodbye"
    )
    public String goodbye() {
        return "Goodbye";
    }

}

