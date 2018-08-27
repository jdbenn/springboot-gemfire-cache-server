package org.jdbtech.repositories;

import org.jdbtech.model.Batch;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BatchRepository extends CrudRepository<Batch, String> {

    @Trace
    List<Batch> findByReferenceNumber(String referenceNumber);
}
