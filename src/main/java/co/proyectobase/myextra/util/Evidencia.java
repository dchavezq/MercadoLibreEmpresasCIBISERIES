package co.proyectobase.myextra.util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import net.serenitybdd.core.Serenity;

public class Evidencia {
	

	public static void captureScreen() {
		try 
		{
            Robot rbRobot = new Robot();
            Properties propiedad = new Properties();
            propiedad.load(new FileReader("myExtra.properties"));
            String ruta = propiedad.getProperty("rutaEvidencia");
            Rectangle recCapture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = rbRobot.createScreenCapture(recCapture);
            ImageIO.write(Image, "png", new File(ruta));
            Serenity.getWebdriverManager().getCurrentDriver().get(ruta);
            Serenity.takeScreenshot();
        }
        catch (AWTException | IOException ex) {
            System.out.println(ex);
        }
		
	}

}
