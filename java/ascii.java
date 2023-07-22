import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ascii {
	BufferedImage img;
  String imagePath = "path-to-image";
	char[] pieces = { '.', '%', ' ', 'B', 'G', '0', 't', '^', '*', '\"', '\'', '`', '-', ',', '.', ' ' };
	int yBlocks, xBlocks, pxPerBlock;
	int[][] map;
	public static void main(String[] args) throws Exception {
		if (args.length > 0) new ascii(new File(args[0]), 1).printMap();
		else new ascii(new File(imagePath), 1).printMap();
	}
	public ascii(File f) throws IOException {
		this(f, 3);
	}
	public ascii(File f, int pixelsPerBlock) throws IOException {
		img = ImageIO.read(f);
		pxPerBlock = pixelsPerBlock;
		yBlocks = img.getHeight() / pxPerBlock;
		xBlocks = img.getWidth() / pxPerBlock;
		map = new int[yBlocks][xBlocks];
		for (int y = 0; y < yBlocks; y++) {
			for (int x = 0; x < xBlocks; x++) {
				int i = getGreyscaleOfArea(x * pxPerBlock, y * pxPerBlock);
				map[y][x] = i / 16;
			}
		}
	}
	private int getGreyscaleOfArea(int x, int y) {
		int counter = 0, sum = 0;
		for (int i = y; i < y + pxPerBlock; i++)
		for (int j = x; j < x + pxPerBlock; j++, counter++)
		sum += getGreyscale(Integer.toHexString(img.getRGB(j, i)));
		return sum / counter;
	}
	private int getGreyscale(String hex) {
		int r = Integer.valueOf(hex.substring(2, 4), 16);
		int g = Integer.valueOf(hex.substring(4, 6), 16);
		int b = Integer.valueOf(hex.substring(6, 8), 16);
		return (r + g + b) / 3;
	}
	public void printMap() {
		for (int i = 0; i < yBlocks; i++) {
			for (int j = 0; j < xBlocks; j++) System.out.print(pieces[map[i][j]]);
			System.out.print("\n");
		}
	}
	public void printToFile(FileWriter writer) throws IOException {
		for (int i = 0; i < yBlocks; i++) {
			for (int j = 0; j < xBlocks; j++) writer.write("" + pieces[map[i][j]]);
			writer.write("\n");
		}
	}
}