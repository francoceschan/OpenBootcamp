package com.ob.ejercicio1;

import com.ob.ejercicio1.entities.Laptop;
import com.ob.ejercicio1.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {



	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio1Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Samsung", "Galaxy", "Intel i5 11va", 8, 256,15.6);
		Laptop laptop2 = new Laptop(null, "Dell", "Inspiron 3515", "AMD Ryzen 5", 8, 256,15.5);

		repository.save(laptop1);
		repository.save(laptop2);
	}

}
