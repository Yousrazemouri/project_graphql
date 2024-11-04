package org.example.inventoryservice1.dao.repository;

import org.example.inventoryservice1.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepo extends JpaRepository<Creator,Long> {

}
