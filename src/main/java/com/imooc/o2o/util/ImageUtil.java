package com.imooc.o2o.util;

import com.sun.javafx.scene.shape.PathUtils;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * @author lee
 * 处理图片的工具类，利用Thumbnalis;
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static String generateThumbnail( CommonsMultipartFile thumbnail, String targetAddr){
        String realFileName = FileUtil.getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200,200).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath +"/watermark.jpg")),0.2f)
                    .outputQuality(0.8f).toFile(dest);
        }catch (Exception ex){
            throw new RuntimeException("创建缩略图失败" + extension.toString());
        }
        return relativeAddr;

    }
    /**  创建目标路径的地址*/
    private static void makeDirPath(String targetAddr){
        String realFileParentPath = FileUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**  获取文件的扩展名 */
    private static String getFileExtension(CommonsMultipartFile cFile){
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

}
