package com.green.greengram.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;
@Component //User Service에서 사용하기 위해
public class CustomFileUtils {
    private final String uploadPath;

    public CustomFileUtils(@Value("${file.directory}") String uploadPath){
        this.uploadPath=uploadPath;
    }

    public String getExt(MultipartFile mf){
        String fileName=mf.getOriginalFilename();
        int idx=fileName.lastIndexOf(".");
        return fileName.substring(idx); //확장자만 존재
    }

    public String makeRandomName(){return UUID.randomUUID().toString();}
    public String makeRandomName(String fileName){return makeRandomName();}
    public String makeRandomName(MultipartFile mf){
        if(mf==null||mf.isEmpty()){return null;}
        String fileName=String.format("%s%s",makeRandomName(mf.getOriginalFilename()), getExt(mf));
        return fileName;
    }//확장자..?

    public String makeFolders(String path){
        File folders=new File(uploadPath, path);
        folders.mkdirs();
        return folders.getAbsolutePath();
    }
    public void transferTo(MultipartFile mf, String target) throws Exception{//target=경로+파일이름
        File file=new File(uploadPath, target);
        mf.transferTo(file);
    }

}
