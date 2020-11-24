package tmp;

import java.io.*;
import java.util.Scanner;

public class FileCSSFixer {
    private File file;
    private String fileName;
    private String path;

    private int pasteInLine;

    public FileCSSFixer(File file, String path) {
        this.file = file;
        this.fileName = file.getName();
        this.path = path;
    }

    public File pasteIfMissing(String textINeedToFind, String pasteBeforeThisText) {
        System.out.println("#############################################");
        System.out.println("Zajmuje się plikiem: " + file.getAbsolutePath());
        System.out.println("Szukam:" + textINeedToFind);
        boolean addLine = true;
        //Jezeli znalazl ta linijke w tekscie nic nie rob
        if (whereIsThisString(textINeedToFind) > -1) {
            addLine = false;
            System.out.println("Znaleziono szukany tekst");
        }else{
            System.out.println("Nie znaleziono szukanego tekstu");
        }

        int pasteInLine = whereIsThisString(pasteBeforeThisText);
        int currentLine = 0;
        String tmpFileName = path + fileName;
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tmpFileName)));
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String thisLine = scanner.nextLine();
                if (currentLine == pasteInLine && addLine) {
                    writer.println(textINeedToFind);
                }
                currentLine++;
                writer.println(thisLine);
            }
            writer.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (addLine) {
            System.out.println("Trzeba bylo dodac, dodano!");
        } else {
            System.out.println("Juz jest, przekopiowano");
        }
        return new File(tmpFileName);
    }


    //Zwraca numer linijki w ktorej znalazl wyszukiwane zdanie lub -1 jesli go nie ma
    private int whereIsThisString(String textINeedToFind) {

        int currentLine = 0;
        int foundInLine = -1;

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String newLine = scanner.nextLine();
                if (newLine.compareTo(textINeedToFind) == 0) {
                    foundInLine = currentLine;
                    break;
                }
                currentLine++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return foundInLine;
    }
}
