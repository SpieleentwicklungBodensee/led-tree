package spieleentwicklung_bodensee.led_tree.api;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SwaggerRedirectController {

  @GetMapping("/swagger")
  public ModelAndView redirectSwagger(ModelMap model) {
    return new ModelAndView("redirect:/swagger-ui/index.html", model);
  }

}
