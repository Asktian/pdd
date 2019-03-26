package com.tw.pdd.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class UpImg {
    public static String upImg(MultipartFile image) throws IOException {
        if (image.getSize() > 0){
            String fullName = image.getOriginalFilename();
            String extName = fullName.substring(fullName.lastIndexOf("."));
            String newName = new Date().getTime() + extName;
            File file = new File("E:\\images\\user\\"+newName);
            image.transferTo(file);
            return "/images/user/"+newName;
        }
        return null;
    }
}
