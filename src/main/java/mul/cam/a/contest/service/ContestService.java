package mul.cam.a.contest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.contest.dao.ContestDAO;
import mul.cam.a.contest.dto.ContestCommentDTO;
import mul.cam.a.contest.dto.ContestDTO;

@Service
@Transactional
public class ContestService {
	
	@Autowired
	ContestDAO dao;
	
	// 진행 중인 콘테스트와 당첨자 발표 피드 불러오기
	public List<ContestDTO> getContestAndWinners() {
		return dao.getContestAndWinners();
	}
	
	// 콘테스트 및 당첨자 발표 상세
	public ContestDTO fetchData(int seq) {
		return dao.fetchData(seq);
	}
	
	// 콘테스트 작성
	public int createContest(ContestDTO dto) {
		return dao.createContest(dto);		
	}
	
	// 콘테스트 및 당첨자 발표 수정
	public int modifyContest(ContestDTO dto) {
		return dao.modifyContest(dto);
	}
	
	// 콘테스트 및 당첨자 발표 삭제
	public int contestDelete(int seq) {
		return dao.contestDelete(seq);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 작성된 댓글 리스트
	public List<ContestCommentDTO> getComment(int contestSeq) {
		return dao.getComment(contestSeq);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 작성된 댓글 개수
	public int commentCount(int contestSeq) {
		return dao.commentCount(contestSeq);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 작성
	public int writeContestCmt(ContestCommentDTO dto) {
		return dao.writeContestCmt(dto);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 수정
	public int cmtModify(ContestCommentDTO dto) {
		return dao.cmtModify(dto);
	}
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 삭제
	public int cmtDelete(int seq) {
		return dao.cmtDelete(seq);
	}
	
}
