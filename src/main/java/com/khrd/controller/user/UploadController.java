package com.khrd.controller.user;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/upload/*")
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	// id로 주입(DI : dependency Injection) 받음
	@Resource(name = "uploadPath")
	private String uploadPath;

	// 서버에 저장된 파일 저장 폴더 위치 가져오는 함수
	@RequestMapping(value = "displayFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename) {
		ResponseEntity<byte[]> entity = null;

		logger.info("file name : " + filename);

		try {
			String formatName = filename.substring(filename.lastIndexOf(".") + 1);
			MediaType type = null;

			// 확장자에 따른 이미지 타입 지정
			if (formatName.equalsIgnoreCase("jpg") || formatName.equalsIgnoreCase("jpeg")) {
				type = MediaType.IMAGE_JPEG;
			} else if (formatName.equalsIgnoreCase("png")) {
				type = MediaType.IMAGE_PNG;
			} else if (formatName.equalsIgnoreCase("gif")) {
				type = MediaType.IMAGE_GIF;
			}

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(type);

			// 파일을 읽어들임
			InputStream in = new FileInputStream(uploadPath + "/" + filename);

			// 바이트 배열 리턴
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

			// inputStream은 사용 완료 후 꼭 닫아줘야 함.
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
