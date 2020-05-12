package solutions;

public class Day11_FloodFill {

	public static int[][] floodFill(int[][] image, int r, int c, int newColor) {
		// If the pixel already has new color, return the image as it is
		if (image[r][c] == newColor) {
			return image;
		}
		int oldColor = image[r][c];
		image = backtrack(image, r, c, newColor, oldColor);
		
		return image;
	}

	private static int[][] backtrack(int[][] image, int r, int c, int newColor, int oldColor) {
		// Base case: make sure current pixel is not outside of the image
		if (r >= image.length || r < 0 || c >= image[0].length || c < 0 || image[r][c] == newColor || image[r][c] != oldColor) {
			return image;
		}

		// Set the new color to current pixel
		image[r][c] = newColor;

		// Backtrack for all 4 directions of current pixel
		backtrack(image, r + 1, c, newColor, oldColor);
		backtrack(image, r - 1, c, newColor, oldColor);
		backtrack(image, r, c + 1, newColor, oldColor);
		backtrack(image, r, c - 1, newColor, oldColor);
		return image;
	}

//	private static void printImage(int[][] image) {
//		for (int i = 0; i < image.length; i++) {
//			for (int j = 0; j < image[0].length; j++) {
//				System.out.print(image[i][j]);
//			}
//			System.out.println();
//		}
//	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, newColor = 2;
		System.out.println(floodFill(image, sr, sc, newColor));
	}

}
