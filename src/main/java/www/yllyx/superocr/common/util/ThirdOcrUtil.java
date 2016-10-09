package www.yllyx.superocr.common.util;

import org.springframework.beans.factory.annotation.Value;

public class ThirdOcrUtil
{
    @Value("#{porperties['third-ocr-url']}")
    private String thirdOcrUrl;

}
