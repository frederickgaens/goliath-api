package be.codesolutions.goliathapi.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.codesolutions.goliathapi.config.GpioConfigMapper;
import be.codesolutions.goliathapi.config.GpioConfigService;
import be.codesolutions.goliathapi.config.model.GpioConfig;
import be.codesolutions.goliathapi.config.model.GpioConfigResponseDto;

@RestController
@RequestMapping(value = "/gpio-configs/{gpioConfigId}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioConfigIdController {

    @Autowired
    private GpioConfigService gpioConfigService;
    @Autowired
    private GpioConfigMapper gpioConfigMapper;

    @GetMapping
    public ResponseEntity<GpioConfigResponseDto> getGpioConfig(
        @PathVariable(name = "gpioConfigId") Long gpioConfigId
    ) {
        GpioConfig gpioConfig = gpioConfigService.getGpioConfig(gpioConfigId);
        return ResponseEntity.ok(gpioConfigMapper.toDto(gpioConfig));
    }
    
}
