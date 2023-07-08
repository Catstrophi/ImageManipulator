package JavaImageManipulation;

public class IntensifyFilter implements Filter{
    private static final double[][] INTENSIFY_KERNEL = {
            { -1.0/16, -1.0/16, -1.0/16 },
            { -1.0/16, 28.0/16, -1.0/16 },
            { -1.0/16, -1.0/16, -1.0/16 }
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
                            double weight = INTENSIFY_KERNEL[i+1][j+1];
                            redSum += weight * data[y][x].getRed();
                            greenSum += weight * data[y][x].getGreen();
                            blueSum += weight * data[y][x].getBlue();
                        }
                    }
                }


                int redAvg = (int) Math.round(redSum);
                int greenAvg = (int) Math.round(greenSum);
                int blueAvg = (int) Math.round(blueSum);

                if(redSum>255){
                    redAvg = 255;
                }

                if(greenSum>255){
                    greenAvg = 255;
                }

                if(blueSum>255){
                    blueAvg = 255;
                }

                if(redSum<0){
                    redAvg = 0;
                }

                if(greenSum<0){
                    greenAvg = 0;
                }

                if(blueSum<0){
                    blueAvg = 0;
                }


                newData[row][col] = new Pixel(redAvg, greenAvg, blueAvg);
            }
        }

        pi.setData(newData);
    }
}
