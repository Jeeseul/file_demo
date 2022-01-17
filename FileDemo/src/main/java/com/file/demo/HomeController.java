package com.file.demo;

import java.util.List;
import java.util.Locale;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ServiceFile imageFileService;
	

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		
		return "create";
	}
	
	@RequestMapping(value = "/createFile", method = RequestMethod.POST)
	public String createFile(Model model, MultipartHttpServletRequest request, MultipartFile file) {
		
		DTO exampleFile = new DTO();
		DTO exampleImageFile = new DTO();
				
		List<MultipartFile> imageFile = request.getFiles("imagefile");
		List<MultipartFile> allFile = request.getFiles("allfile");
		
		//받은 imagefile 출력
		for(MultipartFile newFile : imageFile) {
			System.out.println(newFile.getOriginalFilename());
		}
		
		//이미지 파일 저장 
		int imgOrder=1;
		
		for(MultipartFile newFile : imageFile) {
			
			if(!imageFile.isEmpty()) {
				//파일이름 저장 
				String imageFileName = newFile.getOriginalFilename();
				
				exampleImageFile.setImageFileName(imageFileName);
				exampleImageFile.setImageOrder(imgOrder);
				
				imageFileService.createExampleImageFile(exampleImageFile);
				
				imgOrder++;
				
				sqlSession.insert("fileDemo.createExampleImageFile", newFile);

				
//				//파일이 업로드 될 경로 설정
//				String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/image");//현재 서비스가 돌아가고 있는 서버의 웹서비스 디렉토리의 물리적 경로
//				
//				//위에서 설정한 경로의 폴더가 없을 경우 생성
//				File dir = new File(saveDir);
//				if (!dir.exists()) {
//					dir.mkdirs();
//				}
//				
//				if (!newFile.isEmpty()) {
//					String extImageFileName = imageFileName.substring(imageFileName.lastIndexOf("."));
//					try {
//						newFile.transferTo(new File(saveDir + "/" + extImageFileName));//newfile을 지정한 file(파라미터)로 저장 
//					} catch (IllegalStateException | IOException e) {
//						e.printStackTrace();
//					}
//				}
			}
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Model model) {
		
		return "update";
	}
	

}
