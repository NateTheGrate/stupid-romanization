
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SRomanization {

    public static void main (String[] args) {
        String filePath = "D:\\Users\\Nathanael\\Desktop\\Lesson_1a.txt";
        ArrayList<String> lines = getText(filePath);

        //format each line then add it to one big string
        String formattedText = "";
        for (int i = 0; i < lines.size(); i++) {
            // add formatted text to one big string
            formattedText += format(lines.get(i)) + "\n";
            //unformatted --> formatted
            System.out.println(lines.get(i) +
                    "-->" + format(lines.get(i)));

        }
        //formatAudio("D:\\Users\\Nathanael\\Desktop\\audio\\cooler audio");
        // overwrite file
        write(filePath, formattedText);

    }

    static ArrayList<String> getText(String filePath)  {

        // index = line number
        ArrayList<String> unformatted = null;

        try {
            Scanner reader = new Scanner(new File(filePath), "UTF-8");
            unformatted = new ArrayList<String>();

            // add unformatted text to output
            int index = 0;
            while (reader.hasNext()) {
                unformatted.add(reader.nextLine());
                index ++;
            }

            reader.close();
        }
        catch (IOException e) {
            System.out.println("no getting happened :/");
        }

        return unformatted;
    }

    // not too sure why I still have this
    static void write (String filePath, String str) {
        try {
            // using printstream to deal with utf-8 characters
            PrintStream ps = new PrintStream(new File(filePath), "UTF-8");

            //should just overwrite everything
            ps.append(str);
            ps.close();
        }
        catch (IOException e) {
            System.out.println("no writing happened");
        }

    }


    //don't you just love formatting? ;)
    static String format (String str) {

        /**
         * _> pitch accent up
         * _< pitch accent down
         * _^ wtf do you even call this, a sudden raise???
         */

        String result = str;

        result = result.replaceAll("a>", "á");
        result = result.replaceAll("a<", "à");
        result = result.replaceAll("a\\^", "â");

        result = result.replaceAll("i>", "í");
        result = result.replaceAll("i<", "ì");
        result = result.replaceAll("i\\^", "î");

        result = result.replaceAll("u>", "ú");
        result = result.replaceAll("u<", "ù");
        result = result.replaceAll("u\\^", "û");

        result = result.replaceAll("e>", "é");
        result = result.replaceAll("e<", "è");
        result = result.replaceAll("e\\^", "ê");

        result = result.replaceAll("o>", "ó");
        result = result.replaceAll("o<", "ò");
        result = result.replaceAll("o\\^", "ô");


        result = result.replaceAll("n_", "n̄");

        result = result.replaceAll("%", "؟");
        result = result.replaceAll ("\\$", "✓");

        return result;
    }
}
