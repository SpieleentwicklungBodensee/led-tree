package spieleentwicklung_bodensee.led_tree.api;

import java.util.List;
import lombok.Data;

@Data
public class DrawingDto {

  private String id;
  private int frameTiming;
  private List<String> frames;

}
