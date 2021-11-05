package be.codesolutions.goliathapi.config;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class GpioConfig {

  @Id
  @GeneratedValue
  private Long id;
  private int address;
  private String name;
  @ManyToMany
  private Set<GpioConfig> parentProducers;
  @ManyToMany
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
