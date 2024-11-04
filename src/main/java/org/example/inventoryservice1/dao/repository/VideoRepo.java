package org.example.inventoryservice1.dao.repository;

import org.example.inventoryservice1.dao.entities.Creator;
import org.example.inventoryservice1.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video,Long> {

}
