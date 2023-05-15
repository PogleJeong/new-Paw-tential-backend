package mul.cam.a.contest.dto;

import java.io.Serializable;

public class ContestCommentDTO implements Serializable {
	
	private int seq, contestSeq;
	private String id, content, writeDt, profile;
	
	public ContestCommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContestCommentDTO(int seq, int contestSeq, String id, String content, String writeDt, String profile) {
		super();
		this.seq = seq;
		this.contestSeq = contestSeq;
		this.id = id;
		this.content = content;
		this.writeDt = writeDt;
		this.profile = profile;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getContestSeq() {
		return contestSeq;
	}

	public void setContestSeq(int contestSeq) {
		this.contestSeq = contestSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDt() {
		return writeDt;
	}

	public void setWriteDt(String writeDt) {
		this.writeDt = writeDt;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "ContestCommentDTO [seq=" + seq + ", contestSeq=" + contestSeq + ", id=" + id + ", content=" + content
				+ ", writeDt=" + writeDt + ", profile=" + profile + "]";
	}
	
}
