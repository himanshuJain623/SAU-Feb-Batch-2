import java.io.*;
import java.util.*;

class SingleThread implements Runnable {
    String str;

    SingleThread(String str) {
        this.str = str;
    }

    public void run() {
        long words = 0;
        char ch[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
            if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
                words++;
        }
        System.out.println("Words count: " + words);
    }
}

public class CountSingleThread {
    public static void main(String[] args) {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent sit amet est porta, imperdiet quam id, scelerisque nisi"
                + "Mauris finibus quam ac magna placerat cursus. Phasellus pharetra elit nisl."
                + "Mauris mollis interdum lacinia. Donec eu tellus finibus, convallis neque ut, tincidunt dolor. Curabitur mollis, nunc in consectetur aliquam, ante mauris consequat leo,"
                + "quis facilisis neque tellus vel dui. Maecenas in pharetra nisi. Integer euismod, ligula nec condimentum lacinia, ligula massa condimentum orci, sit amet tincidunt urna magna a lacus."
                + " Vivamus lacinia suscipit sollicitudin. Donec sagittis sagittis metus, vitae consequat justo mattis eu. Vestibulum cursus urna tortor, ut tincidunt mi mollis et. Nulla molestie lacinia urna, at tempor urna laoreet ultrices."
                + "Phasellus egestas nulla nec eros pellentesque, vitae cursus nibh condimentum. In sollicitudin nunc et neque pulvinar feugiat."
                + " Fusce id purus finibus, placerat turpis sed, elementum dolor. Donec ac lacus ornare, bibendum justo a, rutrum risus."
                + " Fusce malesuada accumsan nisi in viverra. Donec fringilla, lectus non lacinia auctor, odio magna imperdiet purus,"
                + " sit amet vulputate ligula dui ac arcu. Duis eget enim justo. Fusce tincidunt, tellus ut sodales vestibulum, sapien nibh hendrerit arcu, luctus venenatis libero quam a sem."
                + " Mauris vehicula posuere justo, eget auctor orci varius nec. Mauris finibus augue quis volutpat dignissim.";

        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new SingleThread(str));
        t1.start();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("Time Taken: " + time + " ms" + " with single thread");
    }
}
