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

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement
@Component
public class RequestEntityUtil implements Serializable
{

    /**
     * serialVersionUID<br>
     */
    private static final long serialVersionUID = 2340409251829284848L;

    private Map<Object, Object> params;

    /**
     * @return Returns the params.
     */
    public Map<Object, Object> getParams()
    {
        return params;
    }

    /**
     * @param params The params to set.
     */
    public void setParams(Map<Object, Object> params)
    {
        this.params = params;
    }
}
