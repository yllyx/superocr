package www.yllyx.superocr.logic.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import www.yllyx.superocr.common.domain.FileMeta;
import www.yllyx.superocr.common.util.ResponseEntityUtil;
import www.yllyx.superocr.domain.image.OcrImage;
import www.yllyx.superocr.logic.IOcrLogic;
import www.yllyx.superocr.persistance.image.OcrImageMapper;

@Component
public class OcrLogic implements IOcrLogic
{

    @Autowired
    OcrImageMapper imageMapper;

    @Override
    public ResponseEntityUtil uploadImg(LinkedList<FileMeta> imgFile)
    {
        // TODO :完成图片上传，并记录返回值
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void doOcr(LinkedList<FileMeta> files)
    {
        for (FileMeta file : files)
        {
            // 保存上传的图片
            OcrImage image = new OcrImage();
            image.setUserId(1);
            image.setName(file.getFileName());
            image.setFile(file.getBytes());
            image.setSize(file.getSize());
            image.setType(file.getFileType());
            int imageId = imageMapper.insert(image);

            // 调用ocr工具进行验证码识别

            // 保存识别的结果
        }

    }

}
