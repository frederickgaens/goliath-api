package be.codesolutions.goliathapi.config;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.codesolutions.goliathapi.config.model.GpioConfig;

@Repository
public interface GpioConfigRepository extends CrudRepository<GpioConfig, Long> {
    
}
