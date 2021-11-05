package be.codesolutions.goliathapi.config;

public class GpioConfigRequestDto {

    private Long id;
    private int address;
    private String name;

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

}
