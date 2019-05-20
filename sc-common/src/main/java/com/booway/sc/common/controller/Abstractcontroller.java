package com.booway.sc.common.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.booway.sc.common.utils.CommonUtil;
import com.booway.sc.common.utils.StreamUtil;

/**
 * 抽象的Controller
 * @author jsb-hujie
 * 
 * 2019年5月8日
 *
 */
public abstract class Abstractcontroller
{
	/** request对象 */
    private HttpServletRequest request;

    /** response对象 */
    private HttpServletResponse response;

    /**
     * 获取request
     * @return
     */
	public HttpServletRequest getRequest()
	{
		return request;
	}
	/**
	 * 获取response
	 * @return
	 */
	public HttpServletResponse getResponse()
	{
		return response;
	}
	/**
	 * 创建session
	 * @return
	 */
	public HttpSession getSession()
	{
		return getRequest().getSession(true);
	}
	/**
	 * 下载处理, 大文件下载尽量用流
	 * @param in
	 * @param fileName
	 */
	public void download(InputStream in, String fileName) throws Exception
	{
		OutputStream out = null;
        try
        {
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + CommonUtil.encodeDownFileName(fileName, request.getHeader("User-Agent")));
            // 设置 默认编码
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download");
            out = response.getOutputStream();
            byte[] buf = new byte[1024 * 10];
            int len = 0;
            while ((len = in.read(buf)) > 0)
            {
                out.write(buf, 0, len);
            }
            out.flush();
        } finally
        {
            StreamUtil.closeStream(in, out);
        }
	}
	/**
	 * 下载, 大文件下载慎用
	 * @param fileData
	 * @param fileName
	 */
	public void download(byte[] fileData, String fileName) throws Exception
	{
		download(new ByteArrayInputStream(fileData), fileName);
	}
	/**
     * 注入Request, Response对象
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        this.request = request;
        this.response = response;
    }
}
