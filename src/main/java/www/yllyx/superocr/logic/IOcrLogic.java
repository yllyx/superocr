package www.yllyx.superocr.logic;

import java.util.LinkedList;

import www.yllyx.superocr.common.domain.FileMeta;
import www.yllyx.superocr.common.util.ResponseEntityUtil;

public interface IOcrLogic
{

    ResponseEntityUtil uploadImg(LinkedList<FileMeta> imgFile);

    /**
     * 上传的图片入库，并进行ocr,将结果保存到数据库
     * 
     * @param files
     */
    void doOcr(LinkedList<FileMeta> files);

}
