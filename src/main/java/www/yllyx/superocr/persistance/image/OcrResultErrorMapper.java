package www.yllyx.superocr.persistance.image;

import www.yllyx.superocr.domain.image.OcrResultError;

public interface OcrResultErrorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OcrResultError record);

    int insertSelective(OcrResultError record);

    OcrResultError selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OcrResultError record);

    int updateByPrimaryKey(OcrResultError record);
}