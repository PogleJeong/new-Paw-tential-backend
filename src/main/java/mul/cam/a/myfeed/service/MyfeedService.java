package mul.cam.a.myfeed.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.admin.dto.PageParam;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.myfeed.dao.MyfeedDao;
import mul.cam.a.myfeed.dto.FollowDto;
import mul.cam.a.myfeed.dto.QnADto;
import mul.cam.a.myfeed.dto.ReportDto;

@Service
@Transactional
public class MyfeedService {
	
	@Autowired
	MyfeedDao dao;
	
	public String ProfilePicture(String id) {
		return dao.ProfilePicture(id);
	}
	
	public List<FeedDto> Myfeed(String id) {
		return dao.getMyFeed(id);
	}
	
	public List<FeedDto> getBookmark(String id) {
		return dao.getBookmark(id);
	}
	
	public int getFollower (String id) {
		return dao.getFollower(id);
	}
	
	public int getFollowing (String id) {
		return dao.getFollowing(id);
	}
	
	public boolean follow (FollowDto dto) {
		int n = dao.follow(dto);
		return n>0?true:false;
	}
	
	public boolean unfollow (FollowDto dto) {
		int n = dao.unfollow(dto);
		return n>0?true:false;
	}
	

	public List<String> followerList(String id) {
		return dao.followerList(id);
	}
	
	public List<String> followingList(String id) {
		return dao.followingList(id);
	}
	
	public boolean isFollowing(String follower_id, String following_id) {
		int n =  dao.isFollowing(follower_id, following_id);
		return n>0?true:false;
	}
	
	public List<MemberDto> searchMember(PageParam param){
		return dao.searchMember(param);
	}
	
	public boolean editMember(MemberDto dto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("변환전 >> " + dto.getPwd());
		String encordedPassword = passwordEncoder.encode(dto.getPwd());
		dto.setPwd(encordedPassword);
		System.out.println("변환후 >> " + dto.getPwd());
		int n =  dao.editMember(dto);

		return n>0?true:false;
	}
	
	public boolean sendQnA(QnADto dto) {
		
		int n =  dao.sendQnA(dto);

		return n>0?true:false;
	}
	
	public boolean sendReport(ReportDto dto) {
		
		int n =  dao.sendReport(dto);

		return n>0?true:false;
	}
	
	public List<Map<String, Object>> petList(String id) {
		return dao.petList(id);
	}
}