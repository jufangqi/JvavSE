package edu.Oracle.D5;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Created by 存 on 2016/6/7.
 */
public class D601 {

    public static void main(String[] args) throws Exception {
        new D601().Reader("");
    }

    public void Write() throws Exception {
        Document dom = DocumentHelper.createDocument();//创建
        Element returnsms = DocumentHelper.createElement("returnsms");//创建节点
        Element returnstatus = DocumentHelper.createElement("returnstatus");
        Element message = DocumentHelper.createElement("message");
        Element remainpoint = DocumentHelper.createElement("remainpoint");
        Element taskID = DocumentHelper.createElement("taskID");
        Element successCounts = DocumentHelper.createElement("successCounts");

        dom.setRootElement(returnsms);//设置根节点
        returnsms.add(successCounts);
        returnsms.add(taskID);
        returnsms.add(message);
        returnsms.add(returnstatus);
        returnsms.add(remainpoint);

        OutputFormat of = new OutputFormat(" ", true);//设置格式
        XMLWriter xw = new XMLWriter(of);
        xw.write(dom);
    }

    public void Reader(String temp) throws Exception {
        SAXReader sr = new SAXReader();
        Document document = sr.read("E://Temp/xm.xml");
        Element root = document.getRootElement();
//        Element taskID = root.element("returnstatus");
        List<Element> list = root.elements();
        for (Element e : list) {
            System.out.println(e.getName() + ":" + e.getText());
        }
    }
}