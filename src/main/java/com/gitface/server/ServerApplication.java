package com.gitface.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ServerApplication {
	/*스프링부트를 기동하기 위해서 필요한 main 메서드*/
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

/*
* @SpringBootApplication 어노테이션은
* @EnableAutoConfiguration, @ComponentScan, @Configuration 들을 하나로 묶어 놓은 거라고 볼 수 있다.
* 그리고 어노테이션을 설정한 클래스가 있는 package 를 최상위 패키지로 인식하고
* ComponentScan 을 수행하기 때문에 클래스의 파일 위치 또한 중요하다.
*/