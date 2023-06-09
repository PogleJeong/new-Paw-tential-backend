package mul.cam.a.admin.conroller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.admin.dto.PageParam;

import mul.cam.a.admin.service.AdminService;
import mul.cam.a.market.dto.MarketDto;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.myfeed.dto.QnADto;
import mul.cam.a.myfeed.dto.ReportDto;

@RestController
public class AdminController {
	
	@Autowired
	AdminService service;
	
	// 관리자 정보
	@GetMapping(value = "userInfo")
	public MemberDto userInfo(String id) {
		System.out.println("AdminController userInfo " + new Date());
		
		return service.userInfo(id);
		

	}
	
	// 회원 목록
	@GetMapping(value = "userList")
		public Map<String, Object> userList(PageParam param){
			System.out.println("회원 관리 진입 " + new Date());
			
			int pn = param.getPageNumber();  // 0 1 2 3 4
			int start = 1 + (pn * 10);	// 1  11
			int end = (pn + 1) * 10;	// 10 20 
			
			param.setStart(start);
			param.setEnd(end);
			
			List<MemberDto> list = service.userList(param);
			int len = service.getAllUser(param);
			
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("cnt", len);
			

			return map;		
	}
	
	// 회원 삭제
	@GetMapping(value = "userDel")
	public String userDel(String id) {
		boolean b = service.userDel(id);
		
		if(b == false) {
			return "NO";
			
		} 
		return "YES";
	}
	
	// 신고 목록
		@GetMapping(value = "reportList")
			public Map<String, Object> reportList(PageParam param){
				System.out.println("신고 관리 진입 " + new Date());
				
				int pn = param.getPageNumber();  // 0 1 2 3 4
				int start = 1 + (pn * 10);	// 1  11
				int end = (pn + 1) * 10;	// 10 20 
				
				param.setStart(start);
				param.setEnd(end);
				
				List<Map<String, Object>> list = service.reportList(param);
				int len = service.getAllReport(param);
				
				
				Map<String, Object> map = new HashMap<>();
				map.put("list", list);
				map.put("cnt", len);
				

				return map;
		}
		
		// 문의 목록
		@GetMapping(value = "QnAList")
			public Map<String, Object> QnAList(PageParam param){
				System.out.println("문의 관리 진입 " + new Date());
				
				int pn = param.getPageNumber();  // 0 1 2 3 4
				int start = 1 + (pn * 10);	// 1  11
				int end = (pn + 1) * 10;	// 10 20 
				
				param.setStart(start);
				param.setEnd(end);
				
				List<QnADto> list = service.QnAList(param);
				int len = service.getAllQnA(param);
				
				
				Map<String, Object> map = new HashMap<>();
				map.put("list", list);
				map.put("cnt", len);
				

				return map;
		}
	
		@PostMapping(value = "answer")
		public String answer(int seq) {
			System.out.println("문의 답변 " + new Date());
			
			boolean b = service.answer(seq);
			if(b == false) {
				return "NO";
			}
			return "YES";
		}
		
		
		@GetMapping(value = "petChart")
		public List<Map<String, Object>> petChart() {
			System.out.println("펫 차트 " + new Date());
			System.out.println(service.petChart());

			
			return service.petChart();
		}
		
		@GetMapping(value = "userChart")
		public List<Map<String, Object>> userChart() {
			System.out.println("유저 차트 " + new Date());
			System.out.println(service.UserChart());

			
			return service.UserChart();
		}
		
		@GetMapping(value = "regiChart")
		public List<Map<String, Object>> regiChart() {
			System.out.println("날짜 별 가입 차트 " + new Date());
			System.out.println(service.regiChart());

			
			return service.regiChart();
		}
		
		@GetMapping(value = "marketDetail")
		public Map<String, Object> marketDetail(int seq, HttpServletRequest req) {
			System.out.println("마켓 정보 가져오기 " + new Date());
			MarketDto marketInfo = service.marketDetail(seq);
			Map<String, Object> map = new HashMap<>(); 
			try {
				// 업로드파일위치
				String uploadPath = req.getServletContext().getRealPath("/upload/market/"+marketInfo.getFile());
				InputStream imageStream = new FileInputStream(uploadPath);
				byte[] imageByte = IOUtils.toByteArray(imageStream);
				map.put("marketInfo", marketInfo);
				map.put("imgInfo", imageByte);


			}catch (Exception e) {
				System.out.println("파일불러오기 오류");
				return null;
			}
			
			return map;

		}
}
