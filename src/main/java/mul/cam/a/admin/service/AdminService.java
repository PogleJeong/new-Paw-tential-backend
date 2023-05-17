package mul.cam.a.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.admin.dao.AdminDao;
import mul.cam.a.admin.dto.PageParam;
import mul.cam.a.market.dto.MarketDto;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.myfeed.dto.QnADto;
import mul.cam.a.myfeed.dto.ReportDto;

@Service
@Transactional
public class AdminService {

	@Autowired
	AdminDao dao;
	
	public MemberDto userInfo(String id) {
		return dao.userInfo(id);
	}
	
	public List<MemberDto> userList(PageParam param){
		return dao.userList(param);
	}
	
	public int getAllUser(PageParam param) {
		return dao.getAllUser(param);
	}
	
	public boolean userDel(String id) {
		int n = dao.userDel(id);
		return n>0?true:false;
	}
	
	
	public List<Map<String, Object>> reportList(PageParam param){
		return dao.reportList(param);
	}
	
	public int getAllReport(PageParam param) {
		return dao.getAllReport(param);
	}
	
	public List<QnADto> QnAList(PageParam param){
		return dao.QnAList(param);
	}
	
	public int getAllQnA(PageParam param) {
		return dao.getAllQnA(param);
	}
	
	public boolean answer(int seq) {
		int n = dao.answer(seq);
		return n>0?true:false;
	}
	
	public List<Map<String, Object>> petChart() {
		return dao.petChart();
	}
	
	public List<Map<String, Object>> UserChart() {
		return dao.UserChart();
	}
	
	public List<Map<String, Object>> regiChart() {
		return dao.regiChart();
	}
	
	public MarketDto marketDetail(int seq) {
		return dao.marketDetail(seq);
	}
}
