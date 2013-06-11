package com.bia.springclidemo.commands;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

@Component
public class EchoCommands implements CommandMarker {

    @CliAvailabilityIndicator({"cli"})
    public boolean isSimpleAvailable() {
        //always available
        return true;
    }

    @CliCommand(value = "echo", help = "Echos the message with 'You entered: ' prefixed")
    public String simple(
            @CliOption(key = {"message"}, mandatory = true, help = "The hello world message") final String message) {
        return "You entered: " + message;
    }
   
}