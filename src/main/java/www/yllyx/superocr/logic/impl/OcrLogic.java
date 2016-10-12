package www.yllyx.superocr.logic.impl;

import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import www.yllyx.superocr.common.domain.FileMeta;
import www.yllyx.superocr.common.domain.OcrFile;
import www.yllyx.superocr.common.util.ThirdOcrUtil;
import www.yllyx.superocr.domain.image.OcrImage;
import www.yllyx.superocr.logic.IOcrLogic;
import www.yllyx.superocr.persistance.image.OcrImageMapper;

@Component
public class OcrLogic implements IOcrLogic
{

    private static Logger LOGGER = Logger.getLogger(OcrLogic.class);

    @Autowired
    OcrImageMapper imageMapper;

    @Autowired
    ThirdOcrUtil thirdOcrUtil;

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
            // int imageId = imageMapper.insert(image);

            // 调用ocr工具进行验证码识别
            OcrFile ocrFile = new OcrFile();
            ocrFile.setUsername("yllyx");
            ocrFile.setPassword("yllyx123");
            ocrFile.setTypeid("1002");
            ocrFile.setTimeout("1");
            ocrFile.setAuthor("yllyx");
            ocrFile.setCustom("10");
            // ocrFile.setExtra_str(extra_str);
            ocrFile.setImage(file.getBytes());
            String ret = "";
            try
            {
                ret = thirdOcrUtil.doOcr(ocrFile);
            }
            catch (Exception e)
            {
                LOGGER.debug(e.getMessage());
            }

            // 保存识别的结果
        }

    }

}
