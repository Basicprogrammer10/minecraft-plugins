package com.connorcode.mastodonlink;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public final int verifyCodeLength;
    public final String requireHost;
    public final Bot bot;

    Config(FileConfiguration config) {
        verifyCodeLength = config.getInt("verifyCodeLength", 6);
        requireHost = config.getString("requireHost", null);
        bot = new Bot(config);
    }

    public record Bot(int refresh, String address, String clientId, String clientSecret, String auth) {
        Bot(FileConfiguration config) {
            this(config.getInt("bot.refresh"), config.getString("bot.address"), config.getString("bot.id"),
                    config.getString("bot.secret"), config.getString("bot.auth"));
        }
    }
}
