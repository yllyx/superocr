package www.yllyx.superocr.common.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import www.yllyx.superocr.common.domain.OcrFile;

public class ThirdOcrUtil
{
    static final Logger LOGGER = Logger.getLogger(ThirdOcrUtil.class);

    @Value("#{porperties['third-ocr-url']}")
    private String thirdOcrUrl;

    String doOcr(OcrFile ocrFile)
    {
        return null;
    }
}
