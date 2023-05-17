package mul.cam.a.place.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.place.dao.PlaceDao;

@Service
@Transactional
public class PlaceService {

	@Autowired
	PlaceDao dao;
	
	public List<Map<String, Object>> placeReview(String location) {
		return dao.placeReview(location);
	}
}
