package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;


@SpringBootApplication
@RestController
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@RequestMapping( path = "/cpu" )
	public void cpu(@RequestParam("level") String per) {

		int loop = Integer.valueOf(per);
		for( int j =0 ; j < loop; j++ ){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 1000000000; i++) {
						Random r = new Random();
						r.setSeed(System.currentTimeMillis());
						r.nextLong();
					}
				}
			});
			t.start();
		}

	}
}