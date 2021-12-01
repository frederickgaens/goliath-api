package be.codesolutions.goliathapi.type.controller;

import be.codesolutions.goliathapi.type.GpioTypeMapper;
import be.codesolutions.goliathapi.type.GpioTypeService;
import be.codesolutions.goliathapi.type.model.GpioType;
import be.codesolutions.goliathapi.type.model.GpioTypeRequestDto;
import be.codesolutions.goliathapi.type.model.GpioTypeResponseDto;
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
@RequestMapping(value = "/gpio-types",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class GpioTypeController {

  private GpioTypeMapper gpioTypeMapper;
  private GpioTypeService gpioTypeService;

  public GpioTypeController(GpioTypeMapper gpioTypeMapper,
      GpioTypeService gpioTypeService) {
    this.gpioTypeMapper = gpioTypeMapper;
    this.gpioTypeService = gpioTypeService;
  }

  @GetMapping
  public ResponseEntity<List<GpioTypeResponseDto>> get() {
    List<GpioType> gpioTypeList = gpioTypeService.getAll();
    return ResponseEntity.ok(gpioTypeMapper.toDtoList(gpioTypeList));
  }

  @PostMapping
  public ResponseEntity<List<GpioTypeResponseDto>> add(
      @RequestBody List<GpioTypeRequestDto> gpioTypeRequestDtoList
  ) {
    List<GpioType> gpioTypeList = gpioTypeService.add(
        gpioTypeMapper.toEntityList(gpioTypeRequestDtoList));

    return ResponseEntity.ok(gpioTypeMapper.toDtoList(gpioTypeList));
  }

  @DeleteMapping
  public ResponseEntity<Void> delete() {
    gpioTypeService.deleteAll();
    return ResponseEntity.ok().build();
  }
}
