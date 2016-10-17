package www.yllyx.superocr.common.domain;

public class OcrFile
{
    private String username;

    private String password;

    private String typeid;

    private String timeout;

    private String author;

    private String custom;

    private String extra_str;

    private byte[] image;

    private String filePath;

    private String fileName;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTypeid()
    {
        return typeid;
    }

    public void setTypeid(String typeid)
    {
        this.typeid = typeid;
    }

    public String getTimeout()
    {
        return timeout;
    }

    public void setTimeout(String timeout)
    {
        this.timeout = timeout;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getCustom()
    {
        return custom;
    }

    public void setCustom(String custom)
    {
        this.custom = custom;
    }

    public String getExtra_str()
    {
        if (extra_str == null)
        {
            return "";
        }
        return extra_str;
    }

    public void setExtra_str(String extra_str)
    {
        this.extra_str = extra_str;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
}
