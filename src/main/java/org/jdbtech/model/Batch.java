package org.jdbtech.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Indexed;
import org.springframework.data.gemfire.mapping.annotation.PartitionRegion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@PartitionRegion(value="Batches")
public class Batch implements Serializable {

    @Id
    @Getter
    private final String id;

    @Indexed
    @Getter
    private final String referenceNumber;

    @Getter
    private final String operator;

    @Getter
    private final LocalDateTime scanTime;

    @Getter
    private final LocalDate processDate;

    @Getter
    private final String machineId;

    @PersistenceConstructor
    public Batch(String referenceNumber, String operator, LocalDateTime scanTime, LocalDate processDate, String machineId) {
        this.id = UUID.randomUUID().toString();
        this.referenceNumber = referenceNumber;
        this.operator = operator;
        this.scanTime = scanTime;
        this.processDate = processDate;
        this.machineId = machineId;
    }
}
