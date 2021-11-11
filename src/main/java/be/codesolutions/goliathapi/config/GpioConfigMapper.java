package be.codesolutions.goliathapi.config;

import java.util.List;

import org.mapstruct.Mapper;

import be.codesolutions.goliathapi.config.model.GpioConfig;
import be.codesolutions.goliathapi.config.model.GpioConfigRequestDto;
import be.codesolutions.goliathapi.config.model.GpioConfigResponseDto;

@Mapper(componentModel = "spring")
public interface GpioConfigMapper {

    GpioConfigResponseDto toDto(GpioConfig gpioConfig);

    List<GpioConfigResponseDto> toDtoList(List<GpioConfig> gpioConfigs);

    GpioConfig toEntity(GpioConfigRequestDto gpioConfigDto);

}
