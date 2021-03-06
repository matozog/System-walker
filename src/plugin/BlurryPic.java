package plugin;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GrayFilter;


public class BlurryPic extends PictureManager {

	public BlurryPic(String imagePath) {
		super(imagePath);
	}

	public Image blurryPic() {
		BufferedImage blurredImg = null;
		
		float[] matrix = new float[100];
		for (int i = 0; i < 100; i++)
			matrix[i] = 1.0f/100.0f;
		
	    BufferedImageOp op = new ConvolveOp(new Kernel(10, 10, matrix));
	    blurredImg = op.filter(bufferedImg, blurredImg);
		
		return blurredImg;
	}
}
