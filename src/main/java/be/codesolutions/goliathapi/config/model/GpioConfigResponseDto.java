package be.codesolutions.goliathapi.config.model;

import java.util.Set;

public record GpioConfigResponseDto(Long id, int address, String name, String description,
                                    String location,
                                    Set<GpioConfigResponseDto> parentProducers,
                                    Set<GpioConfigResponseDto> childConsumers) {

}
