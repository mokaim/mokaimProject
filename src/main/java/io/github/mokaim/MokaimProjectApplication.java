package io.github.mokaim;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@MapperScan(basePackages = "io.github.mokaim.mapper")
@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy
public class MokaimProjectApplication {

	public static void main(String[] args) {	
		log.info("안녕하세요 ㅋㅋㅋ");
		SpringApplication.run(MokaimProjectApplication.class, args);
	}

}
