package JavaImageManipulation;

public class GuassianBlurFilter1 implements Filter {
    private static final double[] GAUSSIAN_KERNEL =
            { 1.0/16, 2.0/16, 1.0/16,
             2.0/16, 4.0/16, 2.0/16 ,
             1.0/16, 2.0/16, 1.0/16 };

    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] result = new Pixel[data.length][data[0].length];

        for (int row = 1; row < data.length - 1; row++) {
            for (int col = 1; col < data[row].length - 1; col++) {
                int red = 0, green = 0, blue = 0;
                int index = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        Pixel temp = data[row + i][col + j];
                        red += temp.getRed() * GAUSSIAN_KERNEL[index];
                        green += temp.getGreen() * GAUSSIAN_KERNEL[index];
                        blue += temp.getBlue() * GAUSSIAN_KERNEL[index];
                        index++;
                    }
                }
                int redAvg = (int) Math.round(red);
                int greenAvg = (int) Math.round(green);
                int blueAvg = (int) Math.round(blue);
                result[row][col] = new Pixel(redAvg, greenAvg, blueAvg);

            }
        }

        pi.setData(result);
    }
}