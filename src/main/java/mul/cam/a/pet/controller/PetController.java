package mul.cam.a.pet.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.market.dto.MarketDto;
import mul.cam.a.pet.dto.PetDto;
import mul.cam.a.pet.service.PetService;
import mul.cam.a.util.FileUtil;

@RestController
public class PetController {
	@Autowired
	PetService service;
	
	@PostMapping(value="/petRegister")
	public String petRegister(@RequestPart("file")MultipartFile[] fileUpload,
			@RequestPart("petInfoList")PetDto[] petInfoList,
			HttpServletRequest req) {
		System.out.println("fileUpload" + new Date());
		
		// 업로드한 파일 저장할 위치 설정
		String uploadPath = req.getServletContext().getRealPath("/upload/pet");
		
		String isSuccess = "";
		for (int i=0; i<petInfoList.length; i++) {
			// 저장했을 때 파일이름. (중복을 막기 위하여 새로운 파일이름)
			String fileName = fileUpload[i].getOriginalFilename();
			String newFileName = FileUtil.getNewFileName(fileName);
			String filePath = uploadPath + "/" + newFileName;
			
			
			// db에 파일명 저장하기 위한 dto 삽입
			petInfoList[i].setImg(newFileName);
			System.out.println(petInfoList.toString());
			
			try {
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				os.write(fileUpload[i].getBytes());			
				os.close();
				isSuccess = service.petRegister(petInfoList[i]);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		return isSuccess;
	}
	
	@PostMapping(value="/get/petInfo")
	public Map<String, Object> getPetInfoList(String id, HttpServletRequest req) {
		System.out.println("get pet info list >> " + new Date());
		System.out.println("id : " + id);
		
		PetDto[] petInfoList = service.getPetInfoList(id);
		List<byte[]> imageList = new ArrayList<byte[]>();
		// 마켓 리스트 가져오고 파일데이터를 처리
		// Map (마켓리스트 , 파일이미지)
		for (PetDto petInfo : petInfoList) {
			System.out.println(petInfo.toString());
			try {
				// 업로드파일위치
				String uploadPath = req.getServletContext().getRealPath("/upload/pet/"+ petInfo.getImg());
				InputStream imageStream = new FileInputStream(uploadPath);
				byte[] imageByte = IOUtils.toByteArray(imageStream);
				
				// 
				imageList.add(imageByte);
			}catch (Exception e) {
				System.out.println("파일불러오기 오류");
				return null;
			}
		}
		
		HashMap<String, Object> petInfoListAndImage = new HashMap<>();
		petInfoListAndImage.put("petInfoList", petInfoList);
		petInfoListAndImage.put("imageList", imageList);
		
		return petInfoListAndImage;
	}
	
	@PostMapping(value="/update/petInfo")
	public String updatePetInfo(@RequestPart("file")MultipartFile[] fileUpload,
			@RequestPart("petInfoList")PetDto[] petInfoList,
			String id,
			HttpServletRequest req) {
		System.out.println("update pet info >> " + new Date());
		System.out.println("id >> " + id);
		if (petInfoList == null || petInfoList.length == 0) {
			return "empty";
		}
		// 기존 펫정보 삭제 후 수정받은 펫 정보 삽입
		service.removePetInfo(id);
		
		// 업로드한 파일 저장할 위치 설정
		String uploadPath = req.getServletContext().getRealPath("/upload/pet");
		
		String isSuccess = "";
		for (int i=0; i<petInfoList.length; i++) {
			// 저장했을 때 파일이름. (중복을 막기 위하여 새로운 파일이름)
			String fileName = fileUpload[i].getOriginalFilename();
			String newFileName = FileUtil.getNewFileName(fileName);
			String filePath = uploadPath + "/" + newFileName;
			
			
			// db에 파일명 저장하기 위한 dto 삽입
			petInfoList[i].setImg(newFileName);
			System.out.println("남아있는 펫정보 >> " + petInfoList.toString());
			
			try {
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				os.write(fileUpload[i].getBytes());			
				os.close();
				isSuccess = service.petRegister(petInfoList[i]);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		return isSuccess;
	}
}
