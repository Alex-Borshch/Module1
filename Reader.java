import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
   public static int matrixSize = 0;

    public static String read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();
        File file = new File("data.txt");
        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    matrixSize++;
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }


    public int getMatrixSize() {
        return matrixSize;
    }
    public static void parse() throws FileNotFoundException {

    String regexStreets = "((\\d{1,2}.)([A-Za-z]+) (\\d{1,2}),(\\d{1,2}))";
        Pattern pattern = Pattern.compile(regexStreets);
        String s = Reader.read("data.txt");
        System.out.println(s);
        Matcher matcher = pattern.matcher(Reader.read(s));
        Map map = new Map(matrixSize);
        while (matcher.find()){
            map.addVertex(matcher.group(2),Integer.parseInt(matcher.group(3)),Integer.parseInt(matcher.group(4)));
            System.out.println(matcher.group(2) + (matcher.group(3)) + (matcher.group(4)));
        }
    }
}
