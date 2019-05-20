package com.booway.sc.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * xml工具类
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
public class XmlUtil
{
	private XmlUtil() { }
	
	/**
	 * 获取xml文档
	 * @param xmlPath
	 * @return
	 */
	public static Document getDocument(InputStream xmlStream) throws Exception
	{
		DocumentBuilderFactory buildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = buildFactory.newDocumentBuilder();
		return builder.parse(xmlStream);
	}
	/**
	 * 获取xml文档
	 * @param xmlPath
	 * @return
	 */
	public static Document getDocument(String xmlPath) throws Exception
	{
		return getDocument(new FileInputStream(xmlPath));
	}
	/**
	 * 获取xml文档
	 * @param xmlPath
	 * @return
	 */
	public static Document getDocument(File xmlFile) throws Exception
	{
		return getDocument(new FileInputStream(xmlFile));
	}
	/**
	 * 将xml文档对象写入XML文件
	 * @param doc      xml文档对象
	 * @param xmlName  xml文件名
	 * @throws Exception
	 */
	public static void writeToXml(Document doc, String xmlName) throws Exception
	{
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		// 处理生成xml文件时, 进行格式化, 不需要处理
		// tf.setOutputProperty(OutputKeys.INDENT, "yes");      
		tf.transform(new DOMSource(doc), new StreamResult(new File(xmlName)));
	}
	/**
	 * 将xml文档写入文件, 如果含有特殊字符的话, 不会被转义
	 * @param doc
	 * @param fileName
	 * @throws Exception
	 */
	public static void writeToFile(Document doc, String fileName) throws Exception
	{
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		// 处理特殊字符时是否需要进行转义
		tf.setOutputProperty(OutputKeys.METHOD, "html");  
		tf.transform(new DOMSource(doc), new StreamResult(new File(fileName)));
	}
	/**
	 * 获取节点
	 * @param doc
	 * @param tagName
	 * @return
	 */
	public static Element getElementByTagName(Element doc, String tagName)
	{
		NodeList ls = doc.getElementsByTagName(tagName);
		return (ls == null || 0 == ls.getLength()) ? null : (Element)ls.item(0);
	}
	/**
	 * 获取子节点
	 * @param ele
	 * @param tagName
	 * @return
	 */
	public static List<Element> getChildElements(Element ele, String tagName)
	{
		NodeList nls = ele.getChildNodes();
		if (nls == null || 0 == nls.getLength())
		{
			return null;
		}
		List<Element> rs = new ArrayList<Element>();
		for (int i = 0; i < nls.getLength(); i++)
		{
			if (Node.ELEMENT_NODE == nls.item(i).getNodeType())
			{
				Element e = (Element) nls.item(i);
				if (tagName == null)
				{
					rs.add(e);
				} else if (e.getTagName().equalsIgnoreCase(tagName))
				{
					rs.add(e);
				}
			}
		}
		return rs;
	}
	/**
	 * 获取子节点
	 * @param ele
	 * @return
	 */
	public static List<Element> getChildElements(Element ele)
	{
		return getChildElements(ele, null);
	}
}
