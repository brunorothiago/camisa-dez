package com.example.CamisaDez.config;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        String springUrl = env("SPRING_DATASOURCE_URL");
        if (!springUrl.isBlank()) {
            dataSource.setUrl(springUrl);
            dataSource.setUsername(env("SPRING_DATASOURCE_USERNAME", env("DB_USERNAME", "postgres")));
            dataSource.setPassword(env("SPRING_DATASOURCE_PASSWORD", env("DB_PASSWORD", "")));
            return dataSource;
        }

        String renderDatabaseUrl = env("DATABASE_URL");
        if (!renderDatabaseUrl.isBlank()) {
            configureFromRenderDatabaseUrl(dataSource, renderDatabaseUrl);
            return dataSource;
        }

        dataSource.setUrl(env("DB_URL", "jdbc:postgresql://localhost:5432/cadastrodb"));
        dataSource.setUsername(env("DB_USERNAME", "postgres"));
        dataSource.setPassword(env("DB_PASSWORD", ""));
        return dataSource;
    }

    private void configureFromRenderDatabaseUrl(DriverManagerDataSource dataSource, String databaseUrl) {
        try {
            URI uri = URI.create(databaseUrl);

            String userInfo = uri.getUserInfo();
            String username = "";
            String password = "";

            if (userInfo != null) {
                String[] parts = userInfo.split(":", 2);
                username = decode(parts[0]);
                if (parts.length > 1) {
                    password = decode(parts[1]);
                }
            }

            String databaseName = uri.getPath();
            if (databaseName != null && databaseName.startsWith("/")) {
                databaseName = databaseName.substring(1);
            }

            int port = uri.getPort() == -1 ? 5432 : uri.getPort();
            String jdbcUrl = "jdbc:postgresql://" + uri.getHost() + ":" + port + "/" + databaseName;
            if (uri.getQuery() != null && !uri.getQuery().isBlank()) {
                jdbcUrl += "?" + uri.getQuery();
            }

            dataSource.setUrl(jdbcUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
        } catch (Exception e) {
            throw new IllegalArgumentException("DATABASE_URL inválida. Use a URL interna do PostgreSQL do Render.", e);
        }
    }

    private String env(String key) {
        return env(key, "");
    }

    private String env(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? defaultValue : value;
    }

    private String decode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }
}
