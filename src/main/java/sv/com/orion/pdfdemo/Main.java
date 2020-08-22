/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.orion.pdfdemo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

/**
 *
 * @author desa
 */
public class Main {

    public static void main(String[] args) {
        try {
            PDDocument doc = PDDocument.load(new File("C:\\temp\\test.pdf"));
            PDFRenderer pdfr = new PDFRenderer(doc);
            for (int i = 0; i < doc.getNumberOfPages(); i++) {
                BufferedImage bi = pdfr.renderImageWithDPI(i, 300, ImageType.RGB);
                String fileName = "C:\\temp\\image-" + i + ".png";
                ImageIOUtil.writeImage(bi, fileName, 300);
            }
            doc.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
