package uz.pdp.images;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

public class Files1 {
    public static InputFile readImage(){

        InputFile fg= new InputFile();

        fg.setMedia(new File("src/image/lamborgini.png"));

//        try {
//            URL obj = new URL("https://www.bmw.uz/content/dam/bmw/common/all-models/m-series/series-overview/bmw-m-series-seo-overview-ms-04.jpg");
////                        obj.
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
        return fg;
    }
    public static InputFile BMwM5(){
        InputFile f= new InputFile();
        f.setMedia(new File("src/image/BMW M5 Competition.png"));

        return f;
    }

    public static InputFile MercedesCls(){
        InputFile q= new InputFile();
        q.setMedia(new File("src/image/Mercedes-Benz CLS.png"));

        return q;
    }

    public static InputFile SpareParts(){
        InputFile w = new InputFile();
        w.setMedia(new File("src/image/SpareParts.png"));


        return w;
    }

    public  static InputFile R43(){
        InputFile qw = new InputFile();
        qw.setMedia(new File("src/image/nissan.jpg"));
        return qw;
    }

    public  static InputFile BMWMP4(){
        InputFile r = new InputFile();
        r.setMedia(new File("src/image/BMW.mp4"));

        return r;
    }
    public  static InputFile miata(){
        InputFile r = new InputFile();
        r.setMedia(new File("src/image/miata.mp4"));

        return r;
    }

    public static InputFile accessories(){
        InputFile g = new InputFile();
        g.setMedia(new File("src/image/accessories.png"));
        return g;
    }


}
