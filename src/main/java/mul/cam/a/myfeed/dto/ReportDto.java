package mul.cam.a.myfeed.dto;


public class ReportDto {

	private int seq;
	private String reporter;
	private String reported;
	private String content;
	private String rtype;
	private String rdate;
	private String type;
	private int feed_seq;
	private int market_seq;
	
	
	public ReportDto() {
		
	}
	
	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public String getReporter() {
		return reporter;
	}



	public void setReporter(String reporter) {
		this.reporter = reporter;
	}



	public String getReported() {
		return reported;
	}



	public void setReported(String reported) {
		this.reported = reported;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getRtype() {
		return rtype;
	}



	public void setRtype(String rtype) {
		this.rtype = rtype;
	}



	public String getRdate() {
		return rdate;
	}



	public void setRdate(String rdate) {
		this.rdate = rdate;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getFeed_seq() {
		return feed_seq;
	}



	public void setFeed_seq(int feed_seq) {
		this.feed_seq = feed_seq;
	}



	public int getMarket_seq() {
		return market_seq;
	}



	public void setMarket_seq(int market_seq) {
		this.market_seq = market_seq;
	}


	

	public ReportDto(int seq, String reporter, String reported, String content, String rtype, String rdate, String type,
			int feed_seq, int market_seq) {
		super();
		this.seq = seq;
		this.reporter = reporter;
		this.reported = reported;
		this.content = content;
		this.rtype = rtype;
		this.rdate = rdate;
		this.type = type;
		this.feed_seq = feed_seq;
		this.market_seq = market_seq;
	}



	@Override
	public String toString() {
		return "ReportDto [seq=" + seq + ", reporter=" + reporter + ", reported=" + reported + ", content=" + content
				+ ", rtype=" + rtype + ", rdate=" + rdate + ", type=" + type + ", feed_seq=" + feed_seq
				+ ", market_seq=" + market_seq + "]";
	}
	
	

}
