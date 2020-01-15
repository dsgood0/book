package com.khrd.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	// upload 함수, 원본 업로드, thumbnail 업로드, 년/월/일 폴더 만들기
	// uploadPath : c://zzz/upload
	// orignalFileName : 파일 이름
	// data : 이미지 데이터
	// return 값 : thumbnail 파일 명
	public static String uploadFile(String uploadPath, String originalFileName, byte[] data) throws Exception {

		// ---------- 원본 업로드 -------------
		// 랜덤 값 생성
		UUID uid = UUID.randomUUID();
		// 랜덤 값_파일 원본 이름
		String savedName = uid.toString() + "_" + originalFileName;

		String datePath = calculatorPath(uploadPath); // /년/월/일 폴더를 만든 후 경로 (/2019/05/01) 리턴
		// c:/zzz/upload/파일명
		File newFile = new File(uploadPath + datePath, savedName);
		// 파일을 바이트 값 복사해서 새 파일을 저장
		FileCopyUtils.copy(data, newFile);

		// --------- 썸네일 업로드 -------------
		String thumbName = makeThumbnail(uploadPath + datePath, savedName);

		return datePath + thumbName; // /년/월/일/작은이미지
	}

	private static String makeThumbnail(String uploadPath, String filename) throws Exception {
		// BufferedImage : 실제 이미지가 아닌 메모리 상의 이미지를 의미하는 객체

		// 원본 이미지를 가져와서 메모리 상에 넣어둠
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + "/" + filename));

		// 작은 이미지 용으로 리사이징 시킴. 높이 100을 기준으로 가로는 자동 조정
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 300);

		// 작은 이미지 데이터가 들어갈 파일 만들기. 이름 앞에 s_가 들어감.
		String thumbnailName = uploadPath + "/" + "s_" + filename;
		File newFile = new File(thumbnailName);

		// 파일 확장자
		String formatName = filename.substring(filename.lastIndexOf(".") + 1);

		// 작은 이미지 데이터를 작은 이미지 파일에 복사시킴. 파일 완성
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);

		// 썸네일 이미지 파일명을 리턴함.
		return thumbnailName.substring(uploadPath.length());
	}

	private static String calculatorPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = "/" + cal.get(Calendar.YEAR);
		String monthPath = String.format("%s/%02d", yearPath, cal.get(Calendar.MONTH) + 1); // 2019/05
		String datePath = String.format("%s/%02d", monthPath, cal.get(Calendar.DATE)); // /2019/05/01

		makeDir(uploadPath, yearPath, monthPath, datePath);

		return datePath; // c:/zzz:upload/2019/05/01
	}

	// paths = {yearPath, monthPath, datePath}
	private static void makeDir(String uploadPath, String... paths) {

		for (String path : paths) {
			File dir = new File(uploadPath + path);
			if (dir.exists() == false) {
				dir.mkdir();
			}
		}
	}

	public static void deleteFile(String uploadPath, String filename) {
		// thumbnail 파일 삭제
		File file = new File(uploadPath + "/" + filename); // 썸네일에 접근할 파일 경로
		file.delete(); // 파일 삭제

		// 원본 파일 삭제
		String folder = filename.substring(0, 11); // /년/월/일
		String src = filename.substring(14); // 앞에 붙은 "/s_"를 뺀 파일 이름
		File sfile = new File(uploadPath + folder + "/" + src); // 원본 파일에 접근할 파일 경로
		System.out.println(uploadPath + folder + "/" + src);
		sfile.delete(); // 파일 삭제
	}
}
