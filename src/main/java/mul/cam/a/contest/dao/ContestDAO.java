package mul.cam.a.contest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.contest.dto.ContestCommentDTO;
import mul.cam.a.contest.dto.ContestDTO;

@Mapper
@Repository
public interface ContestDAO {

	// 진행 중인 콘테스트와 당첨자 발표 피드 불러오기
	List<ContestDTO> getContestAndWinners();
	
	// 콘테스트 및 당첨자 발표 상세
	ContestDTO fetchData(int seq);
	
	// 콘테스트 및 당첨자 발표 등록
	int createContest(ContestDTO dto);
	
	// 콘테스트 및 당첨자 발표 수정
	int modifyContest(ContestDTO dto);
	
	// 콘테스트 및 당첨자 발표 삭제
	int contestDelete(int seq);
	
	// 특정 콘테스트 or 당첨자 발표에 작성된 댓글 리스트
	List<ContestCommentDTO> getComment(int contestSeq);
	
	// 특정 콘테스트 or 당첨자 발표에 작성된 댓글 개수
	int commentCount(int contestSeq);
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 작성
	int writeContestCmt(ContestCommentDTO dto);
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 수정
	int cmtModify(ContestCommentDTO dto);
	
	// 특정 콘테스트 or 당첨자 발표에 댓글 삭제
	int cmtDelete(int seq);
}
