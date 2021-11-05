package be.codesolutions.goliathapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gpio-configs/{gpioConfigId}/child-consumer/{childConsumerId}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioConfigIdChildConsumerIdController {

    @Autowired
    private GpioConfigService gpioConfigService;
    @Autowired
    private GpioConfigMapper gpioConfigMapper;

    @PutMapping
    public ResponseEntity<GpioConfigResponseDto> linkChildToParent(
        @PathVariable(name = "gpioConfigId") Long gpioConfigId,
        @PathVariable(name = "childConsumerId") Long childConsumerId
    ) {
        GpioConfig gpioConfig = gpioConfigService.linkChildToParent(gpioConfigId, childConsumerId);
        return ResponseEntity.ok().body(gpioConfigMapper.toDto(gpioConfig));
    }
    
}
