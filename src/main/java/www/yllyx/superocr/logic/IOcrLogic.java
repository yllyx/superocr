package www.yllyx.superocr.logic;

import java.util.LinkedList;

import www.yllyx.superocr.common.domain.FileMeta;
import www.yllyx.superocr.common.util.ResponseEntityUtil;

public interface IOcrLogic
{

    ResponseEntityUtil uploadImg(LinkedList<FileMeta> imgFile);

}
