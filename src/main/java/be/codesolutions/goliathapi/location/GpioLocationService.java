package be.codesolutions.goliathapi.location;

import be.codesolutions.goliathapi.location.model.GpioLocation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GpioLocationService {

  @Autowired
  private GpioLocationRepository gpioLocationRepository;

  public List<GpioLocation> getAll() {
    List<GpioLocation> result = new ArrayList<>();
    gpioLocationRepository.findAll().forEach(result::add);
    return result;
  }

  public GpioLocation get(Long id) {
    return gpioLocationRepository.findById(id).get();
  }

  public List<GpioLocation> addAll(List<GpioLocation> gpioLocationList) {
    List<GpioLocation> result = new ArrayList<>();
    gpioLocationRepository.saveAll(gpioLocationList).forEach(result::add);
    return result;
  }


  public void delete(Long id) {
    gpioLocationRepository.deleteById(id);
  }

  public Optional<GpioLocation> update(Long id, GpioLocation gpioLocation) {
    if(gpioLocationRepository.existsById(id)) {
      gpioLocation.setId(id);
      return Optional.of(gpioLocationRepository.save(gpioLocation));
    }
    return Optional.empty();
  }
}
