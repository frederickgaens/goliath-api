package be.codesolutions.goliathapi.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GpioConfigService {

    @Autowired
    private GpioConfigRepository gpioConfigRepository;

    public List<GpioConfig> getAll() {
        List<GpioConfig> gpioConfigs = new ArrayList<GpioConfig>();
        gpioConfigRepository.findAll().forEach(gpioConfigs::add);
        return gpioConfigs;
    }

    public GpioConfig getGpioConfig(Long id) {
        return gpioConfigRepository.findById(id).get();
    }

    public GpioConfig add(GpioConfig gpioConfig) {
        return gpioConfigRepository.save(gpioConfig);
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
