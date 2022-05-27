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
      goldenRaspberry.setImageUrl("https://northernnester.com/wp-content/uploads/2020/09/golden-raspberries-768x576.jpg");
      goldenRaspberry.setDescription("Fake looking raspberries");
      berryService.save(goldenRaspberry);

      Berry blueberry = new Berry();
      blueberry.setName("Blueberries");
      blueberry.setImageUrl("https://northernnester.com/wp-content/uploads/2020/09/blueberry-768x576.jpg");
      blueberry.setDescription("A decent berry");
      berryService.save(blueberry);

      Berry strawberry = new Berry();
      strawberry.setName("Strawberries");
      strawberry.setImageUrl("https://northernnester.com/wp-content/uploads/2020/09/strawberries-768x576.jpg");
      berryService.save(strawberry);

      Berry pineapple = new Berry();
      pineapple.setName("Pineapples");
      pineapple.setImageUrl("https://images.heb.com/is/image/HEBGrocery/001945935");
      pineapple.setDescription("Yes, it's a berry. Yes, it's the best berry");
      berryService.save(pineapple);
    }
  }
}