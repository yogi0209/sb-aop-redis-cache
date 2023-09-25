package com.yogendra.sbaoprediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.yogendra.sbaoprediscache")
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SbAopRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbAopRedisCacheApplication.class, args);
	}

}
