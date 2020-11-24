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

        String lookingFor2 = "\t<script type=\"text/javascript\" src=\"config_resource/jszip.js\"></script><script type=\"text/javascript\" src=\"config_resource/xlsx.js\"></script><script type=\"text/javascript\" src=\"config_resource/script.js\"></script>";
        String lookingForFlag2 = "    <script src=\"resources/scripts/axure/ios.js\"></script>";

        FileCSSFixer fileCSSFixer = new FileCSSFixer(file, path2);
        File tmpFile = fileCSSFixer.pasteIfMissing(lookingFor, lookingForFlag);
        System.out.println(tmpFile.getAbsolutePath());
        FileCSSFixer fileCSSFixer2 = new FileCSSFixer(tmpFile, path);
        File tmpFile2 = fileCSSFixer2.pasteIfMissing(lookingFor2, lookingForFlag2);
        System.out.println(tmpFile2.getAbsolutePath());
    }
}