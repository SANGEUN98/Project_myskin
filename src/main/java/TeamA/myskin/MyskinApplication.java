package TeamA.myskin;

import TeamA.myskin.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(MyBatisConfig.class)
@SpringBootApplication(scanBasePackages = "TeamA.myskin.web")
public class MyskinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyskinApplication.class, args);
	}

}
