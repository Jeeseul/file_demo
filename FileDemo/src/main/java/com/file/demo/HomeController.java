package com.file.demo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ServiceFile imageFileService;

//	@Autowired
//	private SqlSessionTemplate sqlSession;

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

		// 받은 imagefile 출력
		for (MultipartFile newFile : imageFile) {
			System.out.println(newFile.getOriginalFilename());
		}

		// 이미지 파일 저장
		int imgOrder = 1;

		for (MultipartFile newFile : imageFile) {

			// 파일이름 저장
			String imageFileName = newFile.getOriginalFilename();

			exampleImageFile.setImageFileName(imageFileName);
			exampleImageFile.setImageOrder(imgOrder);

			imageFileService.createExampleImageFile(exampleImageFile);

			imgOrder++;
			System.out.println(exampleImageFile.toString());

			Map<String, Object> ImageFile = new HashMap<String, Object>();
			ImageFile.put("imageFileName", exampleImageFile.getImageFileName());
			ImageFile.put("imgOrder", exampleImageFile.getImageOrder());

			// sqlSession.insert("fileDemo.createExampleImageFile", ImageFile);
			String save = request.getSession().getServletContext().getRealPath("/resources/upload/image");//현재
			System.out.println("save directory: " + save);
			if (!imageFile.isEmpty()) {

				// 파일이 업로드 될 경로 설정

				String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/image");//현재
				
				// 서비스가 돌아가고 있는 서버의 웹서비스 디렉토리의 물리적 경로
				//String saveDir = "tomcat/webapps/uploads/image";

				// 위에서 설정한 경로의 폴더가 없을 경우 생성
				File dir = new File(saveDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				if (!newFile.isEmpty()) {
					String extImageFileName = imageFileName.substring(imageFileName.lastIndexOf("."));
					try {
						newFile.transferTo(new File(saveDir + "/" + imageFileName));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}

		}

		return "redirect:/";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView read(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<DTO> imgFileList = imageFileService.readImageFileList();
		mv.addObject("imgFileList", imgFileList);
		System.out.println(mv);
		mv.setViewName("read");
		
		return mv;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		//List<DTO> clubAdDetailList = imageFileService.readClubAdvertiseDetail(id);

		List<DTO> imgList = imageFileService.getImg(id);
	
		mv.addObject("imgList", imgList);

		System.out.println(mv);

		mv.setViewName("update");
		
		return mv;
	}

}
