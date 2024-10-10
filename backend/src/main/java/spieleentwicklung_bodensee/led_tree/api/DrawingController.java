package spieleentwicklung_bodensee.led_tree.api;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spieleentwicklung_bodensee.led_tree.persistance.DrawingRepo;

@Tag(name = "Drawings API", description = "insert/modify/delete drawings")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DrawingController {

  private final DrawingRepo repo;

  public static final String EXAMPLE_JSON = "{\n"
      + "  \"frameTiming\": 128,\n"
      + "  \"frames\": [\n"
      + "    \"BMP data\"\n"
      + "  ]\n"
      + "}";

  @GetMapping("/drawings")
  public List<DrawingDto> getAllDrawings() {
    return repo.findAll();
  }

  @GetMapping("/drawing/{id}")
  public DrawingDto getDrawing(@PathVariable String id) {
    return repo.findById(id).orElseThrow();
  }

  @PostMapping("/drawing")
  @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
      @ExampleObject(value = EXAMPLE_JSON)}))
  public DrawingDto createNewDrawing(@RequestBody DrawingDto drawing) {
    drawing.setId(UUID.randomUUID().toString());
    return repo.save(drawing);
  }

  @PatchMapping("/drawing/{id}")
  public DrawingDto editDrawing(@PathVariable String id,
                                @RequestBody DrawingDto drawing)
  {
    assert Objects.equals(id, drawing.getId());
    repo.save(drawing);
    return drawing;
  }

  @DeleteMapping("/drawing/{id}")
  public void deleteDrawing(@PathVariable String id)
  {
    repo.deleteById(id);
  }


}
