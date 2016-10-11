package www.yllyx.superocr.persistance.image;

import www.yllyx.superocr.domain.image.OcrResult;

public interface OcrResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OcrResult record);

    int insertSelective(OcrResult record);

    OcrResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OcrResult record);

    int updateByPrimaryKey(OcrResult record);
}