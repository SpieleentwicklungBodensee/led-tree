package spieleentwicklung_bodensee.led_tree.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import spieleentwicklung_bodensee.led_tree.api.DrawingDto;

public interface DrawingRepo extends JpaRepository<DrawingDto, String> {

}
