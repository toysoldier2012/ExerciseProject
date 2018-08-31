/**
 * 
 */

package ASCIIPicture.util;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import ASCIIPicture.common.Common;

public class ImageUtil {

	private static int height = 0;
	private static int width = 0;

	public static void colorImageToBlackAndWhitePicture(String input, String output) {
		try {
			BufferedImage src = ImageIO.read(new File(input));
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			src = op.filter(src, null);
			ImageIO.write(src, "JPEG", new File(output));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static double[][] getImageRGB(String filePath) {
		File file = new File(filePath);
		double[][] result = null;
		if (!file.exists()) {
			return result;
		}
		try {
			BufferedImage bufImg = readImage(file);
			result = new double[height][width];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					double temp = Double.valueOf(bufImg.getRGB(x, y) & 0xFFFFFF);
					result[y][x] = Math.floor(Math.cbrt(temp));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Read the original image to convert BufferedImage
	 * @param file Original image path
	 * @return
	 * @see BufferedImage
	 * @throws IOException
	 */
	private static BufferedImage readImage(File file) throws IOException {
		BufferedImage bufImg = ImageIO.read(file);
		height = bufImg.getHeight();
		width = bufImg.getWidth();
		return bufImg;
	}
	
	/**
	 * Get the canvas, which is made up of alphabets.
	 * @param result
	 * @return
	 */
	public static StringBuffer getCanvas(double[][] result) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				fullBlank(result, stringBuffer, y, x);
			}
			stringBuffer.append(Common.NEW_LINE);
		}
		return new StringBuffer(stringBuffer.substring(0, stringBuffer.length() - 1));
	}

	/**
	 * Full blank
	 * @param result
	 * @param stringBuffer
	 * @param y
	 * @param x
	 */
	private static void fullBlank(double[][] result, StringBuffer stringBuffer, int y, int x) {
		if (result[y][x] > 0.0 && result[y][x] < 168.0) {
			fullBlackColor(result, stringBuffer, y, x);
		} else if (result[y][x] >= 168.0 && result[y][x] < 212.0) {
			fullGreyColor(result, stringBuffer, y, x);
		} else {
			fullWhiteColor(result, stringBuffer, y, x);
		}
	}

	/**
	 * Full black color, and you can change the alphabet if you need.
	 * @param result
	 * @param stringBuffer
	 * @param y
	 * @param x
	 */
	private static void fullBlackColor(double[][] result, StringBuffer stringBuffer, int y, int x) {
		if (result[y][x] > 0.0 && result[y][x] < 25.0) {
			stringBuffer.append(Common.R);
		} else if (result[y][x] >= 25.0 && result[y][x] < 50.0) {
			stringBuffer.append(Common.R);
		} else if (result[y][x] >= 50.0 && result[y][x] < 75.0) {
			stringBuffer.append(Common.R);
		} else if (result[y][x] >= 75.0 && result[y][x] < 100.0) {
			stringBuffer.append(Common.A);
		} else if (result[y][x] >= 100.0 && result[y][x] < 125.0) {
			stringBuffer.append(Common.A);
		} else if (result[y][x] >= 125.0 && result[y][x] < 150.0) {
			stringBuffer.append(Common.X);
		} else if (result[y][x] >= 150.0 && result[y][x] < 154.0) {
			stringBuffer.append(Common.X);
		} else if (result[y][x] >= 154.0 && result[y][x] < 158.0) {
			stringBuffer.append(Common.M);
		} else if (result[y][x] >= 158.0 && result[y][x] < 162.0) {
			stringBuffer.append(Common.M);
		} else if (result[y][x] >= 162.0 && result[y][x] < 168.0) {
			stringBuffer.append(Common.W);
		}
	}

	/**
	 * Full grey color
	 * @param result
	 * @param stringBuffer
	 * @param y
	 * @param x
	 */
	private static void fullGreyColor(double[][] result, StringBuffer stringBuffer, int y, int x) {
		if (result[y][x] >= 168.0 && result[y][x] < 172.0) {
			stringBuffer.append(Common.H);
		} else if (result[y][x] >= 172.0 && result[y][x] < 176.0) {
			stringBuffer.append(Common.E);
		} else if (result[y][x] >= 176.0 && result[y][x] < 180.0) {
			stringBuffer.append(Common.H);
		} else if (result[y][x] >= 180.0 && result[y][x] < 184.0) {
			stringBuffer.append(Common.H);
		} else if (result[y][x] >= 184.0 && result[y][x] < 188.0) {
			stringBuffer.append(Common.J);
		} else if (result[y][x] >= 188.0 && result[y][x] < 192.0) {
			stringBuffer.append(Common.L);
		} else if (result[y][x] >= 192.0 && result[y][x] < 196.0) {
			stringBuffer.append(Common.C);
		} else if (result[y][x] >= 196.0 && result[y][x] < 200.0) {
			stringBuffer.append(Common.V);
		} else if (result[y][x] >= 200.0 && result[y][x] < 204.0) {
			stringBuffer.append(Common.Z);
		} else if (result[y][x] >= 204.0 && result[y][x] < 208.0) {
			stringBuffer.append(Common.Q);
		} else if (result[y][x] >= 208.0 && result[y][x] < 212.0) {
			stringBuffer.append(Common.T);
		}
	}

	/**
	 * Full white color
	 * @param result
	 * @param stringBuffer
	 * @param y
	 * @param x
	 */
	private static void fullWhiteColor(double[][] result, StringBuffer stringBuffer, int y, int x) {
		if (result[y][x] >= 212.0 && result[y][x] < 216.0) {
			stringBuffer.append(Common.r);
		} else if (result[y][x] >= 216.0 && result[y][x] < 220.0) {
			stringBuffer.append(Common.s);
		} else if (result[y][x] >= 220.0 && result[y][x] < 224.0) {
			stringBuffer.append(Common.w);
		} else if (result[y][x] >= 224.0 && result[y][x] < 228.0) {
			stringBuffer.append(Common.u);
		} else if (result[y][x] >= 228.0 && result[y][x] < 232.0) {
			stringBuffer.append(Common.l);
		} else if (result[y][x] >= 232.0 && result[y][x] < 236.0) {
			stringBuffer.append(Common.i);
		} else if (result[y][x] >= 236.0 && result[y][x] < 240.0) {
			stringBuffer.append(Common.e);
		} else if (result[y][x] >= 240.0 && result[y][x] < 244.0) {
			stringBuffer.append(Common.m);
		} else if (result[y][x] >= 244.0 && result[y][x] < 248.0) {
			stringBuffer.append(Common.a);
		} else if (result[y][x] >= 248.0 && result[y][x] < 252.0) {
			stringBuffer.append(Common.COMMA);
		} else if (result[y][x] >= 252.0 && result[y][x] < 257.0) {
			stringBuffer.append(Common.BLANK);
		}
	}
}
