package be.codesolutions.goliathapi.type;

import be.codesolutions.goliathapi.type.model.GpioType;
import be.codesolutions.goliathapi.type.model.GpioTypeRequestDto;
import be.codesolutions.goliathapi.type.model.GpioTypeResponseDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GpioTypeMapper {

  List<GpioTypeResponseDto> toDtoList(List<GpioType> gpioTypeList);

  List<GpioType> toEntityList(List<GpioTypeRequestDto> gpioTypeRequestDtoList);

  GpioTypeResponseDto toDto(GpioType gpioType);

  GpioType toEntity(GpioTypeRequestDto gpioTypeRequestDto);
}
