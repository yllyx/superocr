package www.yllyx.superocr.persistance.image;

import www.yllyx.superocr.domain.image.OcrImage;

public interface OcrImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OcrImage record);

    int insertSelective(OcrImage record);

    OcrImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OcrImage record);

    int updateByPrimaryKeyWithBLOBs(OcrImage record);

    int updateByPrimaryKey(OcrImage record);
}