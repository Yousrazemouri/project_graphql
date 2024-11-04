package org.example.inventoryservice1;

import org.example.inventoryservice1.dao.entities.Creator;
import org.example.inventoryservice1.dao.entities.Video;
import org.example.inventoryservice1.dao.repository.CreatorRepo;
import org.example.inventoryservice1.dao.repository.VideoRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
@SpringBootApplication(scanBasePackages = "org.example.inventoryservice1.dao.entities")
@EnableJpaRepositories(basePackages = "org.example.inventoryservice1.dao.repository")
public class InventoryService1Application {

    public static void main(String[] args) {
        SpringApplication.run(InventoryService1Application.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepo creatorRepository, VideoRepo videoRepository) {
        return args -> {
            List<Creator> creators = List.of(
                    Creator.builder().name("John Doe").email("john@example.com").build(),
                    Creator.builder().name("Jane Smith").email("jane@example.com").build()
            );
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(
                    Video.builder().name("Intro to GraphQL").url("http://example.com/video1")
                            .description("Learn GraphQL basics").date("2023-01-01")
                            .creator(creators.get(0)).build(),
                    Video.builder().name("Advanced GraphQL").url("http://example.com/video2")
                            .description("Deep dive into GraphQL").date("2023-02-01")
                            .creator(creators.get(1)).build()
            );
            videoRepository.saveAll(videos);
        };
    }
}
