package com.pragmatic.framework.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Image utils.
 */
public class Image {

    /**
     * Load image from file.
     *
     * @param filePath path to image file.
     * @return image as BufferedImage.
     */
    public static BufferedImage fromFile(String filePath) {
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            try {
                return ImageIO.read(imageFile);
            } catch (IOException e) {
                throw new RuntimeException(String.format("Failed to read image from %s", filePath), e);
            }
        } else {
            throw new RuntimeException(String.format("Failed to read image from %s", filePath));
        }
    }

    /**
     * Convert BufferedImage to InputStream.
     *
     * @param image as BufferedImage.
     * @return InputStream
     * @throws IOException when fail to read image.
     */
    public static InputStream bufferedImageToInputStream(BufferedImage image) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        return new ByteArrayInputStream(os.toByteArray());
    }

    /**
     * Compare two images.
     *
     * @param actual   Actual image.
     * @param expected Expected image.
     * @return ImageComparisonResult.
     */
    public static ImageComparisonResult compare(BufferedImage actual,
                                                BufferedImage expected) {
        return compare(actual, expected, 0);
    }

    /**
     * Compare two images.
     *
     * @param actual          Actual image.
     * @param expected        Expected image.
     * @param pixelSimilarity If sum of RGB difference in less then pixelSimilarity then two pixels will be same.
     * @return ImageComparisonResult.
     */
    public static ImageComparisonResult compare(BufferedImage actual,
                                                BufferedImage expected,
                                                int pixelSimilarity) {
        Rectangle bounds = actual.getData().getBounds();
        org.openqa.selenium.Rectangle rectangle = new org.openqa.selenium.Rectangle(0, 0, bounds.height, bounds.width);
        return compare(actual, expected, rectangle, pixelSimilarity);
    }

    /**
     * Compare two images.
     *
     * @param actual          Actual image.
     * @param expected        Expected image.
     * @param comparisonArea  Rectangle to be compared (comapre full images if null).
     * @param pixelSimilarity If sum of RGB difference in less then pixelSimilarity then two pixels will be same.
     * @return ImageComparisonResult.
     */
    public static ImageComparisonResult compare(BufferedImage actual,
                                                BufferedImage expected,
                                                org.openqa.selenium.Rectangle comparisonArea,
                                                int pixelSimilarity) {
        long diffPixels = 0;
        double diffPercent;

        BufferedImage diffImage = copy(actual);

        int width = actual.getWidth();
        int height = actual.getHeight();
        int expectedWidth = expected.getWidth();
        int expectedHeight = expected.getHeight();

        if (width != expectedWidth || height != expectedHeight) {
            diffPixels = width * height;
            diffPercent = 100.0;
        } else {
            Color red = new Color(255, 0, 0);
            int redRgb = red.getRGB();

            for (int y = comparisonArea.y; y < comparisonArea.getHeight(); y++) {
                for (int x = comparisonArea.x; x < comparisonArea.getWidth(); x++) {
                    int result = pixelDiff(actual.getRGB(x, y), expected.getRGB(x, y));
                    if (result > pixelSimilarity) {
                        // Increase count in diffPixels
                        diffPixels++;
                        // Write different pixels in diffImage with red color
                        diffImage.setRGB(x, y, redRgb);

                    }
                }
            }
            diffPercent = (100 * diffPixels) / (double) (expectedWidth * expectedHeight);
        }

        return new ImageComparisonResult(diffPixels, diffPercent, actual, diffImage, expected);
    }

    /**
     * Save image to file.
     *
     * @param image    BufferedImage object.
     * @param filePath File path as String.
     */
    public static void save(BufferedImage image, String filePath) {
        try {
            FileSystem.createFolder(new File(filePath).getParent());
            ImageIO.write(image, "png", new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to save image at %s", filePath));
        }
    }

    private static int pixelDiff(int rgb1, int rgb2) {
        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >> 8) & 0xff;
        int b1 = rgb1 & 0xff;
        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >> 8) & 0xff;
        int b2 = rgb2 & 0xff;
        return Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
    }

    private static BufferedImage copy(BufferedImage source) {
        BufferedImage image = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = image.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return image;
    }
}