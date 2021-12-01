package be.codesolutions.goliathapi.type;

import be.codesolutions.goliathapi.type.model.GpioType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GpioTypeService {

  private GpioTypeRepository gpioTypeRepository;

  public GpioTypeService(GpioTypeRepository gpioTypeRepository) {
    this.gpioTypeRepository = gpioTypeRepository;
  }

  public List<GpioType> getAll() {
    List<GpioType> result = new ArrayList<>();
    gpioTypeRepository.findAll().forEach(result::add);
    return result;
  }

  public void deleteAll() {
    gpioTypeRepository.deleteAll();
  }

  public List<GpioType> add(List<GpioType> gpioTypeList) {
    List<GpioType> result = new ArrayList<>();
    gpioTypeRepository.saveAll(gpioTypeList).forEach(result::add);
    return result;
  }

  public Optional<GpioType> get(Long id) {
    return gpioTypeRepository.findById(id);
  }

  public void delete(Long id) {
    gpioTypeRepository.deleteById(id);
  }

  public Optional<GpioType> update(Long id, GpioType gpioType) {
    if (gpioTypeRepository.existsById(id)) {
      gpioType.setId(id);
      return Optional.of(gpioTypeRepository.save(gpioType));
    }
    return Optional.empty();
  }
}
