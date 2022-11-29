package com.location_web_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location_web_app.entities.Location;
import com.location_web_app.repositories.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController {

	@Autowired
	private LocationRepository locationRepo;
	
	@GetMapping
	public List<Location> getLocations(){
		return locationRepo.findAll();
	}
	
	@PostMapping
	public Location saveLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") Long id) {
		locationRepo.deleteById(id);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}
	
	@GetMapping("/{id}")
	public Location getLocationById(@PathVariable("id") Long id) {
		Optional<Location> findById = locationRepo.findById(id);
		Location location = findById.get();
		return location;
	}
}
