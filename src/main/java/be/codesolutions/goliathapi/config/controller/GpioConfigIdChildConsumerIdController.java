package be.codesolutions.goliathapi.config.controller;

import be.codesolutions.goliathapi.config.GpioConfigMapper;
import be.codesolutions.goliathapi.config.GpioConfigService;
import be.codesolutions.goliathapi.config.model.GpioConfig;
import be.codesolutions.goliathapi.config.model.GpioConfigResponseDto;
import java.util.Optional;
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

  private final GpioConfigService gpioConfigService;
  private final GpioConfigMapper gpioConfigMapper;

  public GpioConfigIdChildConsumerIdController(
      GpioConfigService gpioConfigService, GpioConfigMapper gpioConfigMapper) {
    this.gpioConfigService = gpioConfigService;
    this.gpioConfigMapper = gpioConfigMapper;
  }

  @PutMapping
  public ResponseEntity<GpioConfigResponseDto> linkChildToParent(
      @PathVariable(name = "gpioConfigId") Long gpioConfigId,
      @PathVariable(name = "childConsumerId") Long childConsumerId
  ) {
    Optional<GpioConfig> gpioConfigOptional = gpioConfigService.linkChildToParent(gpioConfigId,
        childConsumerId);

    return gpioConfigOptional.map(
            gpioConfig -> ResponseEntity.ok(gpioConfigMapper.toDto(gpioConfig)))
        .orElse(ResponseEntity.notFound().build());
  }

}
