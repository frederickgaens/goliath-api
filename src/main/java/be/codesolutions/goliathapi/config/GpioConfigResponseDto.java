package be.codesolutions.goliathapi.config;

import java.util.Set;

public class GpioConfigResponseDto {

    private Long id;
    private int address;
    private String name;
    private String description;
    private Set<GpioConfig> parentProducers;
    private Set<GpioConfig> childConsumers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descritption) {
        this.description = descritption;
    }

    public Set<GpioConfig> getProducers() {
        return parentProducers;
    }

    public void setProducers(Set<GpioConfig> parents) {
        this.parentProducers = parents;
    }

    public Set<GpioConfig> getConsumers() {
        return childConsumers;
    }

    public void setConsumers(Set<GpioConfig> children) {
        this.childConsumers = children;
    }
}
