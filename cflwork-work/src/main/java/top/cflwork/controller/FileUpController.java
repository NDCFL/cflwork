package top.cflwork.controller;

import org.apache.commons.lang.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import top.cflwork.util.QiniuUtil;
import top.cflwork.vo.FileVo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("file")
@Controller
public class FileUpController {
    @RequestMapping("up")
    @ResponseBody
    public FileVo fileUp(MultipartFile file, HttpServletRequest request) {
        FileVo fileVo = new FileVo();
        try {
            String url = QiniuUtil.uploadImage(file, "upload/faceImg");
            Map<String, String> data = new HashMap<String, String>();
            data.put("src", url);
            fileVo.setData(data);
            System.out.println("保存到数据库的图片地址:" + url);
            fileVo.setCode(0);
        } catch (Exception e) {
            e.printStackTrace();
            fileVo.setCode(1);
        }
        fileVo.setMsg("上传成功!");
        return fileVo;
    }

    @RequestMapping("/imageUpload")
    @ResponseBody
    public String imageUpload(MultipartHttpServletRequest request) throws Exception {
        String str = null;
        String path = "http://pi40e4tyd.bkt.clouddn.com";
        try {
            MultipartFile file = request.getFile("imgFile");
            String url = QiniuUtil.uploadImage(file, "upload/faceImg");
            str = "{\"error\" : 0,\"url\" : \""+path+url+"\"}";//成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    //    @RequestMapping("up")
//    @ResponseBody
//    public FileVo fileUp(MultipartFile file, HttpServletRequest request){
//        FileVo fileVo = new FileVo();
//        try{
//            //使用原始文件名称
//            String fileName = file.getOriginalFilename();
//            //重新格式化文件名称
//            //String fileName = getFileName(file.getOriginalFilename());
//            String path = request.getSession().getServletContext().getRealPath("upload");
//            String names = getFileName(fileName);
//            File dir = new File(path,names);
//            if(!dir.exists()){
//                dir.mkdirs();
//            }
//            file.transferTo(dir);
//            Map<String,String> data = new HashMap<String, String>();
//            data.put("src","/upload/"+names);
//            fileVo.setData(data);
//            System.out.println("保存到数据库的图片地址:/upload/"+names);
//            fileVo.setCode(0);
//        }catch (Exception e){
//            e.printStackTrace();
//            fileVo.setCode(1);
//        }
//        fileVo.setMsg("上传成功!");
//        return  fileVo;
//    }
    //重命名文件名称
    private synchronized String getFileName(String filename) {
        int position = filename.lastIndexOf(".");
        String ext = filename.substring(position);
        return System.nanoTime() + ext;
    }
}