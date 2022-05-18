package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Berry;
import com.launchacademy.reviews.services.BerryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BerrySeeder {

  private final BerryService berryService;

  @Autowired
  public BerrySeeder(BerryService berryService) {
    this.berryService = berryService;
  }

  public void seed() {
    if (berryService.findAll().size() == 0) {
      Berry goldenRaspberry = new Berry();
      goldenRaspberry.setName("Golden Raspberries");
      goldenRaspberry.setImgUrl("https://northernnester.com/wp-content/uploads/2020/09/golden-raspberries-768x576.jpg");
      goldenRaspberry.setDescription("Fake looking raspberries");
      berryService.save(goldenRaspberry);

      Berry blueberry = new Berry();
      blueberry.setName("Blueberries");
      blueberry.setImgUrl("https://northernnester.com/wp-content/uploads/2020/09/blueberry-768x576.jpg");
      blueberry.setDescription("Josh's favorite berry");
      berryService.save(blueberry);

      Berry strawberry = new Berry();
      strawberry.setName("Strawberries");
      strawberry.setImgUrl("https://northernnester.com/wp-content/uploads/2020/09/strawberries-768x576.jpg");
      berryService.save(strawberry);
    }
  }
}
