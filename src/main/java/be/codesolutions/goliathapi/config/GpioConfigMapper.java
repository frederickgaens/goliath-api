package be.codesolutions.goliathapi.config;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GpioConfigMapper {

    GpioConfigResponseDto toDto(GpioConfig gpioConfig);

    List<GpioConfigResponseDto> toDtoList(List<GpioConfig> gpioConfigs);

    GpioConfig toEntity(GpioConfigRequestDto gpioConfigDto);

}
