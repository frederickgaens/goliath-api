package be.codesolutions.goliathapi.location;

import be.codesolutions.goliathapi.location.model.GpioLocation;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpioLocationRepository extends CrudRepository<GpioLocation, Long> {

  Optional<GpioLocation> findOptionalByName(String name);

}
