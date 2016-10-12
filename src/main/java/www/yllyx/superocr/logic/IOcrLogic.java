package www.yllyx.superocr.logic;

import java.util.LinkedList;

import www.yllyx.superocr.common.domain.FileMeta;

public interface IOcrLogic
{

    /**
     * 上传的图片入库，并进行ocr,将结果保存到数据库
     * 
     * @param files
     */
    void doOcr(LinkedList<FileMeta> files);

}
