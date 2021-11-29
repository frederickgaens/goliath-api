package be.codesolutions.goliathapi.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pi4j.wiringpi.Gpio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.codesolutions.goliathapi.config.model.GpioConfig;

@Service
public class GpioConfigService {

    @Autowired
    private GpioConfigRepository gpioConfigRepository;

    public List<GpioConfig> getAll() {
        List<GpioConfig> result = new ArrayList<GpioConfig>();
        gpioConfigRepository.findAll().forEach(result::add);
        return result;
    }

    public GpioConfig get(Long id) {
        return gpioConfigRepository.findById(id).get();
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

    public GpioConfig linkChildToParent(Long gpioConfigId, Long childConsumerId) {
        Optional<GpioConfig> parent = gpioConfigRepository.findById(gpioConfigId);
        Optional<GpioConfig> child = gpioConfigRepository.findById(childConsumerId);

        if(!parent.isEmpty() && !child.isEmpty()) {
            parent.get().getConsumers().add(child.get());
        }
        return parent.get();
    }
}
