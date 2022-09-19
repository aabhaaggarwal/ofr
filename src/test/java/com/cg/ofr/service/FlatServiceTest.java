package com.cg.ofr.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.cg.ofr.service.IFlatServiceImpl;

@SpringBootTest
public class FlatServiceTest {
	
	@InjectMocks
	IFlatServiceImpl iFlatServiceImpl = new IFlatServiceImpl();
	
	@Mock
	IFlatRepository iFlatRepository;
	
	
	@Test
	public void testViewAllFlatException() {
		
		when(iFlatRepository.findAll()).thenThrow(FlatNotFoundException.class);
		
		assertThrows(FlatNotFoundException.class,()->iFlatServiceImpl.viewAllFlat());
		
	}
	

	@Test
	public void testViewAllFlat() {
		
		Flat flat = new Flat();
        flat.setFlatId("FLA5");
        flat.setFlatType("2-bhk");
        flat.setCost(45000);
        flat.setAvailability("available");
        
        FlatAddress flatAddress=new FlatAddress();
        flatAddress.setAddressId("FAD1");
		flatAddress.setCity("nashik");
		flatAddress.setBuilding("primaryTower");
		flatAddress.setCountry("India");
		flatAddress.setState("maharashtra");
		flatAddress.setStreet("5");
		flatAddress.setHouseNo(67);
		flat.setFlatAddress(flatAddress);
		
		Landlord landlord=new Landlord();
		landlord.setUserId("LAN1");
		landlord.setPassword("********");
		landlord.setUsername("LAND");
		landlord.setAge(35);
		landlord.setEmail("Hrushi@123");
		landlord.setGender("male");
		landlord.setUsername("Hrushi");
		landlord.setMobile("1234567891");
		landlord.setPermanentAddr("pune");
        
        
        Flat flat2 = new Flat();
        flat2.setFlatId("FLA2");
        flat2.setFlatType("3-bhk");
        flat2.setCost(35000);
        flat2.setAvailability("available");
        
        FlatAddress flatAddress2=new FlatAddress();
        flatAddress2.setAddressId("FAD2");
		flatAddress2.setCity("Nanded");
		flatAddress2.setBuilding("primaryTower");
		flatAddress2.setCountry("India");
		flatAddress2.setState("maharashtra");
		flatAddress2.setStreet("4");
		flatAddress2.setHouseNo(68);
        
		Landlord landlord2=new Landlord();
		landlord2.setUserId("LAN2");
		landlord2.setPassword("********");
		landlord2.setUsername("LAND");
		landlord2.setAge(35);
		landlord2.setEmail("ram@123");
		landlord2.setGender("male");
		landlord2.setUsername("Ram");
		landlord2.setMobile("1234567891");
		landlord2.setPermanentAddr("parbhani");
        
        Flat flat3 = new Flat();
        flat3.setFlatId("FLA3");
        flat3.setFlatType("3-bhk");
        flat3.setCost(65000);
        flat3.setAvailability("available");
        
        FlatAddress flatAddress3=new FlatAddress();
        flatAddress3.setAddressId("FAD3");
		flatAddress3.setCity("mumbai");
		flatAddress3.setBuilding("primaryTower");
		flatAddress3.setCountry("India");
		flatAddress3.setState("maharashtra");
		flatAddress3.setStreet("5");
		flatAddress3.setHouseNo(67);
	
        
        Landlord landlord3=new Landlord();
		landlord3.setUserId("LAN3");
		landlord3.setPassword("********");
		landlord3.setUsername("LAND");
		landlord3.setAge(35);
		landlord3.setEmail("krish@123");
		landlord3.setGender("male");
		landlord3.setUsername("krish");
		landlord3.setMobile("1234567891");
		landlord3.setPermanentAddr("nashik");
        
        List<Flat> flatList = new ArrayList<>();
        flatList.add(flat3);
        flatList.add(flat2);
        flatList.add(flat);

        when(iFlatRepository.findAll()).thenReturn(flatList);

        List<Flat> flats = iFlatServiceImpl.viewAllFlat();

        assertEquals(3, flats.size());
	}	
	
	@Test
	public void testAddFlat() {
		Flat flat = new Flat();
		flat.setFlatId("FLA5");
        flat.setFlatType("2-bhk");
        flat.setCost(45000);
        flat.setAvailability("available");
        
        FlatAddress flatAddress=new FlatAddress();
        flatAddress.setAddressId("FAD1");
		flatAddress.setCity("nashik");
		flatAddress.setBuilding("primaryTower");
		flatAddress.setCountry("India");
		flatAddress.setState("maharashtra");
		flatAddress.setStreet("5");
		flatAddress.setHouseNo(67);
		flat.setFlatAddress(flatAddress);
		
		Landlord landlord=new Landlord();
		landlord.setUserId("LAN1");
		landlord.setPassword("********");
		landlord.setUsername("LAND");
		landlord.setAge(35);
		landlord.setEmail("Hrushi@123");
		landlord.setGender("male");
		landlord.setUsername("Hrushi");
		landlord.setMobile("1234567891");
		landlord.setPermanentAddr("pune");
		
		when(iFlatRepository.save(ArgumentMatchers.any(Flat.class))).thenReturn(flat);
		Flat updatedFlat = iFlatServiceImpl.addFlat(flat);

        assertEquals(45000,updatedFlat.getCost());
        verify(iFlatRepository).save(flat);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}       


