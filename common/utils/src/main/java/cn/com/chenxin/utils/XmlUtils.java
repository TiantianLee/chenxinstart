package cn.com.chenxin.utils;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
public class XmlUtils {
	
	/**
	 * <P>map 转换成 XML</P>
	 * @param map
	 * @param rootName
	 * @return
	 */
	public static String mapToXml(Map<String, String> map, String rootName)
	{
		Element root = new Element(rootName);
		if (map == null)
			return xmlToString(root);
		for (String str : map.keySet())
			root.addContent(new Element(str).setText((map.get(str) == null ? ""
					: map.get(str) + "")));
		return xmlToString(root);
	}
	
	/**
	 * <P>XML 转换成 map</P>
	 * @param xmlStr�ַ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> xmlToMap(String xmlStr)
	{
		
		SAXBuilder builder = new SAXBuilder();
		Map<String, String> map = new HashMap<String, String>();
		try {
			xmlStr = URLDecoder.decode(xmlStr, "UTF-8");
			Reader in = new StringReader(xmlStr);
			Document doc = builder.build(in);
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element e : list) 
				map.put(e.getName(), e.getText());
			return map;
		} catch (JDOMException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return map;
		
	}
	
	
	/**
	 * <P>list�转换成 XML</P>
	 * @param list
	 * @param rootName
	 * @param parentName
	 * @return
	 */
	public static String listToXml(List<Map<String, String>> list,
			String rootName, String parentName)
	{
		Element root = new Element(rootName);
		boolean flag = true;
		Element parentElement = null;
		Element child = null;
		if (list == null)
			return xmlToString(root);
		for (Map<String, String> map : list)
			if (flag) {
				flag = false;
				for (String str : map.keySet()) {
					child = new Element(str).setText(map.get(str) == null ? ""
							: (map.get(str) + ""));
					root.addContent(child);
				}
			} else {
				parentElement = new Element(parentName);
				root.addContent(parentElement);
				for (String str : map.keySet()) {
					child = new Element(str).setText(map.get(str) == null ? ""
							: (map.get(str) + ""));
					parentElement.addContent(child);
				}
			}
		return xmlToString(root);
	}
	

	/**
	 * <P>XML转换成 list</P>
	 * @param xmlStr
	 * @return
	 */
	public static List<Map<String, String>> xmlToList(String xmlStr) 
	{
		SAXBuilder builder = new SAXBuilder();
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		boolean flag = true;
		try {
			xmlStr = URLDecoder.decode(xmlStr, "UTF-8");
			Reader in = new StringReader(xmlStr);
			Document doc = builder.build(in);
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element e : list) {
				if (e.getChildren().size() == 0) {
					if (flag) {
						flag = false;
						map = new HashMap<String, String>();
						resultList.add(map);
					}
					map.put(e.getName(), e.getText());
				} else {
					map = new HashMap<String, String>();
					List<Element> childrenList = e.getChildren();
					resultList.add(map);
					for (Element element : childrenList) {
						map.put(element.getName(), element.getText());
					}
				}
			}
			return resultList;
		} catch (JDOMException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return resultList;
	}
	
	/**
	 * ��Element����ת�����ִ�
	 * @param element
	 * @return
	 */
	public static String xmlToString(Element element) 
	{
		XMLOutputter output = new XMLOutputter();
		output.setFormat(Format.getPrettyFormat().setEncoding("UTF-8"));
		Document doc = new Document(element);
		String str = output.outputString(doc);
		return str;
	}
	



	/**
	 * ��ɴ����ݵĽڵ�
	 * @param parentElement���ڵ�
	 * @param map
	 *            ��ݼ�
	 * @return
	 */
	public static Element createNodes(Element parentElement,
			Map<String, String> map)
	{
		String msg = "";
		Iterator<String> it = map.keySet().iterator();
		String tempStr = "";
		Element sonElement = null;
		while (it.hasNext()) {
			tempStr = it.next();
			msg = (map.get(tempStr)) == null ? "" : (map.get(tempStr) + "");
			sonElement = new Element(tempStr);
			parentElement.addContent(sonElement.setText(msg));
		}
		return parentElement;
	}

	/**
	 * ��ɲ������ݵĽڵ�
	 * @param root��ڵ�
	 * @param strArr
	 *            �ڵ��ַ�
	 */
	public static void createNodes(Element root, String[] strArr) 
	{
		Element e = null;
		for (String str : strArr) {
			e = new Element(str);
			root.addContent(e);
		}

	}
	
	
	
	/**
	 * <P>xml�ַ�ת����map����</P>
	 * @param xml·��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String xmlFileToString(String xmlPath,String rootName)
	{
		
		SAXBuilder builder = new SAXBuilder();
		Map<String, String> map = new HashMap<String, String>();
		try {
			Document doc = builder.build(new File(xmlPath));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element e : list) 
				map.put(e.getName(), e.getText());
		} catch (JDOMException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return mapToXml(map,rootName);	
	}
	
	
	
	public static void main(String args[]){
		String path=System.getProperty("user.dir")+"/src/upload_request.xml";
		System.out.println(path);
		String str=xmlFileToString(path,"request");
		System.out.println(str);
	}
	
}
