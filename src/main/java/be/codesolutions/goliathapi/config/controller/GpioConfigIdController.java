package be.codesolutions.goliathapi.config.controller;

import be.codesolutions.goliathapi.config.GpioConfigMapper;
import be.codesolutions.goliathapi.config.GpioConfigService;
import be.codesolutions.goliathapi.config.model.GpioConfig;
import be.codesolutions.goliathapi.config.model.GpioConfigRequestDto;
import be.codesolutions.goliathapi.config.model.GpioConfigResponseDto;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gpio-configs/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioConfigIdController {

  private final GpioConfigService gpioConfigService;
  private final GpioConfigMapper gpioConfigMapper;

  public GpioConfigIdController(
      GpioConfigService gpioConfigService, GpioConfigMapper gpioConfigMapper) {
    this.gpioConfigService = gpioConfigService;
    this.gpioConfigMapper = gpioConfigMapper;
  }

  @GetMapping
  public ResponseEntity<GpioConfigResponseDto> get(
      @PathVariable(name = "id") Long id
  ) {
    Optional<GpioConfig> gpioConfigOptional = gpioConfigService.get(id);

    return gpioConfigOptional.map(
            gpioConfig -> ResponseEntity.ok(gpioConfigMapper.toDto(gpioConfig)))
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping
  public ResponseEntity<GpioConfigResponseDto> update(
      @PathVariable(name = "id") Long id,
      @RequestBody GpioConfigRequestDto gpioConfigRequestDto
  ) {
    Optional<GpioConfig> gpioConfigOptional = gpioConfigService.update(id, gpioConfigMapper.toEntity(gpioConfigRequestDto));

    return gpioConfigOptional.map(
            gpioConfig -> ResponseEntity.ok(gpioConfigMapper.toDto(gpioConfig)))
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping
  public ResponseEntity<Void> delete(
      @PathVariable(name = "id") Long id
  ) {
    gpioConfigService.delete(id);
    return ResponseEntity.ok().build();
  }
}
