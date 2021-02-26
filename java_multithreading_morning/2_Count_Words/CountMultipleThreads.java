import java.io.*;
import java.util.*;
public class CountMultipleThreads
{
    public static void main(String[] args) 
       {  
            String str1 ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent sit amet est porta, imperdiet quam id, scelerisque nisi"+
            "Mauris finibus quam ac magna placerat cursus. Phasellus pharetra elit nisl."+"Mauris mollis interdum lacinia. Donec eu tellus finibus, convallis neque ut, tincidunt dolor. Curabitur mollis, nunc in consectetur aliquam, ante mauris consequat leo,"+
            "quis facilisis neque tellus vel dui. Maecenas in pharetra nisi. Integer euismod, ligula nec condimentum lacinia, ligula massa condimentum orci, sit amet tincidunt urna magna a lacus."+
            " Vivamus lacinia suscipit sollicitudin. Donec sagittis sagittis metus, vitae consequat justo mattis eu. Vestibulum cursus urna tortor, ut tincidunt mi mollis et. Nulla molestie lacinia urna, at tempor urna laoreet ultrices."+
            "Phasellus egestas nulla nec eros pellentesque, vitae cursus nibh condimentum. In sollicitudin nunc et neque pulvinar feugiat."+
            " Fusce id purus finibus, placerat turpis sed, elementum dolor. Donec ac lacus ornare, bibendum justo a, rutrum risus."+
            " Fusce malesuada accumsan nisi in viverra. Donec fringilla, lectus non lacinia auctor, odio magna imperdiet purus,"+
            " sit amet vulputate ligula dui ac arcu. Duis eget enim justo. Fusce tincidunt, tellus ut sodales vestibulum, sapien nibh hendrerit arcu, luctus venenatis libero quam a sem."+
            " Mauris vehicula posuere justo, eget auctor orci varius nec. Mauris finibus augue quis volutpat dignissim.";
            		
            String str2 ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent sit amet est porta, imperdiet quam id, scelerisque nisi"+
            "Mauris finibus quam ac magna placerat cursus. Phasellus pharetra elit nisl."+"Mauris mollis interdum lacinia. Donec eu tellus finibus, convallis neque ut, tincidunt dolor. Curabitur mollis, nunc in consectetur aliquam, ante mauris consequat leo,"+
            "quis facilisis neque tellus vel dui. Maecenas in pharetra nisi. Integer euismod, ligula nec condimentum lacinia, ligula massa condimentum orci, sit amet tincidunt urna magna a lacus."+
            " Vivamus lacinia suscipit sollicitudin. Donec sagittis sagittis metus, vitae consequat justo mattis eu. Vestibulum cursus urna tortor, ut tincidunt mi mollis et. Nulla molestie lacinia urna, at tempor urna laoreet ultrices."+
            "Phasellus egestas nulla nec eros pellentesque, vitae cursus nibh condimentum. In sollicitudin nunc et neque pulvinar feugiat."+
            " Fusce id purus finibus, placerat turpis sed, elementum dolor. Donec ac lacus ornare, bibendum justo a, rutrum risus."+
            " Fusce malesuada accumsan nisi in viverra. Donec fringilla, lectus non lacinia auctor, odio magna imperdiet purus,"+
            " sit amet vulputate ligula dui ac arcu. Duis eget enim justo. Fusce tincidunt, tellus ut sodales vestibulum, sapien nibh hendrerit arcu, luctus venenatis libero quam a sem."+
            " Mauris vehicula posuere justo, eget auctor orci varius nec. Mauris finibus augue quis volutpat dignissim."+"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent sit amet est porta, imperdiet quam id, scelerisque nisi"+
            "Mauris finibus quam ac magna placerat cursus. Phasellus pharetra elit nisl."+"Mauris mollis interdum lacinia. Donec eu tellus finibus, convallis neque ut, tincidunt dolor. Curabitur mollis, nunc in consectetur aliquam, ante mauris consequat leo,"+
            "quis facilisis neque tellus vel dui. Maecenas in pharetra nisi. Integer euismod, ligula nec condimentum lacinia, ligula massa condimentum orci, sit amet tincidunt urna magna a lacus."+
            " Vivamus lacinia suscipit sollicitudin. Donec sagittis sagittis metus, vitae consequat justo mattis eu. Vestibulum cursus urna tortor, ut tincidunt mi mollis et. Nulla molestie lacinia urna, at tempor urna laoreet ultrices."+
            "Phasellus egestas nulla nec eros pellentesque, vitae cursus nibh condimentum. In sollicitudin nunc et neque pulvinar feugiat."+
            " Fusce id purus finibus, placerat turpis sed, elementum dolor. Donec ac lacus ornare, bibendum justo a, rutrum risus."+
            " Fusce malesuada accumsan nisi in viverra. Donec fringilla, lectus non lacinia auctor, odio magna imperdiet purus,"+
            " sit amet vulputate ligula dui ac arcu. Duis eget enim justo. Fusce tincidunt, tellus ut sodales vestibulum, sapien nibh hendrerit arcu, luctus venenatis libero quam a sem."+
            " Mauris vehicula posuere justo, eget auctor orci varius nec. Mauris finibus augue quis volutpat dignissim.";

            
            Thread t1 = new Thread(new FirstThread(str1));
            Thread t2 = new Thread(new SecondThread(str2));
            
            long start = System.currentTimeMillis();
            t1.start();
            t2.start();
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Time taken: "+time+ " ms" +" using two threads");
        }
}  
class FirstThread implements Runnable 
{  
    String str;
    public FirstThread(String str)
    {
        this.str=str;
    }
    public void run()
	{
		long count=0;  
        char words[]= new char[str.length()];     
        for(int i=0;i<str.length();i++)  
        {
            words[i]= str.charAt(i);  
            if( ((i>0)&&(words[i]!=' ')&&(words[i-1]==' ')) || ((words[0]!=' ')&&(i==0)) )  
                count++; 
        }
        System.out.println("Word count of first string is " + count + " words."); 
    } 
}  
class SecondThread implements Runnable 
{  
    String str;
    public SecondThread(String str)
    {
        this.str=str;
    }
    public void run()
	{
		int count=0;  
        char words[]= new char[str.length()];     
        for(int i=0;i<str.length();i++)  
        {
            words[i]= str.charAt(i);  
            if( ((i>0)&&(words[i]!=' ')&&(words[i-1]==' ')) || ((words[0]!=' ')&&(i==0)) )  
                count++; 
        }
        System.out.println("Word count of second string is " + count +" words."); 
    } 
} 
