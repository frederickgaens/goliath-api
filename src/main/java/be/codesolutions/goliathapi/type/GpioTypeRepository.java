package be.codesolutions.goliathapi.type;

import be.codesolutions.goliathapi.type.model.GpioType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpioTypeRepository extends CrudRepository<GpioType, Long> {

}
