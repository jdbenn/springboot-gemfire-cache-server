package org.jdbtech;

import org.jdbtech.model.Batch;
import org.jdbtech.repositories.BatchRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import java.io.IOException;

@SpringBootApplication
@CacheServerApplication
@EnableEntityDefinedRegions(basePackageClasses = Batch.class)
@EnableGemfireRepositories
public class GemfireServer {

    public static void main(String[] args) throws IOException{
        SpringApplication.run(GemfireServer.class, args);
    }

    @Bean
    ApplicationRunner run(DataLoader loader, BatchRepository batchRepository) {
        return args -> loader.load(batchRepository);
    }

}
