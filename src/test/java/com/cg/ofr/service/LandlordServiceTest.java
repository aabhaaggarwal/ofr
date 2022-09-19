package com.cg.ofr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;

@SpringBootTest
public class LandlordServiceTest {

	@InjectMocks
	ILandlordServiceImpl iLandlordServiceImpl = new ILandlordServiceImpl();

	@Mock
	ILandlordRepository iLandlordRepository;

	@Test
	public void testAddLandlord() {
		Landlord landlord = new Landlord();
		landlord.setUserId("LAN5");
		landlord.setPassword("********");
		landlord.setUsername("HARRA");
		landlord.setAge(26);
		landlord.setEmail("har@123");
		landlord.setLandlordName("Harish Mehta");
		landlord.setMobile("9876567892");

		when(iLandlordRepository.save(ArgumentMatchers.any(Landlord.class))).thenReturn(landlord);
		Landlord updatedLandlord = iLandlordServiceImpl.addLandlord(landlord);

		assertEquals(26, updatedLandlord.getAge());
		verify(iLandlordRepository).save(landlord);
	}

	@Test
	public void testUpdateLandlord() {

		Landlord landlord = new Landlord();
		landlord.setUserId("LAN5");
		landlord.setPassword("********");
		landlord.setUsername("HARRA");
		landlord.setAge(26);
		landlord.setEmail("har@123");
		landlord.setLandlordName("Harish Mehta");
		landlord.setMobile("9876567892");

		Landlord newLandlord = new Landlord();
		landlord.setUserId("LAN5");
		landlord.setPassword("********");
		landlord.setUsername("AABB");
		landlord.setAge(26);
		landlord.setEmail("har@123");
		landlord.setLandlordName("Harish Mehta");
		landlord.setMobile("9876567892");

		when(iLandlordRepository.findById((newLandlord.getUserId()))).thenReturn(Optional.of(landlord));
		when(iLandlordRepository.save(newLandlord)).thenReturn(newLandlord);
		Landlord updatedLandlord = iLandlordServiceImpl.updateLandlord(newLandlord);
		assertEquals(newLandlord, updatedLandlord);

	}

	@Test
	public void testUpdateLandlordException() {

		Landlord landlord = new Landlord();
		landlord.setUserId("LAN5");
		landlord.setPassword("********");
		landlord.setUsername("HARRA");
		landlord.setAge(26);
		landlord.setEmail("har@123");
		landlord.setLandlordName("Harish Mehta");
		landlord.setMobile("9876567892");

		Landlord newLandlord = new Landlord();
		landlord.setUserId("LAN7");
		landlord.setPassword("********");
		landlord.setUsername("AABB");
		landlord.setAge(36);
		landlord.setEmail("har@123");
		landlord.setLandlordName("Harish Mehta");
		landlord.setMobile("9876567892");

		when(iLandlordRepository.findById(newLandlord.getUserId())).thenThrow(LandlordNotFoundException.class);

		assertThrows(LandlordNotFoundException.class, () -> iLandlordServiceImpl.updateLandlord(landlord));
	}

	@Test
	public void testViewLandlordById() {

		Landlord landlord = new Landlord();
		landlord.setUserId("LAN5");
		landlord.setPassword("********");
		landlord.setUsername("HARRA");
		landlord.setAge(26);
		landlord.setEmail("har@123");
		landlord.setLandlordName("Harish Mehta");
		landlord.setMobile("9876567892");

		Optional<Landlord> optionalLandlord = Optional.of(landlord);

		when(iLandlordRepository.findById("LAN5")).thenReturn(optionalLandlord);

		Landlord landlordObj = iLandlordServiceImpl.viewLandlord("LAN5");

		assertEquals("Harish Mehta", landlordObj.getLandlordName());
		assertEquals("har@123", landlordObj.getEmail());
	}

	@Test
	public void testViewLandlordByIdException() {

		when(iLandlordRepository.findById("LAN6")).thenThrow(LandlordNotFoundException.class);

		assertThrows(LandlordNotFoundException.class, () -> iLandlordServiceImpl.viewLandlord("LAN6"));
	}

	@Test
	public void testViewAllLandlord() {
		Landlord landlord = new Landlord();
		landlord.setUserId("LAN7");
		landlord.setPassword("********");
		landlord.setUsername("NIKAR");
		landlord.setAge(36);
		landlord.setEmail("nik@123");
		landlord.setLandlordName("Nikhil Parihar");
		landlord.setMobile("7889665432");

		Landlord landlord2 = new Landlord();
		landlord2.setUserId("LAN8");
		landlord2.setPassword("**********");
		landlord2.setUsername("TUSMA");
		landlord2.setAge(50);
		landlord2.setEmail("tushar@123");
		landlord2.setLandlordName("Tushar Sharma");
		landlord2.setMobile("7889665432");

		Landlord landlord3 = new Landlord();
		landlord3.setUserId("LAN9");
		landlord3.setPassword("*********");
		landlord3.setUsername("SONGAR");
		landlord3.setAge(55);
		landlord3.setEmail("sonam@123");
		landlord3.setLandlordName("Sonam Sagar");
		landlord3.setMobile("7889665432");

		List<Landlord> landlordList = new ArrayList<>();
		landlordList.add(landlord);
		landlordList.add(landlord2);
		landlordList.add(landlord3);

		when(iLandlordRepository.findAll()).thenReturn(landlordList);

		List<Landlord> landlords = iLandlordServiceImpl.viewAllLandlord();

		assertEquals(3, landlords.size());
	}

	@Test
	public void testViewAllLandlordException() {

		when(iLandlordRepository.findAll()).thenThrow(LandlordNotFoundException.class);
		assertThrows(LandlordNotFoundException.class, () -> iLandlordServiceImpl.viewAllLandlord());
	}

	@Test
	public void testDeleteLandlord() {

		Landlord landlord = new Landlord();
		landlord.setUserId("LAN6");
		landlord.setPassword("*********");
		landlord.setUsername("SHILTY");
		landlord.setAge(25);
		landlord.setEmail("shilpee@123");
		landlord.setLandlordName("Shilpee Shetty");
		landlord.setMobile("7895432765");

		Optional<Landlord> optionalLandlord = Optional.of(landlord);

		when(iLandlordRepository.findById("LAN6")).thenReturn(optionalLandlord);

		doNothing().when(iLandlordRepository).deleteById("LAN6");

		iLandlordServiceImpl.deleteLandlord("LAN6");

		verify(iLandlordRepository, times(1)).findById("LAN6");
		verify(iLandlordRepository, times(1)).findById("LAN6");
	}

	@Test
	public void testDeleteLandlordException() {

		when(iLandlordRepository.findById("LAN6")).thenThrow(LandlordNotFoundException.class);

		assertThrows(LandlordNotFoundException.class, () -> iLandlordServiceImpl.deleteLandlord("LAN6"));
	}
}
