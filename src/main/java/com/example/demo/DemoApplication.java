package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.ws.soap.security.wss4j.support.CryptoFactoryBean;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CryptoFactoryBean getCryptoFactoryBean() throws IOException {
		CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
		cryptoFactoryBean.setKeyStorePassword("123");
//        cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("keystore.jks"));  // working
		cryptoFactoryBean.setKeyStoreLocation(new FileSystemResource("keystore.jks"));  // not working
		System.out.println("==   SERV KEYSTORE    ================================================");
		return cryptoFactoryBean;
	}

}
