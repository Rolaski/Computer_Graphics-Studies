package Lab02;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    String version = "0.02";

    public static void main(String[] args) {

        Renderer mainRenderer = new Renderer(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        mainRenderer.clear();
//        mainRenderer.drawLineBresenham(600,600, 300,300);
        mainRenderer.drawLine(0,0,200,50, Renderer.LineAlgo.valueOf(args[3]));
//        mainRenderer.drawLineNaive(599,599,500,100);
//        mainRenderer.drawLineBresenham(600,600, 300,300);
        try {
            mainRenderer.save();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getVersion() {
        return this.version;
    }
}