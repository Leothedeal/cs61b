package synthesizer;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdAudio;

public class GuitarHero {
    static GuitarString[] str = new GuitarString[37];
    static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static double calFrequency(int i) {
        return 440.0 * Math.pow(2, (i - 24) / 12);
    }

    public static void main(String[] args) {
        for (int i = 0; i < str.length; i++) {
            synthesizer.GuitarString stringX = new synthesizer.GuitarString(calFrequency(i));
            str[i] = stringX;
        }
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if(index>0){
                str[index].pluck();}
            }
            double sample=0;
            for(int i=0;i<str.length;i++){
                sample+=str[i].sample();
            }
            StdAudio.play(sample);
            for(int i=0;i<str.length;i++){
                str[i].tic();
            }
        }
    }
}