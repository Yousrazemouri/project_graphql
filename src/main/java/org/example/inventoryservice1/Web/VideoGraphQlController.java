package org.example.inventoryservice1.Web;

import org.example.inventoryservice1.dao.entities.Creator;
import org.example.inventoryservice1.dao.entities.Video;
import org.example.inventoryservice1.dao.repository.CreatorRepo;
import org.example.inventoryservice1.dao.repository.VideoRepo;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private final CreatorRepo creatorRepository;
    private final VideoRepo videoRepository;

    public VideoGraphQlController(CreatorRepo creatorRepository, VideoRepo videoRepository) {
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }

    @QueryMapping
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", id)));
    }
}
