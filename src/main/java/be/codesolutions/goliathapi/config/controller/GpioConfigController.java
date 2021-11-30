package be.codesolutions.goliathapi.config.controller;

import be.codesolutions.goliathapi.config.GpioConfigMapper;
import be.codesolutions.goliathapi.config.GpioConfigService;
import be.codesolutions.goliathapi.config.model.GpioConfig;
import be.codesolutions.goliathapi.config.model.GpioConfigRequestDto;
import be.codesolutions.goliathapi.config.model.GpioConfigResponseDto;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gpio-configs",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioConfigController {

  private final GpioConfigMapper gpioConfigMapper;
  private final GpioConfigService gpioConfigService;

  public GpioConfigController(
      GpioConfigMapper gpioConfigMapper, GpioConfigService gpioConfigService) {
    this.gpioConfigMapper = gpioConfigMapper;
    this.gpioConfigService = gpioConfigService;
  }

  @GetMapping
  public ResponseEntity<List<GpioConfigResponseDto>> get() {
    List<GpioConfig> gpioConfigs = gpioConfigService.getAll();
    return ResponseEntity.ok().body(gpioConfigMapper.toDtoList(gpioConfigs));
  }

  @PostMapping
  public ResponseEntity<List<GpioConfigResponseDto>> add(
      @RequestBody List<GpioConfigRequestDto> gpioConfigRequestDtoList
  ) {
    List<GpioConfig> gpioConfigList = gpioConfigService.addAll(
        gpioConfigMapper.toEntityList(gpioConfigRequestDtoList));
    return ResponseEntity.ok().body(gpioConfigMapper.toDtoList(gpioConfigList));
  }

  @DeleteMapping
  public ResponseEntity<Void> delete() {
    gpioConfigService.deleteAll();
    return ResponseEntity.ok().build();
  }

}
