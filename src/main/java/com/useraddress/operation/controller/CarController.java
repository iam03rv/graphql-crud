package com.useraddress.operation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.useraddress.operation.model.Car;
import com.useraddress.operation.model.CarVariants;
import com.useraddress.operation.model.CardNo;
import com.useraddress.operation.repository.CarRepository;
import com.useraddress.operation.repository.CarVariantsRepository;
import com.useraddress.operation.repository.CardNoRepo;

@RestController
@RequestMapping("/api")
public class CarController {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarVariantsRepository carVariantsRepository;
	
	@Autowired
	private CardNoRepo cardNoRepo;
	@PostMapping("/rfid")
	public CardNo getCardNo(@RequestBody CardNo cardNo) {
		return cardNoRepo.save(cardNo);
	}
	
	
	@GetMapping("/carVariants")
	public List<CarVariants> getCarVariants() {
		List<Car> carList = carRepository.findAll();
		List<CarVariants> list = new ArrayList<CarVariants>();
		for (int i = 0; i < carList.size(); i++) {
			List<CarVariants> items = carList.get(i).getCarVariant();
			int item = items.size();
			for (int j = 0; j < item; j++) {
				list.add(items.get(j));
			}
		}

		return list;
	}

	@PostMapping("/car")
	public Car createCar(@RequestBody Car car) {
		return carRepository.save(car);
	}
	@PostMapping("/carVariants")
	public CarVariants createCarVariants(@RequestBody CarVariants carVariants) {
		return carVariantsRepository.save(carVariants);
	}
	@GetMapping("/car")
	public List<Car> getCar() {
		return carRepository.findAll();
	}

	@GetMapping("car/{CAR_ID}")
	public Car getCarById(@PathVariable(value = "CAR_ID") long id) {
		return carRepository.findById(id).get();
	}

	@PutMapping("/car/{CAR_ID}")
	public Car updateCar(@PathVariable(value = "CAR_ID") Long carId, @RequestBody Car car) {
		Car c = carRepository.findById(carId).get();

		c.setName(car.getName());

		List<CarVariants> newItemList = car.getCarVariant();

		List<CarVariants> itemList = c.getCarVariant();

		int itemSize = itemList.size();

		for (int i = 0; i < itemSize; i++) {
			itemList.get(i).setColor(newItemList.get(i).getColor());
			itemList.get(i).setModel(newItemList.get(i).getModel());
		}
		c.setCarVariant(itemList);
		return carRepository.save(c);
	}
	@PutMapping("/carVariants/{CAR_VARIANT_ID}")
	public CarVariants updateCarVariants(@PathVariable(value = "CAR_VARIANT_ID") Long carVariantsId, @RequestBody CarVariants carVariants) {
		CarVariants cv = carVariantsRepository.findById(carVariantsId).get();

		cv.setColor(carVariants.getColor());
		cv.setModel(carVariants.getModel());
		return carVariantsRepository.save(cv);
	}

	@DeleteMapping("/car")
	public String deleteAllCar() {
		carRepository.deleteAll();
		return "All cars have been deleted successfully.";
	}
	@DeleteMapping("/carVariants")
	public String deleteAllCarVarinats() {
		carVariantsRepository.deleteAll();
		return "All carVariants have been deleted successfully.";
	}
	
	@DeleteMapping("carVariants/{CAR_VARIANT_ID}")
	public String deleteCarVariants(@PathVariable(value = "CAR_VARIANT_ID") Long carVariantId) {
		carVariantsRepository.deleteById(carVariantId);
		return "the carVarinat" + "(" + carVariantId + ") data" + " have been deleted successfully.";
	}
	@DeleteMapping("car/{CAR_ID}")
	public String deleteCar(@PathVariable(value = "CAR_ID") Long carId) {
		carRepository.deleteById(carId);
		return "the car" + "(" + carId + ") data" + " have been deleted successfully.";
	}
}
