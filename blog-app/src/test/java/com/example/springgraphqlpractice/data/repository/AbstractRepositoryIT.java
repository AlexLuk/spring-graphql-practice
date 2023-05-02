package com.example.springgraphqlpractice.data.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AbstractRepositoryIT.DBTestConfig.class)
public class AbstractRepositoryIT {

  @DynamicPropertySource
  public static void configureH2Database(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url",
        () -> "jdbc:h2:mem:tests?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
    registry.add("spring.datasource.username", () -> "sa");
    registry.add("spring.datasource.password", () -> "password");
  }

  @TestConfiguration
  @EnableAutoConfiguration
  @EnableJpaRepositories(basePackages = "com.example.springgraphqlpractice.data.repository")
  public static class DBTestConfig {

  }
}

