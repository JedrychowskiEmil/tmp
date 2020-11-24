package tmp;



import java.io.*;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {


        String path  = "d:\\\\html_css\\\\Before\\\\";
        String path2 = "d:\\\\html_css\\\\After\\\\";
        File file = new File(path + "02_01.html");
        String lookingFor = "    <link href=\"files/global.css\" type=\"text/css\" rel=\"stylesheet\"/>";
        String lookingForFlag = "    <style type=\"text/css\">";

        FileCSSFixer fileCSSFixer = new FileCSSFixer(file, path2);
        File tmpFile = fileCSSFixer.pasteIfMissing(lookingFor, lookingForFlag);
        System.out.println(tmpFile.getAbsolutePath());
        FileCSSFixer fileCSSFixer2 = new FileCSSFixer(tmpFile, path);
        File tmpFile2 = fileCSSFixer2.pasteIfMissing(lookingFor, lookingForFlag);
        System.out.println(tmpFile2.getAbsolutePath());
    }
}