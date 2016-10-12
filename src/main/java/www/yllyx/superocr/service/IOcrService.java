package www.yllyx.superocr.service;

import java.util.LinkedList;

import www.yllyx.superocr.common.domain.FileMeta;

public interface IOcrService
{
    public void ocrImg(LinkedList<FileMeta> files);
}
