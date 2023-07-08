package JavaImageManipulation;

public class NegativeImageFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                Pixel temp = data[row][col];
                int red = 255 - temp.getRed();
                int blue = 255 - temp.getBlue();
                int green = 255 - temp.getGreen();
                Pixel px = new Pixel(red, blue, green);
                data[row][col] = px;
            }
        }
        pi.setData(data);
    }
}
