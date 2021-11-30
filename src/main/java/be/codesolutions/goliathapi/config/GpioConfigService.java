package be.codesolutions.goliathapi.config;

import be.codesolutions.goliathapi.config.model.GpioConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GpioConfigService {

  private final GpioConfigRepository gpioConfigRepository;

  public GpioConfigService(
      GpioConfigRepository gpioConfigRepository) {
    this.gpioConfigRepository = gpioConfigRepository;
  }

  public List<GpioConfig> getAll() {
    List<GpioConfig> result = new ArrayList<>();
    gpioConfigRepository.findAll().forEach(result::add);
    return result;
  }

  public Optional<GpioConfig> get(Long id) {
    return gpioConfigRepository.findById(id);
  }

  public List<GpioConfig> addAll(List<GpioConfig> gpioConfigList) {
    List<GpioConfig> result = new ArrayList<>();
    gpioConfigRepository.saveAll(gpioConfigList).forEach(result::add);
    return result;
  }

  public GpioConfig add(GpioConfig gpioConfig) {
    return gpioConfigRepository.save(gpioConfig);
  }

  public void delete(Long id) {
    gpioConfigRepository.deleteById(id);
  }

  public Optional<GpioConfig> linkChildToParent(Long gpioConfigId, Long childConsumerId) {
    Optional<GpioConfig> parent = gpioConfigRepository.findById(gpioConfigId);
    Optional<GpioConfig> child = gpioConfigRepository.findById(childConsumerId);

    if (parent.isPresent() && child.isPresent()) {
      parent.get().getConsumers().add(child.get());
      return parent;
    } else {
      return Optional.empty();
    }
  }

  public Optional<GpioConfig> update(Long id, GpioConfig gpioConfig) {
    if (gpioConfigRepository.existsById(id)) {
      gpioConfig.setId(id);
      return Optional.of(gpioConfigRepository.save(gpioConfig));
    }
    return Optional.empty();
  }

  public void deleteAll() {
    gpioConfigRepository.deleteAll();
  }
}
