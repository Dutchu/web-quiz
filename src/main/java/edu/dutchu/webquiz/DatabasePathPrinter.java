package edu.dutchu.webquiz;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DatabasePathPrinter {

    private final Environment env;

    public DatabasePathPrinter(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void printDatabasePath() {
        String url = env.getProperty("spring.datasource.url");
        String relativePath = url.replace("jdbc:h2:file:", "");
        Path absolutePath = Paths.get(relativePath).toAbsolutePath().normalize();
        System.out.println("Database path: " + absolutePath);
    }
}