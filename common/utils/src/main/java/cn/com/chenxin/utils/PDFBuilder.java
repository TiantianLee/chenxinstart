package cn.com.chenxin.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import cn.com.chenxin.utils.PdfHeaderFooter;

/**
 * ClassName:PDFBuilder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2013-9-13 下午03:35:53 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.5
 * @see
 */
public class PDFBuilder {
    private int pageHeight;
    private int pageWidth;

    public PDFBuilder() {
    }

    public static PDFBuilder getInstance() {
        return new PDFBuilder();
    }

    public void generatePDF(String fileName) throws Exception {
        Document document = new Document(new Rectangle(pageWidth, pageHeight));
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        this.setFooter(writer);
        writer.setFullCompression();
        writer.setPdfVersion(PdfWriter.VERSION_1_4);
//        document.open();
        // Set pdf version to 1.4
//        PdfContentByte cb = writer.getDirectContent();
//        ColumnText ct = new ColumnText(cb);
//        for (int i = 0; i < 10; i++) {
//            document.newPage();
//            // 如果不设置 空白页无法单独显示
//            writer.setPageEmpty(false);
//        }
//        document.close();
    }

    private void setFooter(PdfWriter writer) throws DocumentException, IOException {
        // HeaderFooter headerFooter = new HeaderFooter(this);
        // 更改事件，瞬间变身 第几页/共几页 模式。
        PdfHeaderFooter headerFooter = new PdfHeaderFooter("啦啦啦啦", 12, PageSize.A4);// 就是上面那个类
        writer.setBoxSize("art", PageSize.A4);
        writer.setPageEvent(headerFooter);
    }

    public int getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(int pageHeight) {
        this.pageHeight = pageHeight;
    }

    public int getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(int pageWidth) {
        this.pageWidth = pageWidth;
    }

}
