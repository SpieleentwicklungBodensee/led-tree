package spieleentwicklung_bodensee.led_tree.api;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Drawings API", description = "insert/modify/delete drawings")
@RestController
@RequestMapping("/api")
public class DrawingController {

  public static final String EXAMPLE_JSON = "{\n"
      + "  \"frameTiming\": 128,\n"
      + "  \"frames\": [\n"
      + "    \"BMP data\"\n"
      + "  ]\n"
      + "}";

  private static final Map<String, DrawingDto> map = new HashMap<>();

  @GetMapping("/drawings")
  public Collection<DrawingDto> getAllDrawings() {
    return map.values();
  }

  @GetMapping("/drawing/{id}")
  public DrawingDto getDrawing(@PathVariable String id) {
    return map.get(id);
  }

  @PostMapping("/drawing")
  @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
      @ExampleObject(value = EXAMPLE_JSON)}))
  public DrawingDto createNewDrawing(@RequestBody DrawingDto drawing) {
    drawing.setId(UUID.randomUUID().toString());
    map.put(drawing.getId(), drawing);
    return drawing;
  }

  @PatchMapping("/drawing/{id}")
  public DrawingDto editDrawing(@PathVariable String id,
                                     @RequestBody DrawingDto drawing)
  {
    assert Objects.equals(id, drawing.getId());
    map.put(id, drawing);
    return drawing;
  }

  @DeleteMapping("/drawing/{id}")
  public void deleteDrawing(@PathVariable String id)
  {
    map.remove(id);
  }


}
