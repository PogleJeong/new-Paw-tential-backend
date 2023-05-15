package mul.cam.a.contest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.contest.dto.ContestCommentDTO;
import mul.cam.a.contest.dto.ContestDTO;
import mul.cam.a.contest.service.ContestService;

@RestController
public class ContestController {
	
	@Autowired
	ContestService service;
	
	//	진행 중인 컨테스트와 당첨자 발표 피드 불러오기
	@GetMapping("/contest/getContestAndWinners")
	public Map<String, Object> getContestAndWinners() {
		Map<String, Object> map = new HashMap<>();
		map.put("contest", service.getContestAndWinners());
		System.out.println(service.getContestAndWinners());
		return map;
	}
	
	// 콘테스트 및 당첨자 발표 상세
	@GetMapping("/contest/fetchData")
	public ContestDTO fetchData(int seq) {
		System.out.println(seq);
		return service.fetchData(seq);
	}
	
	// 콘테스트 및 당첨자 발표 등록
	@PostMapping("/contest/createContest")
	public int createContest(ContestDTO dto) {
		return service.createContest(dto);
	}
	
	// 콘테스트 및 당첨자 발표 수정
	@PostMapping("/contest/modifyContest")
	public int modifyContest(ContestDTO dto) {
		return service.modifyContest(dto);
	}
	
	// 콘테스트 및 당첨자 발표 삭제
	@GetMapping("/contest/contestDelete")
	public int contestDelete(int seq) {
		return service.contestDelete(seq);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 작성된 댓글 리스트
	@GetMapping("/contest/getComment")
	public Map<String, Object> getComment(int contestSeq) {
		Map<String, Object> map = new HashMap<>();
		map.put("comment", service.getComment(contestSeq));
		return map; 
	}
	
	// 특정 콘테스트 or 당첨자 발표에 작성된 댓글 개수
	@GetMapping("/contest/commentCount")
	public int commentCount(int contestSeq) {
		return service.commentCount(contestSeq);
	}
	
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 작성
	@PostMapping("/contest/writeContestCmt")
	public int writeContestCmt(ContestCommentDTO dto) {
		return service.writeContestCmt(dto);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 수정
	@PostMapping("/contest/cmtModify")
	public int cmtModify(ContestCommentDTO dto) {
		return service.cmtModify(dto);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 삭제
	@GetMapping("/contest/cmtDelete")
	public int cmtDelete(int seq) {
		return service.cmtDelete(seq);
	}
	
	

}
