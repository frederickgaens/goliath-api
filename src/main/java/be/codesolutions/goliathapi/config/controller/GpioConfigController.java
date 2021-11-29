package be.codesolutions.goliathapi.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.codesolutions.goliathapi.config.GpioConfigMapper;
import be.codesolutions.goliathapi.config.GpioConfigService;
import be.codesolutions.goliathapi.config.model.GpioConfig;
import be.codesolutions.goliathapi.config.model.GpioConfigRequestDto;
import be.codesolutions.goliathapi.config.model.GpioConfigResponseDto;

@RestController
@RequestMapping(value = "/gpio-configs",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioConfigController {

    @Autowired
    private GpioConfigMapper gpioConfigMapper;
    
    @Autowired
    private GpioConfigService gpioConfigService;

    @GetMapping
    public ResponseEntity<List<GpioConfigResponseDto>> get() {
        List<GpioConfig> gpioConfigs = gpioConfigService.getAll();
        return ResponseEntity.ok().body(gpioConfigMapper.toDtoList(gpioConfigs));
    }

    @PostMapping
    public ResponseEntity<List<GpioConfigResponseDto>> addAll(
        @RequestBody List<GpioConfigRequestDto> gpioConfigRequestDtoList
    ) {
        List<GpioConfig> gpioConfigList = gpioConfigService.addAll(gpioConfigMapper.toEntityList(gpioConfigRequestDtoList));
        return ResponseEntity.ok().body(gpioConfigMapper.toDtoList(gpioConfigList));
    }

}
