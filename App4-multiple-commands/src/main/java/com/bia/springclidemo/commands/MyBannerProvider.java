package com.bia.springclidemo.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

/**
 * Adding this class which extends DefaultBannerProvider will change the Default shell banner displayed.
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyBannerProvider extends DefaultBannerProvider
        implements CommandMarker {

    @CliCommand(value = {"version"}, help = "Displays current CLI version")
    @Override
    public String getBanner() {
        StringBuilder buf = new StringBuilder();
        buf.append("=======================================").append(OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *").append(OsUtils.LINE_SEPARATOR);
        buf.append("*            HelloWorld               *").append(OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *").append(OsUtils.LINE_SEPARATOR);
        buf.append("=======================================").append(OsUtils.LINE_SEPARATOR);
        buf.append("Version:").append(this.getVersion());
        return buf.toString();

    }

    @Override
    public String getVersion() {
        return "1.2.3";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to HelloWorld CLI";
    }

    @Override
    public String name() {
        return "helloworld";
    }
}