package JavaImageManipulation;

public class LightenBy10Filter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                Pixel temp = data[row][col];
                int red = temp.getRed()+10;
                int blue = temp.getBlue()+10;
                int green = temp.getGreen()+10;

                if(red>255){
                    red = 255;
                }
                if(blue>255){
                    blue = 255;
                }
                if(green>255){
                    green = 255;
                }
                Pixel px = new Pixel(red, blue, green);
                data[row][col] = px;
            }
        }
        pi.setData(data);
    }
}
