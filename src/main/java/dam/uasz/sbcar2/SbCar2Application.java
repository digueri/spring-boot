package dam.uasz.sbcar2;

import java.util.Arrays;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dam.uasz.sbcar2.domain.Car;
import dam.uasz.sbcar2.domain.CarRepository;
import dam.uasz.sbcar2.domain.Owner;
import dam.uasz.sbcar2.domain.OwnerRepository;
@SpringBootApplication
public class SbCar2Application implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(SbCar2Application.class);
	
	@Autowired
	private CarRepository repository;

	@Autowired 
	private OwnerRepository oRepository;

	public static void main(String[] args) {
		SpringApplication.run(SbCar2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("Moty", "Digueri");
		Owner owner2 = new Owner("john", "john");
		oRepository.saveAll(Arrays.asList(owner1,owner2));
		Car car1 = new Car("Ford", "red","Mustang", 99999, "ADF-111", 2023,owner1);
		Car car2 = new Car("Toyota", "white", "v6",1000,  "ADF-000", 2016,owner1);
		Car car3 = new Car("Nissan", "gray", "petrol",3999, "ADF-2222", 2020,owner2);
		Car car4 = new Car("Toyota", "white", "hillux", 333, "ADF-121", 2023,owner1);
		Car car5 = new Car("Ford", "green", "mini",5555, "ADF-420", 2016,owner1);
		Car car6 = new Car("Nissan", "gray", "petrol",30000, "ADF-42", 2020,owner2);

		repository.saveAll(Arrays.asList(car1,car2, car3,car4,car5,car6));
		for (Car car : repository.findAll()){
			logger.info(car.getBrand()+" "+car.getModel());
		}
	}
}
