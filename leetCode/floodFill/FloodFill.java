package leetCode.floodFill;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] != newColor)
			changeColor(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	private void changeColor(int[][] image, int sr, int sc, int newColor, int origi) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != origi)
			return;
		image[sr][sc] = newColor;
		changeColor(image, sr + 1, sc, newColor, origi);
		changeColor(image, sr - 1, sc, newColor, origi);
		changeColor(image, sr, sc + 1, newColor, origi);
		changeColor(image, sr, sc - 1, newColor, origi);
	}
}
