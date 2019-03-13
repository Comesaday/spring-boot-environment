package cn.comesaday.cw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.comesaday.cw.mapper")
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
