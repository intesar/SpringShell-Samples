package com.bia.springclidemo.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

/**
 * 
 * Adding this bean which extends DefaultPromptProvider will customize the prompt to "cli $ "
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyPromptProvider extends DefaultPromptProvider {

    @Override
    public String getPrompt() {
        return "cli $ ";
    }

    @Override
    public String name() {
        return "my prompt provider";
    }
}
