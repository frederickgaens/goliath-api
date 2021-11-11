package be.codesolutions.goliathapi.config.model;

public record GpioConfigRequestDto(Long id, int address, String name, String description) {}
