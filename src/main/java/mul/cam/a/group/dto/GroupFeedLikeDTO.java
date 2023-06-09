package mul.cam.a.group.dto;

import java.io.Serializable;

public class GroupFeedLikeDTO implements Serializable {
	private int grpFeedNo;
	private String grpFeedLikeId, nickname;
	
	public GroupFeedLikeDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupFeedLikeDTO(int grpFeedNo, String grpFeedLikeId, String nickname) {
		super();
		this.grpFeedNo = grpFeedNo;
		this.grpFeedLikeId = grpFeedLikeId;
		this.nickname = nickname;
	}

	public int getGrpFeedNo() {
		return grpFeedNo;
	}

	public void setGrpFeedNo(int grpFeedNo) {
		this.grpFeedNo = grpFeedNo;
	}

	public String getGrpFeedLikeId() {
		return grpFeedLikeId;
	}

	public void setGrpFeedLikeId(String grpFeedLikeId) {
		this.grpFeedLikeId = grpFeedLikeId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "GroupFeedLikeDTO [grpFeedNo=" + grpFeedNo + ", grpFeedLikeId=" + grpFeedLikeId + ", nickname="
				+ nickname + "]";
	}
	

}
