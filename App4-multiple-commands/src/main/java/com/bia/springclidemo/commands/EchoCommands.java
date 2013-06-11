package com.bia.springclidemo.commands;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

@Component
public class EchoCommands implements CommandMarker {

    @CliAvailabilityIndicator({"echo", "hi"})
    public boolean isSimpleAvailable() {
        //always available
        return true;
    }

    @CliCommand(value = "echo", help = "Echos the message with 'You entered: ' prefixed")
    public String simple(
            @CliOption(key = {"message"}, mandatory = true, help = "The hello world message") final String message) {
        return "You entered: " + message;
    }

    /**
     * second command
     * @return 
     */
    @CliCommand(value = "hi", help = "just returns hi with current date")
    public String hi() {
        DateFormat df = new SimpleDateFormat("yyy, dd, MMM");
        return "hi: " + df.format(Calendar.getInstance());
    }
}