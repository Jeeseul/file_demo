package com.file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.file.demo.DTO;
import com.file.demo.DAO;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
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
				
				exampleImageFile.setOriginalImageUrl(imageFileName);
				exampleImageFile.setFileOrder(imgOrder);
				
				DAO.createExampleImageFile(exampleImageFile);
				imgOrder++;
				
				//파일이 업로드 될 경로 설정
				String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/image");//현재 서비스가 돌아가고 있는 서버의 웹서비스 디렉토리의 물리적 경로
				
				//위에서 설정한 경로의 폴더가 없을 경우 생성
				File dir = new File(saveDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				
				if (!newFile.isEmpty()) {
					String extImageFileName = imageFileName.substring(imageFileName.lastIndexOf("."));
					try {
						newFile.transferTo(new File(saveDir + "/" + extImageFileName));//newfile을 지정한 file(파라미터)로 저장 
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return "create";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Model model) {
		
		return "update";
	}
	

}
