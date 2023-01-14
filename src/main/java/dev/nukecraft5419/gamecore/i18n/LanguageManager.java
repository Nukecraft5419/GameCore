package dev.nukecraft5419.gamecore.i18n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;

import dev.nukecraft5419.gamecore.GameCore;
import dev.nukecraft5419.gamecore.config.Configuration;
import dev.nukecraft5419.gamecore.utils.FileUtils;

public class LanguageManager {
    private Map<String, Configuration> languages;
    private final String defaultLanguage;
    private final File directory;

    public LanguageManager(final String defaultLanguage, final File directory) {
        this.languages = new HashMap<>();
        this.defaultLanguage = defaultLanguage;
        this.directory = directory;

        LanguageExtractor.extractAll(directory);
    }

    public LanguageManager(final GameCore plugin) {
        this(
                plugin.getConfig().getString("settings.default-lang"),
                new File(plugin.getDataFolder(), "lang"));
    }

    public void loadLanguage(final File file) throws IOException, InvalidConfigurationException {
        final Configuration lang = new Configuration(file);
        lang.load();

        final String name = FileUtils.getBaseName(file).toLowerCase();
        this.languages.put(name, lang);
    }

    public Configuration getLanguage(String name) {
        name = name.toLowerCase();

        if (languages.containsKey(name)) {
            return languages.get(name);
        } else if (languages.containsKey(name)) {
            return languages.get(name);
        } else if (languages.containsKey(name.split("[_]")[0])) {
            return languages.get(name.split("[_]")[0]);
        } else {
            return languages.get(this.getDefaultLocale());
        }
    }

    public void loadLanguages() throws IOException, InvalidConfigurationException {
        if (!directory.exists()) {
            directory.mkdirs();
        }

        for (final File file : directory.listFiles()) {
            if (file.getName().endsWith(".yml")) {
                try {
                    this.loadLanguage(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadLanguagesSafe() {
        try {
            this.loadLanguages();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public String getDefaultLocale() {
        return this.defaultLanguage;
    }
}