package be.codesolutions.goliathapi.util;

import com.pi4j.io.gpio.Pin;
import com.pi4j.gpio.extension.mcp.MCP23017Pin;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PinUtil {

  private PinUtil() {}

  public static List<Pin> getByName(String name) {
    return Arrays.stream(MCP23017Pin.ALL)
        .filter(pin -> pin.getName().equals(name))
        .collect(Collectors.toList());
  }
}
