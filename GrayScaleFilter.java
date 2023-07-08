package JavaImageManipulation;

public class GrayScaleFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                Pixel temp = data[row][col];
                int grey = (temp.getBlue() + temp.getGreen() + temp.getRed())/3;
                Pixel px = new Pixel(grey, grey, grey);
                data[row][col] = px;
            }
        }
        pi.setData(data);
    }
}
