package www.yllyx.superocr.common.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

// ignore "bytes" when return json format
@JsonIgnoreProperties({"bytes"})
public class FileMeta
{

    private String fileName;

    private String fileSize;// 用于显示

    private String fileType;

    private long size;// 文件实际大小

    private byte[] bytes;

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(String fileSize)
    {
        this.fileSize = fileSize;
    }

    public String getFileType()
    {
        return fileType;
    }

    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public byte[] getBytes()
    {
        return bytes;
    }

    public void setBytes(byte[] bytes)
    {
        this.bytes = bytes;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }
}
