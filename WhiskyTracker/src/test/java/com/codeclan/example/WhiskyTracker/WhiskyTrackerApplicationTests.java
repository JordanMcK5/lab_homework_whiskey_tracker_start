package com.codeclan.example.WhiskyTracker;

import static org.junit.Assert.assertEquals;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskysOver20(){
		List<Whisky> found = whiskyRepository.findByAgeGreaterThan(2018);
		assertEquals(0, found.size());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Lowland");
		assertEquals(2, found.size());
	}
	@Test
	public void canFindWhiskyInRegionWithSpecificAge(){
		Distillery foundDistillery = distilleryRepository.getOne(1L);
		List<Whisky> foundWhisky = whiskyRepository.findByDistilleryNameAndAge(foundDistillery.getName(),  12);
		assertEquals(1,foundWhisky.size());

	}
}
