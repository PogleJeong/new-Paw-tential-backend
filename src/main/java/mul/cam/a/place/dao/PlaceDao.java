package mul.cam.a.place.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlaceDao {
	
	List<Map<String, Object>> placeReview(String location);

}
