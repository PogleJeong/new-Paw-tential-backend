package mul.cam.a.myfeed.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.admin.dto.PageParam;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.myfeed.dto.FollowDto;
import mul.cam.a.myfeed.dto.QnADto;
import mul.cam.a.myfeed.dto.ReportDto;
import mul.cam.a.pet.dto.PetDto;

@Mapper
@Repository
public interface MyfeedDao {
	
	MemberDto userInfo(String id);
	
	String ProfilePicture(String id);
	
	List<FeedDto> getMyFeed(String id);
	
	List<FeedDto> getBookmark(String id);
	
	int getFollower(String id);

	int getFollowing(String id);
	
	int follow(FollowDto dto);
	
	int unfollow(FollowDto dto);

	List<String> followerList (String id);
	
	List<String> followingList (String id);
	
	int isFollowing(String follower_id, String following_id);

	List<MemberDto> searchMember(PageParam param);
	
	int editMember (MemberDto dto);
	
	int sendQnA (QnADto dto);

	int sendReport (ReportDto dto);
	
	List<Map<String, Object>> petList(String id);


}