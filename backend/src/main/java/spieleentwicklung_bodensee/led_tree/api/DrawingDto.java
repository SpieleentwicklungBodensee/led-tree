package spieleentwicklung_bodensee.led_tree.api;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class DrawingDto {

  @Id
  private String id;
  private int frameTiming;
  @ElementCollection
  private List<String> frames;

}
