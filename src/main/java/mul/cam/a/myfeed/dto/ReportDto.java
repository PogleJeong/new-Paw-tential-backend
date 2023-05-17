package mul.cam.a.myfeed.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportDto {

	private int seq;
	private String reporter;
	private String reported;
	private String content;
	private String rtype;
	private String rdate;
	private int type;

}
