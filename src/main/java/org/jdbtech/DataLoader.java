package org.jdbtech;

import org.jdbtech.model.Batch;
import org.jdbtech.repositories.BatchRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DataLoader {

    private Random random;

    public DataLoader() {
        this.random = new Random();
    }

    public void load(BatchRepository batchRepository) {

        for(int i=0;i<100;i++) {
            Batch batch = new Batch(randomBatchNumber(), randomOperator(), LocalDateTime.now(), LocalDate.now(), randomMachine());
            batchRepository.save(batch);
        }
    }

    private String randomBatchNumber() {
        return random.ints(00000000,99999999).findFirst().toString();
    }

    private String randomOperator() {
        return random.ints(000, 999).findFirst().toString();
    }

    private String randomMachine() {
        return random.ints(000, 999).findFirst().toString();
    }
}
