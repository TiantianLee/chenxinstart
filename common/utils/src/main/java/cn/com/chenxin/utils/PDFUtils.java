package cn.com.chenxin.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * PDF 转换工具
 * 
 * @author LIYANG
 *
 */
public class PDFUtils {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(PDFUtils.class);

    public static String getHtmlDoc(String htmlPath) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(htmlPath)));
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 创建PDF文档
     * 
     * @param htmlDoc
     *            html模板内容
     * @param params
     *            参数
     * @param targetFolder
     *            生成后的目标文件夹
     * @param fileName
     *            生成的文件名
     * @param type
     *            1:借款合同 2：理财合同 3：债转合同
     * @return
     */
    public static String genPdfFromHtml(String htmlPath, String[] params, String targetFolder, String fileName, int type) {
        String htmlDoc = getHtmlDoc(htmlPath);
        System.out.println("htmlDoc:" + htmlDoc);
        // 创建文档，大小为A4
        Document document = new Document(PageSize.A4);

        String completeFilePath = null;
        try {
            String filePath = null;
            // 获取PDFWriter
            String name = fileName + "tmp" + System.currentTimeMillis() + ".pdf";
            String complateFileName = fileName + System.currentTimeMillis() + ".pdf";

            filePath = targetFolder + "/" + name;
            completeFilePath = targetFolder + "/" + name;
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(filePath)));
            document.open();
            // String result = String.format(htmlDoc, params);
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlDoc.getBytes()), Charset.forName("UTF8"));
            document.close();
            filePath = targetFolder + "/" + name;

        } catch (FileNotFoundException e) {
            logger.error("生成PDF文件是否发生错误：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (DocumentException e) {
            logger.error("创建PDF文件时发生DocumentException：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            logger.error("创建PDF时发生IOException:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return completeFilePath;
    }

    /**
     * 创建PDF文档
     * 
     * @param is
     *            IO流
     * @param targetFolder
     *            目标文件路径
     * @param fileName
     *            文件名
     * @param charset
     *            编码格式
     * @param warterName
     *            水印内容
     * @return
     */
    public static String genPdfFromHtmlStream(InputStream is, String targetFolder, String fileName, Charset charset) {
        // 创建文档，大小为A4
        Document document = new Document(PageSize.A4);

        String completeFilePath = null;
        try {
            String filePath = null;
            // 获取PDFWriter
            String name = fileName + "tmp" + System.currentTimeMillis() + ".pdf";
            String complateFileName = fileName + System.currentTimeMillis() + ".pdf";

            filePath = targetFolder + "/" + name;
            completeFilePath = targetFolder + "/" + name;
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(filePath)));
            document.open();
            // String result = String.format(htmlDoc, params);
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is, charset);
            document.close();

            filePath = targetFolder + "/" + name;

        } catch (FileNotFoundException e) {
            logger.error("生成PDF文件是否发生错误：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (DocumentException e) {
            logger.error("创建PDF文件时发生DocumentException：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            logger.error("创建PDF时发生IOException:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return completeFilePath;
    }

    /**
     * 创建PDF文档(加入水印)
     * 
     * @param is
     *            IO流
     * @param targetFolder
     *            目标文件路径
     * @param fileName
     *            文件名
     * @param charset
     *            编码格式
     * @param warterName
     *            水印内容
     * @return
     */
    public static String genPdfFromHtmlStream(InputStream is, String targetFolder, String fileName, Charset charset, String waterName) {
        // 创建文档，大小为A4
        Document document = new Document(PageSize.A4);

        String completeFilePath = null;
        String complateFilePath = null;
        try {
            String filePath = null;
            // 获取PDFWriter
            String name = fileName + "tmp" + System.currentTimeMillis() + ".pdf";
            String complateFileName = fileName + System.currentTimeMillis() + ".pdf";

            filePath = targetFolder + "/" + name;
            completeFilePath = targetFolder + "/" + name;
            complateFilePath = targetFolder + "/" + complateFileName;
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(filePath)));
            document.open();
            // String result = String.format(htmlDoc, params);
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is, charset);
            document.close();
            addWaterMark(completeFilePath, complateFilePath, waterName, 400, 880);
            // PDFBuilder builder = new PDFBuilder();
            // builder.setPageHeight(400);
            // builder.setPageWidth(600);
            // builder.generatePDF(complateFilePath);

        } catch (FileNotFoundException e) {
            logger.error("生成PDF文件是否发生错误：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (DocumentException e) {
            logger.error("创建PDF文件时发生DocumentException：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            logger.error("创建PDF时发生IOException:" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            logger.error("创建PDF时发生Exception:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return complateFilePath;
    }

    /**
     * 创建PDF文档(加入水印,页眉)
     * 
     * @param is
     *            IO流
     * @param targetFolder
     *            目标文件路径
     * @param fileName
     *            文件名
     * @param charset
     *            编码格式
     * @param warterName
     *            水印内容
     * @return
     */
    public static String genPdfFromHtmlStream(InputStream is, String targetFolder, String fileName, Charset charset, String waterName,String yemei) {
        // 创建文档，大小为A4
        Document document = new Document(PageSize.A4);

        String completeFilePath = null;
        String complateFilePath = null;
        try {
            String filePath = null;
            // 获取PDFWriter
            String name = fileName + "tmp" + System.currentTimeMillis() + ".pdf";
            String complateFileName = fileName + System.currentTimeMillis() + ".pdf";

            filePath = targetFolder + "/" + name;
            completeFilePath = targetFolder + "/" + name;
            complateFilePath = targetFolder + "/" + complateFileName;
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(filePath)));
            writer.setPageEvent(new PdfHeaderFooter(yemei, 10, PageSize.A4));
            document.open();
            // String result = String.format(htmlDoc, params);
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is, charset);
//            Image image = Image.getInstance ("E:\\封底.jpg");
//            document.add(new Paragraph(""));
//            document.add(image); 
            document.close();
//            
            addWaterMark(completeFilePath, complateFilePath, waterName, 400, 880);
           
            // PDFBuilder builder = new PDFBuilder();
            // builder.setPageHeight(400);
            // builder.setPageWidth(600);
            // builder.generatePDF(complateFilePath);

        } catch (FileNotFoundException e) {
            logger.error("生成PDF文件是否发生错误：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (DocumentException e) {
            logger.error("创建PDF文件时发生DocumentException：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            logger.error("创建PDF时发生IOException:" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            logger.error("创建PDF时发生Exception:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return complateFilePath;
    }

    /**
     * 创建PDF文档(加入水印,页眉,封底)
     * 
     * @param is
     *            IO流
     * @param targetFolder
     *            目标文件路径
     * @param fileName
     *            文件名
     * @param charset
     *            编码格式
     * @param warterName
     *            水印内容
     * @param imagurl
     *            封底图片路径
     * @return
     */
    public static String genPdfFromHtmlStream(InputStream is, String targetFolder, String fileName, Charset charset, String waterName,String yemei,String imagurl,String fmimg) {
        // 创建文档，大小为A4
        Document document = new Document(PageSize.A4);

        String completeFilePath = null;
        String complateFilePath = null;
        try {
            String filePath = null;
            // 获取PDFWriter
            String name = fileName + "tmp" + System.currentTimeMillis() + ".pdf";
            String complateFileName = fileName + System.currentTimeMillis() + ".pdf";

            filePath = targetFolder + "/" + name;
            completeFilePath = targetFolder + "/" + name;
            complateFilePath = targetFolder + "/" + complateFileName;
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(filePath)));
            writer.setPageEvent(new PdfHeaderFooter(yemei, 10, PageSize.A4));
            document.open();
            
            Image tImgCover = Image.getInstance(fmimg);   
            /* 设置图片的位置 */  
            tImgCover.setAbsolutePosition(0, 0);  
            /* 设置图片的大小 */  
            tImgCover.scaleAbsolute(595, 842);  
            document.add(tImgCover);     
            // String result = String.format(htmlDoc, params);
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is, charset);
            Image image = Image.getInstance (imagurl);
            document.add(new Paragraph(""));
            /* 设置图片的位置 */  
           // image.setAbsolutePosition(0, 0);  
            /* 设置图片的大小 */  
            image.scaleAbsolute(595, 842);  
            document.add(image); 
            document.close();
//            
            addWaterMark(completeFilePath, complateFilePath, waterName, 400, 880);
           
            // PDFBuilder builder = new PDFBuilder();
            // builder.setPageHeight(400);
            // builder.setPageWidth(600);
            // builder.generatePDF(complateFilePath);

        } catch (FileNotFoundException e) {
            logger.error("生成PDF文件是否发生错误：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (DocumentException e) {
            logger.error("创建PDF文件时发生DocumentException：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            logger.error("创建PDF时发生IOException:" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            logger.error("创建PDF时发生Exception:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return complateFilePath;
    }
    
    /**
     * 生成水印
     * 
     * @param pdfpath
     * @param completePDFpath
     * @param imagepath
     * @param pagenum
     * @throws Exception
     */
    public static void insertImageToPdf(String pdfpath, String completePDFpath, String imagepath) {
        try {
            PdfReader reader = new PdfReader(pdfpath, "World".getBytes());// 选择需要印章的pdf
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(completePDFpath));// 加完印章后的pdf
            PdfContentByte over = stamp.getOverContent(1);// 设置在第几页打印印章
            Image img = Image.getInstance(imagepath);// 选择图片
            img.setAlignment(1);
            img.scaleAbsolute(120, 120);// 控制图片大小
            img.setAbsolutePosition(100, 400);// 控制图片位置
            over.addImage(img);
            stamp.close();

            File file = new File(pdfpath);
            logger.info("将要删除：" + pdfpath);
            if (file.exists())
                logger.info("删除：" + pdfpath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入合同印章失败，合同生成失败");
        }
    }

    /**
     * 
     * 【功能描述：添加图片和文字水印】 【功能详细描述：功能详细描述】
     * 
     * @param srcFile
     *            待加水印文件
     * @param destFile
     *            加水印后存放地址
     * @param text
     *            加水印的文本内容
     * @param textWidth
     *            文字横坐标
     * @param textHeight
     *            文字纵坐标
     * @throws Exception
     */
    private static void addWaterMark(String srcFile, String destFile, String text, int textWidth, int textHeight) throws Exception {
        // 待加水印的文件
        PdfReader reader = new PdfReader(srcFile);
        // 加完水印的文件
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destFile));
        int total = reader.getNumberOfPages() + 1;
        Rectangle pageRectangle = new Rectangle(PageSize.A4);
        addWatermark(stamper, pageRectangle, total, text);
        stamper.close();
    }

    private static void addWatermark(PdfStamper stamper, Rectangle pageRectangle, int waterMarkCount, String waterMarkName) {
        PdfContentByte content;
        BaseFont base = null;
        try {
            // 设置字体
            // base = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,
            // BaseFont.NOT_EMBEDDED);
            String system = System.getProperties().getProperty("os.name");
            if (system.indexOf("indow") != -1) {//Windows
                base = BaseFont.createFont("C:/Windows/Fonts/SIMYOU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 使用系统字体
            } else {//Linux
                base = BaseFont.createFont("/usr/share/fonts/default/TrueType/SIMYOU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 使用系统字体
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 计算水印X,Y坐标
        float x = pageRectangle.getWidth() / 2;
        float y = pageRectangle.getHeight() / 2;
        for (int i = 2; i < waterMarkCount; i++) {
            content = stamper.getOverContent(i);// 获得PDF最顶层
            content.saveState();
            // set Transparency
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.1f);// 设置透明度为0.2
            content.setGState(gs);

            content.beginText();
            content.setColorFill(BaseColor.GRAY);
            content.setFontAndSize(base, 100);
            // waterMarkName = "chinecredit";
            content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, x, y, 35);// 水印文字成35度角倾斜
            content.endText();
            content.beginText();

            content.setColorFill(BaseColor.GRAY);
            content.setFontAndSize(base, 40);
//            String seeAttached = "creditChongZhou";
            String seeAttached = "";
            content.showTextAligned(Element.ALIGN_CENTER, seeAttached, x, y - 82, 35);
            content.endText();

            content.restoreState();// 注意这里必须调用一次restoreState 否则设置无效

        }
    }

}
