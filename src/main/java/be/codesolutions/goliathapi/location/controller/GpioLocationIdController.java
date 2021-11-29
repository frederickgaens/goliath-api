package be.codesolutions.goliathapi.location.controller;

import be.codesolutions.goliathapi.location.GpioLocationMapper;
import be.codesolutions.goliathapi.location.GpioLocationService;
import be.codesolutions.goliathapi.location.model.GpioLocation;
import be.codesolutions.goliathapi.location.model.GpioLocationRequestDto;
import be.codesolutions.goliathapi.location.model.GpioLocationResponseDto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private GpioLocationMapper gpioLocationMapper;

  @Autowired
  private GpioLocationService gpioLocationService;

  @GetMapping
  public ResponseEntity<GpioLocationResponseDto> get(
      @PathVariable(name = "id") Long id
  ) {
    GpioLocation gpioLocation = gpioLocationService.get(id);
    return ResponseEntity.ok(gpioLocationMapper.toDto(gpioLocation));
  }

  @PutMapping
  public ResponseEntity<GpioLocationResponseDto> update(
      @PathVariable(name = "id") Long id,
      @RequestBody GpioLocationRequestDto gpioLocationRequestDto
  ) {
    Optional<GpioLocation> gpioLocationOptional = gpioLocationService.update(id,
        gpioLocationMapper.toEntity(gpioLocationRequestDto));
    if (gpioLocationOptional.isPresent()) {
      return ResponseEntity.ok(gpioLocationMapper.toDto(gpioLocationOptional.get()));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping
  public ResponseEntity<Void> delete(
      @PathVariable(name = "id") Long id
  ) {
    gpioLocationService.delete(id);
    return ResponseEntity.ok().build();
  }

}
