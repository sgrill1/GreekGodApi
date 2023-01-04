package org.example.model.repositories;

import org.example.model.pojos.Bios;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreekGodRepository extends MongoRepository<Bios,String> {
}
