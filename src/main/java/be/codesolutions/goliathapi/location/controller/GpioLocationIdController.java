package be.codesolutions.goliathapi.location.controller;

import be.codesolutions.goliathapi.location.GpioLocationMapper;
import be.codesolutions.goliathapi.location.GpioLocationService;
import be.codesolutions.goliathapi.location.model.GpioLocation;
import be.codesolutions.goliathapi.location.model.GpioLocationRequestDto;
import be.codesolutions.goliathapi.location.model.GpioLocationResponseDto;
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
@RequestMapping(value = "/gpio-locations/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioLocationIdController {

  private final GpioLocationMapper gpioLocationMapper;
  private final GpioLocationService gpioLocationService;

  public GpioLocationIdController(
      GpioLocationMapper gpioLocationMapper, GpioLocationService gpioLocationService) {
    this.gpioLocationMapper = gpioLocationMapper;
    this.gpioLocationService = gpioLocationService;
  }

  @GetMapping
  public ResponseEntity<GpioLocationResponseDto> get(
      @PathVariable(name = "id") Long id
  ) {
    Optional<GpioLocation> gpioLocationOptional = gpioLocationService.get(id);

    return gpioLocationOptional.map(
            gpioLocation -> ResponseEntity.ok(gpioLocationMapper.toDto(gpioLocation)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping
  public ResponseEntity<GpioLocationResponseDto> update(
      @PathVariable(name = "id") Long id,
      @RequestBody GpioLocationRequestDto gpioLocationRequestDto
  ) {
    Optional<GpioLocation> gpioLocationOptional = gpioLocationService.update(id,
        gpioLocationMapper.toEntity(gpioLocationRequestDto));

    return gpioLocationOptional.map(
            gpioLocation -> ResponseEntity.ok(gpioLocationMapper.toDto(gpioLocation)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping
  public ResponseEntity<Void> delete(
      @PathVariable(name = "id") Long id
  ) {
    gpioLocationService.delete(id);
    return ResponseEntity.ok().build();
  }

}
