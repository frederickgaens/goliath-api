package be.codesolutions.goliathapi.location.controller;

import be.codesolutions.goliathapi.location.GpioLocationMapper;
import be.codesolutions.goliathapi.location.GpioLocationService;
import be.codesolutions.goliathapi.location.model.GpioLocation;
import be.codesolutions.goliathapi.location.model.GpioLocationRequestDto;
import be.codesolutions.goliathapi.location.model.GpioLocationResponseDto;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gpio-locations",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioLocationController {

  private final GpioLocationMapper gpioLocationMapper;
  private final GpioLocationService gpioLocationService;

  public GpioLocationController(
      GpioLocationMapper gpioLocationMapper, GpioLocationService gpioLocationService) {
    this.gpioLocationMapper = gpioLocationMapper;
    this.gpioLocationService = gpioLocationService;
  }

  @GetMapping
  public ResponseEntity<List<GpioLocationResponseDto>> get() {
    List<GpioLocation> gpioLocationList = gpioLocationService.getAll();
    return ResponseEntity.ok(gpioLocationMapper.toDtoList(gpioLocationList));
  }

  @PostMapping
  public ResponseEntity<List<GpioLocationResponseDto>> addGpioLocations(
      @RequestBody List<GpioLocationRequestDto> gpioLocationDtoList
  ) {
    List<GpioLocation> gpioLocationList = gpioLocationService.addAll(
        gpioLocationMapper.toEntityList(gpioLocationDtoList));
    return ResponseEntity.ok(gpioLocationMapper.toDtoList(gpioLocationList));
  }

}
