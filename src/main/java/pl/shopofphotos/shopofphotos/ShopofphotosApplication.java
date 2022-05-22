package pl.shopofphotos.shopofphotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
@SpringBootApplication
public class ShopofphotosApplication {
  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        SpringApplication.run(ShopofphotosApplication.class, args);
    DataBaseAppService dataBaseAppService = context.getBean(DataBaseAppService.class);

    dataBaseAppService.runApp();
  }
}
