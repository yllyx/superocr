package www.yllyx.superocr.logic.impl;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import www.yllyx.superocr.common.domain.FileMeta;
import www.yllyx.superocr.common.util.ResponseEntityUtil;
import www.yllyx.superocr.logic.IOcrLogic;

@Component
public class OcrLogic implements IOcrLogic
{

    @Override
    public ResponseEntityUtil uploadImg(LinkedList<FileMeta> imgFile)
    {
        // TODO :完成图片上传，并记录返回值
        // TODO Auto-generated method stub
        return null;
    }

}
