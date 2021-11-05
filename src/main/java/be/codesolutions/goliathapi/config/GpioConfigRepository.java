package be.codesolutions.goliathapi.config;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpioConfigRepository extends CrudRepository<GpioConfig, Long> {
    
}
