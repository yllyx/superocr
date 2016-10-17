package www.yllyx.superocr.common.http;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import www.yllyx.superocr.common.domain.OcrFile;

public class HttpPostReq extends AbstractHttpRequest
{

    private static Logger LOGGER = Logger.getLogger(HttpPostReq.class);

    // 请求URL地址
    private String url;

    // 消息头设置
    private BasicHeader[] header;

    // 请求体
    private List<BasicNameValuePair> params;

    // 请求体，可以使用二进制
    private HttpEntity reqEntity;

    public HttpPostReq(String url)
    {
        this.url = url;
    }

    public HttpPostReq(String url, BasicHeader[] header)
    {
        this.url = url;
        this.header = header;
    }

    public HttpPostReq(String url, BasicHeader[] header, List<BasicNameValuePair> params)
    {
        this.url = url;
        this.header = header;
        this.params = params;
    }

    public HttpPostReq(String url, BasicHeader[] header, HttpEntity reqEntity)
    {
        this.url = url;
        this.header = header;
        this.reqEntity = reqEntity;
    }

    public HttpPostReq(String url, BasicHeader[] header, FileBody bin)
    {
        this.url = url;
        this.header = header;
        this.reqEntity = MultipartEntityBuilder.create().addPart("file", bin).build();
    }

    public HttpPostReq(String url, BasicHeader[] header, File file)
    {
        this.url = url;
        this.header = header;
        this.reqEntity =
            MultipartEntityBuilder.create().addPart("file", new FileBody(file)).build();
    }

    public HttpPostReq(String url, BasicHeader[] header, File file, Map params)
    {
        this.url = url;
        this.header = header;

        MultipartEntityBuilder multipartEntity =
            MultipartEntityBuilder.create().addPart("file", new FileBody(file));

        if (params != null && !params.isEmpty())
        {
            for (Object key : params.keySet())
            {
                multipartEntity.addPart((String)key,
                    new StringBody((String)params.get(key), ContentType.APPLICATION_JSON));
            }
        }
        this.reqEntity = multipartEntity.build();
    }

    public String HttpPostMultipartReq(OcrFile ocrFile) throws ClientProtocolException,
        IOException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(this.url);

        // 创建参数队列
        // List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
        //
        // InputStreamBody inputStreamBody = new InputStreamBody(
        // new ByteArrayInputStream(ocrFile.getImage()), ocrFile.getFilePath());
        // formparams.add(new BasicNameValuePair("username", ocrFile.getUsername()));
        // formparams.add(new BasicNameValuePair("password", ocrFile.getPassword()));
        // formparams.add(new BasicNameValuePair("typeid", ocrFile.getTypeid()));
        // formparams.add(new BasicNameValuePair("timeout", ocrFile.getTypeid()));
        // formparams.add(new BasicNameValuePair("author", ocrFile.getAuthor()));
        // formparams.add(new BasicNameValuePair("custom", ocrFile.getCustom()));
        // formparams.add(new BasicNameValuePair("image", new String(ocrFile.getImage())));
        // UrlEncodedFormEntity urlEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        // urlEntity.setContentType("multipart/form-data");
        // urlEntity.setContentEncoding("UTF-8");
        // httpPost.setEntity(urlEntity);

        MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();

        multipartEntity.addPart(new FormBodyPart("username", new StringBody(ocrFile.getUsername(),
            ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"))));
        multipartEntity.addPart(new FormBodyPart("password", new StringBody(ocrFile.getPassword(),
            ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"))));
        multipartEntity.addPart(new FormBodyPart("typeid", new StringBody(ocrFile.getTypeid(),
            ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"))));
        multipartEntity.addPart(new FormBodyPart("timeout", new StringBody(ocrFile.getTimeout(),
            ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"))));
        multipartEntity.addPart(new FormBodyPart("author", new StringBody(ocrFile.getAuthor(),
            ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"))));
        multipartEntity.addPart(new FormBodyPart("custom", new StringBody(ocrFile.getCustom(),
            ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"))));
        // multipartEntity.addPart(
        // new FormBodyPart("image", new StringBody(new String(ocrFile.getImage()),
        // ContentType.APPLICATION_OCTET_STREAM.withCharset("UTF-8"))));
        multipartEntity.addBinaryBody("image", ocrFile.getImage(),
            ContentType.APPLICATION_OCTET_STREAM, ocrFile.getFileName());
        // InputStreamBody inputStreamBody = new InputStreamBody(
        // new ByteArrayInputStream(ocrFile.getImage()), ocrFile.getFilePath());
        // multipartEntity.addPart("image", inputStreamBody);
        // multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntity.setCharset(Charset.forName("UTF-8"));
        // multipartEntity.setBoundary("------------------------------831b7f6f6a2d");
        this.reqEntity = multipartEntity.build();
        httpPost.setEntity(this.reqEntity);

        // // multipartEntity.setCharset(Charset.forName(HTTP.UTF_8));// 设置请求的编码格式
        //
        // if (params != null && !params.isEmpty())
        // {
        // for (Object key : params.keySet())
        // {
        // ContentBody contentBody = new StringBody((String)params.get(key),
        // ContentType.MULTIPART_FORM_DATA.withCharset("UTF-8"));
        // FormBodyPart bodyPart = new FormBodyPart((String)key, contentBody);
        // multipartEntity.addPart(bodyPart);
        // }
        // }

        httpPost.setHeader("User-Agent",
            "Mozilla/5.0 (Windows NT 5.1; zh-CN; rv:1.9.1.3) Gecko/20100101 Firefox/8.0");
        httpPost.setHeader("Accept", "*/*");
        httpPost.removeHeaders("Accept-Encoding");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String ret = EntityUtils.toString(responseEntity);
        return ret;
    }

    @Override
    public HttpRequestBase getHttpMethod() throws UnsupportedEncodingException
    {
        HttpPost httpPost = new HttpPost(url);
        if (params != null && !params.isEmpty())
        {
            httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        }

        if (reqEntity != null)
        {
            httpPost.setEntity(reqEntity);
        }
        httpPost.setHeaders(header);
        return httpPost;
    }

}
