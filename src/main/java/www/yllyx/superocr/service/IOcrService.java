package www.yllyx.superocr.service;

import java.util.LinkedList;

import www.yllyx.superocr.common.domain.FileMeta;
import www.yllyx.superocr.common.util.ResponseEntityUtil;

public interface IOcrService
{
    public ResponseEntityUtil uploadOrcImg(LinkedList<FileMeta> imgFile);

    public void ocrImg(LinkedList<FileMeta> files);
}
