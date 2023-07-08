package JavaImageManipulation;

public class EmbossFilter implements Filter{
    private static final double[][] EMBOSS_KERNEL = {
            { -1.0, -1.0, -1.0 },
            { -1.0, 9.0, -1.0 },
            { -1.0, -1.0, -1.0 }
    };

    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] newData = new Pixel[data.length][data[0].length];

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {

                double redSum = 0.0;
                double greenSum = 0.0;
                double blueSum = 0.0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int x = col + j;
                        int y = row + i;
                        if (x >= 0 && x < data[row].length && y >= 0 && y < data.length) {
                            double weight = EMBOSS_KERNEL[i+1][j+1];
                            redSum += weight * data[y][x].getRed();
                            greenSum += weight * data[y][x].getGreen();
                            blueSum += weight * data[y][x].getBlue();
                        }
                    }
                }

                int redAvg = (int) Math.round(redSum);
                int greenAvg = (int) Math.round(greenSum);
                int blueAvg = (int) Math.round(blueSum);

                redAvg = Math.max(0, Math.min(redAvg, 255));
                greenAvg = Math.max(0, Math.min(greenAvg, 255));
                blueAvg = Math.max(0, Math.min(blueAvg, 255));

                newData[row][col] = new Pixel(redAvg, greenAvg, blueAvg);
            }
        }

        pi.setData(newData);
    }
}
