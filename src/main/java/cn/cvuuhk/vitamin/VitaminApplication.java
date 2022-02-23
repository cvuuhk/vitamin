package cn.cvuuhk.vitamin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VitaminApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(VitaminApplication.class);
    application.setBannerMode(Banner.Mode.OFF);
    application.run(args);
  }
}
