/**
 * 
 */
package ASCIIPicture.client;

import ASCIIPicture.common.Common;
import ASCIIPicture.util.ImageUtil;
import ASCIIPicture.util.ScaleImageUtil;
import ASCIIPicture.util.TextUtil;

public class Client {
	
	public static String SCALED_IMAGE = Common.SCALED + Common.FULL_STOP + ScaleImageUtil.getPostfix(Common.ORIGINAL);

	public static void main(String[] args) {
		painting(Common.ORIGINAL, SCALED_IMAGE, 0.2);
	}

	private static void painting(String originalImagePath, String scaledImagepath, double compressPercent) {
		ScaleImageUtil.saveImage(scaledImagepath, ScaleImageUtil.resize(originalImagePath, compressPercent));
		double[][] result = ImageUtil.getImageRGB(scaledImagepath);
		StringBuffer stringBuffer = ImageUtil.getCanvas(result);
		TextUtil.write2File(stringBuffer);
	}
}
