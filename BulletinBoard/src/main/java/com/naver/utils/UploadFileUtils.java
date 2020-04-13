package com.naver.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {
	
	public static String uploadFile(String uploadPath, MultipartFile file) throws IOException {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+file.getOriginalFilename();
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		String type = savedName.substring(savedName.lastIndexOf(".")+1);
		String uploadFileName = null;
		if(MediaUtils.getMediaType(type) == null) {
			uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		} else {
			uploadFileName = makeThumbnail(uploadPath, savedPath, savedName);
		}
		return uploadFileName;
	}

	private static String makeThumbnail(String uploadPath, String savedPath, String savedName) throws IOException {
		String name1 = uploadPath+savedPath+File.separator+"s_"+savedName;
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+savedPath, savedName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT, 100);
		File f = new File(name1);
		String formatName = savedName.substring(savedName.lastIndexOf(".")+1);
		ImageIO.write(destImg, formatName.toUpperCase(), f);
		return name1.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String makeIcon(String uploadPath, String savedPath, String savedName) {
		String name = uploadPath + savedPath + File.separator + savedName;
		return name.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearpath = File.separator+cal.get(Calendar.YEAR);
		String monthpath = yearpath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datepath = monthpath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearpath, monthpath, datepath);
		return datepath;
	}

	private static void makeDir(String uploadPath, String...arr) {
		if(new File(uploadPath+arr[arr.length-1]).exists()) {
			return;
		}
		for(String path : arr) {
			File f = new File(uploadPath+path);
			if(!f.exists()) {
				f.mkdir();
			}
		}	
	}
}
