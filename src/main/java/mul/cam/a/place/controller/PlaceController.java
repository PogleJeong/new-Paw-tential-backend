package mul.cam.a.place.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.place.service.PlaceService;

@RestController
public class PlaceController {

	@Autowired
	PlaceService service;

	@GetMapping(value = "/placeReview")
	public List<Map<String, Object>> placeReview(String location) {
		System.out.println("PlaceController placeReview()" + new Date());
		
		return service.placeReview(location);
	}
	
}
