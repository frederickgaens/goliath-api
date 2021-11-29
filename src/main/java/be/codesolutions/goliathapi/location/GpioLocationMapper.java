package be.codesolutions.goliathapi.location;

import be.codesolutions.goliathapi.location.model.GpioLocation;
import be.codesolutions.goliathapi.location.model.GpioLocationRequestDto;
import be.codesolutions.goliathapi.location.model.GpioLocationResponseDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GpioLocationMapper {


  List<GpioLocationResponseDto> toDtoList(List<GpioLocation> gpioLocationList);

  List<GpioLocation> toEntityList(List<GpioLocationRequestDto> gpioLocationDtoList);

  GpioLocationResponseDto toDto(GpioLocation gpioLocation);

  GpioLocation toEntity(GpioLocationRequestDto gpioLocationRequestDto);
}
