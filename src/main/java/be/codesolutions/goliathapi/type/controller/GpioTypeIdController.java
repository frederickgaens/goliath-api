package be.codesolutions.goliathapi.type.controller;

import be.codesolutions.goliathapi.type.GpioTypeMapper;
import be.codesolutions.goliathapi.type.GpioTypeService;
import be.codesolutions.goliathapi.type.model.GpioType;
import be.codesolutions.goliathapi.type.model.GpioTypeRequestDto;
import be.codesolutions.goliathapi.type.model.GpioTypeResponseDto;
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
@RequestMapping(value = "/gpio-types/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioTypeIdController {

  private GpioTypeMapper gpioTypeMapper;
  private GpioTypeService gpioTypeService;

  public GpioTypeIdController(GpioTypeMapper gpioTypeMapper,
      GpioTypeService gpioTypeService) {
    this.gpioTypeMapper = gpioTypeMapper;
    this.gpioTypeService = gpioTypeService;
  }

  @GetMapping
  public ResponseEntity<GpioTypeResponseDto> get(
      @PathVariable(name = "id") Long id
  ) {
    Optional<GpioType> gpioTypeOptional = gpioTypeService.get(id);

    return gpioTypeOptional.map(gpioType -> ResponseEntity.ok(gpioTypeMapper.toDto(gpioType)))
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping
  public ResponseEntity<GpioTypeResponseDto> update(
      @PathVariable(name = "id") Long id,
      @RequestBody GpioTypeRequestDto gpioTypeRequestDto
  ) {
    Optional<GpioType> gpioTypeOptional = gpioTypeService.update(id, gpioTypeMapper.toEntity(gpioTypeRequestDto));

    return gpioTypeOptional.map(gpioType -> ResponseEntity.ok(gpioTypeMapper.toDto(gpioType)))
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping
  public ResponseEntity<Void> delete(
      @PathVariable(name = "id") Long id
  ) {
    gpioTypeService.delete(id);
    return ResponseEntity.ok().build();
  }
}
