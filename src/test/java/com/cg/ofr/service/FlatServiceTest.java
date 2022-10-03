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

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;

@SpringBootTest
 class FlatServiceTest {

	@InjectMocks
	IFlatServiceImpl iFlatServiceImpl = new IFlatServiceImpl();

	@Mock
	IFlatRepository iFlatRepository;

	@Test
	 void testViewAllFlatException() {

		when(iFlatRepository.findAll()).thenThrow(FlatNotFoundException.class);

		assertThrows(FlatNotFoundException.class, () -> iFlatServiceImpl.viewAllFlat());

	}

	@Test
	 void testViewAllFlat() {

		Flat flat = new Flat();
		flat.setFlatId(1);
		flat.setFlatType("2-bhk");
		flat.setCost(45000);
		flat.setAvailability("available");

		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId(1);
		flatAddress.setCity("nashik");
		flatAddress.setBuilding("primaryTower");
		flatAddress.setCountry("India");
		flatAddress.setState("maharashtra");
		flatAddress.setStreet("5");
		flatAddress.setHouseNo(67);
		flat.setFlatAddress(flatAddress);

		Landlord landlord = new Landlord();
		landlord.setUserId(1);
		landlord.setPassword("********");
		landlord.setUsername("LAND");
		landlord.setAge(35);
		landlord.setEmail("Hrushi@123");
		landlord.setUsername("Hrushi");
		landlord.setMobile("1234567891");

		Flat flat2 = new Flat();
		flat2.setFlatId(2);
		flat2.setFlatType("3-bhk");
		flat2.setCost(35000);
		flat2.setAvailability("available");

		FlatAddress flatAddress2 = new FlatAddress();
		flatAddress2.setAddressId(2);
		flatAddress2.setCity("Nanded");
		flatAddress2.setBuilding("primaryTower");
		flatAddress2.setCountry("India");
		flatAddress2.setState("maharashtra");
		flatAddress2.setStreet("4");
		flatAddress2.setHouseNo(68);

		Landlord landlord2 = new Landlord();
		landlord2.setUserId(2);
		landlord2.setPassword("********");
		landlord2.setUsername("LAND");
		landlord2.setAge(35);
		landlord2.setEmail("ram@123");

		landlord2.setUsername("Ram");
		landlord2.setMobile("1234567891");

		Flat flat3 = new Flat();
		flat3.setFlatId(3);
		flat3.setFlatType("3-bhk");
		flat3.setCost(65000);
		flat3.setAvailability("available");

		FlatAddress flatAddress3 = new FlatAddress();
		flatAddress3.setAddressId(3);
		flatAddress3.setCity("mumbai");
		flatAddress3.setBuilding("primaryTower");
		flatAddress3.setCountry("India");
		flatAddress3.setState("maharashtra");
		flatAddress3.setStreet("5");
		flatAddress3.setHouseNo(67);

		Landlord landlord3 = new Landlord();
		landlord3.setUserId(3);
		landlord3.setPassword("********");
		landlord3.setUsername("LAND");
		landlord3.setAge(35);
		landlord3.setEmail("krish@123");

		landlord3.setUsername("krish");
		landlord3.setMobile("1234567891");

		List<Flat> flatList = new ArrayList<>();
		flatList.add(flat3);
		flatList.add(flat2);
		flatList.add(flat);

		when(iFlatRepository.findAll()).thenReturn(flatList);

		List<Flat> flats = iFlatServiceImpl.viewAllFlat();

		assertEquals(3, flats.size());
	}

	@Test
	 void testAddFlat() {
		Flat flat = new Flat();
		flat.setFlatId(1);
		flat.setFlatType("2-bhk");
		flat.setCost(45000);
		flat.setAvailability("available");

		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId(1);
		flatAddress.setCity("nashik");
		flatAddress.setBuilding("primaryTower");
		flatAddress.setCountry("India");
		flatAddress.setState("maharashtra");
		flatAddress.setStreet("5");
		flatAddress.setHouseNo(67);
		flat.setFlatAddress(flatAddress);

		Landlord landlord = new Landlord();
		landlord.setUserId(1);
		landlord.setPassword("********");
		landlord.setUsername("LAND");
		landlord.setAge(35);
		landlord.setEmail("Hrushi@123");

		landlord.setUsername("Hrushi");
		landlord.setMobile("1234567891");

		when(iFlatRepository.save(ArgumentMatchers.any(Flat.class))).thenReturn(flat);
		Flat updatedFlat = iFlatServiceImpl.addFlat(flat);

		assertEquals(45000, updatedFlat.getCost());
		verify(iFlatRepository).save(flat);

	}

	@Test
	 void testViewFlat() {

		Flat flat = new Flat();
		flat.setFlatId(1);
		flat.setAvailability("Available");
		flat.setCost(98000);
		flat.setFlatType("5BHK");

		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId(1);
		flatAddress.setBuilding("ABCTower");
		flatAddress.setCity("Amritsar");
		flatAddress.setCountry("India");
		flatAddress.setHouseNo(86);
		flatAddress.setPincode(143001);
		flatAddress.setState("Punjab");
		flatAddress.setStreet("5");

		flat.setFlatAddress(flatAddress);

		Landlord landlord = new Landlord();
		landlord.setLandlordName("Raj");
		landlord.setAge(35);
		landlord.setEmail("raj@123");
		landlord.setUsername("RAAJ");
		landlord.setMobile("9876543210");
		landlord.setPassword("*****");
		landlord.setUserId(1);

		flat.setLandlord(landlord);

		Optional<Flat> optionalFlat = Optional.of(flat);

		when(iFlatRepository.findById(1)).thenReturn(optionalFlat);

		Flat flatObj = iFlatServiceImpl.viewFlat(1);
		assertEquals(1, flatObj.getFlatId());

	}

	@Test
	 void testViewFlatByIdException() {

		when(iFlatRepository.findById(1)).thenThrow(FlatNotFoundException.class);

		assertThrows(FlatNotFoundException.class, () -> iFlatServiceImpl.viewFlat(1));
	}
//
//	@Test
//	 void testViewAllFlatByCost() {
//
//		Flat flat = new Flat();
//		flat.setFlatId(1);
//		flat.setAvailability("Available");
//		flat.setCost(38000);
//		flat.setFlatType("5BHK");
//
//		FlatAddress flatAddress = new FlatAddress();
//		flatAddress.setAddressId(1);
//		flatAddress.setBuilding("ABCTower");
//		flatAddress.setCity("Amritsar");
//		flatAddress.setCountry("India");
//		flatAddress.setHouseNo(86);
//		flatAddress.setPincode(143001);
//		flatAddress.setState("Punjab");
//		flatAddress.setStreet("5");
//
//		flat.setFlatAddress(flatAddress);
//
//		Landlord landlord = new Landlord();
//		landlord.setLandlordName("Raj");
//		landlord.setAge(35);
//		landlord.setEmail("raj@123");
//		landlord.setUsername("RAAJ");
//		landlord.setMobile("9876543210");
//		landlord.setPassword("*****");
//		landlord.setUserId(1);
//
//		flat.setLandlord(landlord);
//
//		Flat flat2 = new Flat();
//		flat2.setFlatId(2);
//		flat2.setAvailability("Available");
//		flat2.setCost(38000);
//		flat2.setFlatType("2BHK");
//
//		FlatAddress flatAddress2 = new FlatAddress();
//		flatAddress2.setAddressId(2);
//		flatAddress2.setBuilding("XYZTower");
//		flatAddress2.setCity("Pune");
//		flatAddress2.setCountry("India");
//		flatAddress2.setHouseNo(36);
//		flatAddress2.setPincode(431001);
//		flatAddress2.setState("Maharashtra");
//		flatAddress2.setStreet("5");
//
//		flat.setFlatAddress(flatAddress);
//
//		Landlord landlord2 = new Landlord();
//		landlord2.setLandlordName("Raj");
//		landlord2.setAge(35);
//		landlord2.setEmail("raj@123");
//		landlord2.setUsername("RAAJ");
//		landlord2.setMobile("9876543210");
//		landlord2.setPassword("*****");
//		landlord2.setUserId(1);
//
//		flat.setLandlord(landlord2);
//
//		List<Flat> flatList = new ArrayList<>();
//		flatList.add(flat2);
//		flatList.add(flat);
//
//		when(iFlatRepository.findByCostAndAvailability(38000, "Available")).thenReturn(flatList);
//
//		List<Flat> flats = iFlatServiceImpl.viewAllFlatByCost(38000, "Available");
//
//		assertEquals(2, flats.size());
//	}

//	@Test
//	 void testViewAllFlatByCostException() {
//
//		when(iFlatRepository.findByCostAndAvailability(38000, "Available")).thenThrow(FlatNotFoundException.class);
//
//		assertThrows(FlatNotFoundException.class, () -> iFlatServiceImpl.viewAllFlatByCost(38000, "Available"));
//	}

	@Test
	 void testDeleteFlat() {
		Flat flat = new Flat();
		flat.setFlatId(1);
		flat.setAvailability("Available");
		flat.setCost(98000);
		flat.setFlatType("5BHK");

		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId(1);
		flatAddress.setBuilding("ABCTower");
		flatAddress.setCity("Amritsar");
		flatAddress.setCountry("India");
		flatAddress.setHouseNo(86);
		flatAddress.setPincode(143001);
		flatAddress.setState("Punjab");
		flatAddress.setStreet("5");

		flat.setFlatAddress(flatAddress);

		Optional<Flat> optionalFlat = Optional.of(flat);
		when(iFlatRepository.findById(1)).thenReturn(optionalFlat);

		doNothing().when(iFlatRepository).deleteById(1);

		iFlatServiceImpl.deleteFlat(1);

		verify(iFlatRepository, times(1)).findById(1);
		verify(iFlatRepository, times(1)).deleteById(1);
	}

	@Test
	 void testDeleteFlatByIdException() {

		when(iFlatRepository.findById(1)).thenThrow(FlatNotFoundException.class);

		assertThrows(FlatNotFoundException.class, () -> iFlatServiceImpl.viewFlat(1));
	}

	@Test
	void testupdateFlat() {
		Flat flat = new Flat();
		flat.setFlatId(1);
		flat.setAvailability("Available");
		flat.setCost(98000);
		flat.setFlatType("5BHK");

		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId(1);
		flatAddress.setBuilding("ABCTower");
		flatAddress.setCity("Amritsar");
		flatAddress.setCountry("India");
		flatAddress.setHouseNo(86);
		flatAddress.setPincode(143001);
		flatAddress.setState("Punjab");
		flatAddress.setStreet("5");
		flat.setFlatAddress(flatAddress);

		Landlord landlord = new Landlord();
		landlord.setLandlordName("Raj");
		landlord.setAge(35);
		landlord.setEmail("raj@123");
		landlord.setUsername("RAAJ");
		landlord.setMobile("9876543210");
		landlord.setPassword("*****");
		landlord.setUserId(1);

		flat.setLandlord(landlord);

		Optional<Flat> optionalFlat = Optional.of(flat);
		Flat flat1 = new Flat();
		flat1.setFlatId(1);
		flat1.setAvailability("Available");
		flat1.setCost(68000);
		flat1.setFlatType("5BHK");

		FlatAddress flatAddress1 = new FlatAddress();
		flatAddress1.setAddressId(1);
		flatAddress1.setBuilding("ABCTower");
		flatAddress1.setCity("Amritsar");
		flatAddress1.setCountry("India");
		flatAddress1.setHouseNo(86);
		flatAddress1.setPincode(143001);
		flatAddress1.setState("Punjab");
		flatAddress1.setStreet("5");

		Landlord landlord1 = new Landlord();
		landlord1.setLandlordName("Raj");
		landlord1.setAge(35);
		landlord1.setEmail("raj@123");
		landlord1.setUsername("RAAJ");
		landlord1.setMobile("9876543210");
		landlord1.setPassword("*****");
		landlord1.setUserId(1);

		flat1.setLandlord(landlord1);

		when(iFlatRepository.findById(flat1.getFlatId())).thenReturn(optionalFlat);
		when(iFlatRepository.save(flat1)).thenReturn(flat1);
		Flat updatedFlat = iFlatServiceImpl.updateFlat(flat1);
		assertEquals(flat1, updatedFlat);
	}

	@Test
	 void testUpdateFlatException() {
		Flat flat = new Flat();
		flat.setFlatId(1);
		flat.setAvailability("Available");
		flat.setCost(98000);
		flat.setFlatType("5BHK");

		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId(1);
		flatAddress.setBuilding("ABCTower");
		flatAddress.setCity("Amritsar");
		flatAddress.setCountry("India");
		flatAddress.setHouseNo(86);
		flatAddress.setPincode(143001);
		flatAddress.setState("Punjab");
		flatAddress.setStreet("5");
		flat.setFlatAddress(flatAddress);

		Landlord landlord = new Landlord();
		landlord.setLandlordName("Raj");
		landlord.setAge(35);
		landlord.setEmail("raj@123");
		landlord.setUsername("RAAJ");
		landlord.setMobile("9876543210");
		landlord.setPassword("*****");
		landlord.setUserId(1);

		flat.setLandlord(landlord);

		Flat flat1 = new Flat();
		flat1.setFlatId(1);
		flat1.setAvailability("Available");
		flat1.setCost(68000);
		flat1.setFlatType("5BHK");

		FlatAddress flatAddress1 = new FlatAddress();
		flatAddress1.setAddressId(1);
		flatAddress1.setBuilding("ABCTower");
		flatAddress1.setCity("Amritsar");
		flatAddress1.setCountry("India");
		flatAddress1.setHouseNo(86);
		flatAddress1.setPincode(143001);
		flatAddress1.setState("Punjab");
		flatAddress1.setStreet("5");

		Landlord landlord1 = new Landlord();
		landlord1.setLandlordName("Raj");
		landlord1.setAge(35);
		landlord1.setEmail("raj@123");
		landlord1.setUsername("RAAJ");
		landlord1.setMobile("9876543210");
		landlord1.setPassword("*****");
		landlord1.setUserId(1);

		flat1.setLandlord(landlord1);

		when(iFlatRepository.findById(flat1.getFlatId())).thenThrow(FlatNotFoundException.class);
		assertThrows(FlatNotFoundException.class, () -> iFlatServiceImpl.updateFlat(flat));
	}

}      


