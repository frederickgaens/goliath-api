package be.codesolutions.goliathapi.config;

import be.codesolutions.goliathapi.config.model.GpioConfig;
import be.codesolutions.goliathapi.config.model.GpioConfigRequestDto;
import be.codesolutions.goliathapi.config.model.GpioConfigResponseDto;
import be.codesolutions.goliathapi.location.GpioLocationRepository;
import be.codesolutions.goliathapi.location.model.GpioLocation;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class GpioConfigMapper {

  @Autowired
  private GpioLocationRepository gpioLocationRepository;

  public GpioConfigMapper() {}

  public abstract GpioConfigResponseDto toDto(GpioConfig gpioConfig);

  public abstract List<GpioConfigResponseDto> toDtoList(List<GpioConfig> gpioConfigList);

  public abstract GpioConfig toEntity(GpioConfigRequestDto gpioConfigDto);

  public abstract List<GpioConfig> toEntityList(List<GpioConfigRequestDto> gpioConfigRequestDtoList);

  public String toDto(GpioLocation location) {
    return location == null ? null : location.getName();
  }

  // TODO: throw descent error
  public GpioLocation toEntity(String location) {
    Optional<GpioLocation> gpioLocationOptional = gpioLocationRepository.findOptionalByName(
        location);
    return gpioLocationOptional.map(gpioLocation -> gpioLocation).orElseThrow();
  }
}
