/*
 * 文件名：ResponseEntityUtil.java
 * 版权：Copyright by http://nercel.ccnu.edu.cn/
 * 描述：
 * 修改人：longyunxiang
 * 修改时间：2015年12月9日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package www.yllyx.superocr.common.util;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ResponseEntityUtil implements Serializable
{

    /**
     * serialVersionUID<br>
     */
    private static final long serialVersionUID = 7790457723608112447L;

    private boolean status;

    private String msg;

    private Map<Object, Object> data;

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Map<Object, Object> getData()
    {
        return data;
    }

    public void setData(Map<Object, Object> data)
    {
        this.data = data;
    }

    /**
     * @return Returns the status.
     */
    public boolean getStatus()
    {
        return status;
    }

    /**
     * @param status The status to set.
     */
    public void setStatus(boolean status)
    {
        this.status = status;
    }

}
