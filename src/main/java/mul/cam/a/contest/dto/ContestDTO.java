package mul.cam.a.contest.dto;

import java.io.Serializable;

public class ContestDTO implements Serializable {

	private int seq;
	private String category, id, name, startDt, endDt, writeDt, content;
	
	public ContestDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContestDTO(int seq, String category, String id, String name, String startDt, String endDt, String writeDt,
			String content) {
		super();
		this.seq = seq;
		this.category = category;
		this.id = id;
		this.name = name;
		this.startDt = startDt;
		this.endDt = endDt;
		this.writeDt = writeDt;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getWriteDt() {
		return writeDt;
	}

	public void setWriteDt(String writeDt) {
		this.writeDt = writeDt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ContestDTO [seq=" + seq + ", category=" + category + ", id=" + id + ", name=" + name + ", startDt="
				+ startDt + ", endDt=" + endDt + ", writeDt=" + writeDt + ", content=" + content + "]";
	}
	
}
