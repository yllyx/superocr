package www.yllyx.superocr.common.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import www.yllyx.superocr.common.domain.OcrFile;
import www.yllyx.superocr.common.http.HttpPostReq;

@Component
public class ThirdOcrUtil
{
    static final Logger LOGGER = Logger.getLogger(ThirdOcrUtil.class);

    @Value("#{properties['third-ocr-url']}")
    private String thirdOcrUrl;

    public String doOcr(OcrFile ocrFile) throws ClientProtocolException,
        IOException
    {
        String url = thirdOcrUrl + "/upload";
        HttpPostReq httpPost = new HttpPostReq(url);
        // Map<Object, Object> params = new HashMap<Object, Object>();
        // params.put("username", ocrFile.getUsername());
        // params.put("password", ocrFile.getPassword());
        // params.put("author", ocrFile.getAuthor());
        // params.put("custom", ocrFile.getCustom());
        // params.put("extra_str", ocrFile.getExtra_str());
        // String image = new String(ocrFile.getImage());
        // params.put("image", image);
        // params.put("timeout", ocrFile.getTimeout());
        // params.put("typeid", ocrFile.getTypeid());
        String ret = httpPost.HttpPostMultipartReq(ocrFile);

        return ret;

    }
}
