package mul.cam.a.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.admin.dto.PageParam;

import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.myfeed.dto.QnADto;
import mul.cam.a.myfeed.dto.ReportDto;

@Mapper
@Repository
public interface AdminDao {
	// 로그인 유저 정보
	MemberDto userInfo(String id);
	
	// 회원 관리
	List<MemberDto> userList(PageParam param);
	
	int getAllUser(PageParam param);
	
	int userDel(String id);
	
	// 신고 관리
	
	List<ReportDto> reportList(PageParam param);
	
	int getAllReport(PageParam param);
	
	// 문의 관리
	
	List<QnADto> QnAList(PageParam param);
	
	int getAllQnA(PageParam param);
	
	int answer(int seq);
	
	List<Map<String, Object>> petChart();
	
	List<Map<String, Object>> UserChart();

	List<Map<String, Object>> regiChart();


}
