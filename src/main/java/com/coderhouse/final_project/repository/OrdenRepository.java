package com.coderhouse.final_project.repository;

import com.coderhouse.final_project.model.documents.Orden;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdenRepository  extends MongoRepository<Orden, String > {
}
