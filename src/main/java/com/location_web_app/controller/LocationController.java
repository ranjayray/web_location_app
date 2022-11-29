package com.location_web_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location_web_app.entities.Location;
import com.location_web_app.repositories.LocationRepository;
import com.location_web_app.util.EmailUtil;

@Controller
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepo;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/showLocation")
	public String showLocation() {
		return "showLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLoc(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationRepo.save(location);
		emailUtil.sendEmail("democlass151921@gmail.com", "TestEmail", "Record is saved");
		modelMap.addAttribute("msg", "Location Saved!!");
		return "showLocation";
	}
	
//	@RequestMapping("/saveLoc")
//	public String saveLoc(@RequestParam("id") long id, @RequestParam("code") String code, @RequestParam("name") String name,@RequestParam("type") String type, ModelMap modelMap) {
//		Location location = new Location();
//		location.setId(id);
//		location.setCode(code);
//		location.setName(name);
//		location.setType(type);
//		locationRepo.save(location);
//		modelMap.addAttribute("msg", "Location Saved!!");
//		return "showLocation";
//	}
	
	@RequestMapping("/getLocations")
	public String getLocations(ModelMap modelMap) {
		List<Location> locations = locationRepo.findAll();
		modelMap.addAttribute("locations", locations);
		return "getLocations";
	}
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") Long id, ModelMap modelMap) {
		locationRepo.deleteById(id);
		List<Location> locations = locationRepo.findAll();
		modelMap.addAttribute("locations", locations);
		return "getLocations";
	}
	@RequestMapping("/updateLocation")
	public String updateLocation(@RequestParam("id") Long id, ModelMap modelMap) {
		Optional<Location> findById = locationRepo.findById(id);
		Location location = findById.get();
		modelMap.addAttribute("id", location.getId());
		modelMap.addAttribute("code", location.getCode());
		modelMap.addAttribute("name", location.getName());
		modelMap.addAttribute("type", location.getType());
		return "updateTheLocation";
	}
	
	@RequestMapping("/updateLocationData")
	public String updateLocationData(@ModelAttribute("location") Location location, ModelMap modelMap) {
		location.setCode(location.getCode());
		location.setName(location.getName());
		location.setType(location.getType());
		locationRepo.save(location);
		modelMap.addAttribute("updatedMsg", "Location record is updated");
		return "updateTheLocation";
	}
}
