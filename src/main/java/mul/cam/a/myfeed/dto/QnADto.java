package mul.cam.a.myfeed.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QnADto{
	private int seq;
    private String id;
    private String content;
    private String email;
    private String wdate;
    private int whether;
}