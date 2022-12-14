package org.alex.text2speech;

import org.alex.text2speech.util.douluo1.document2str.Douluo1Spider;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎使用Alex出品的Spider工具，目前只能爬取《斗罗大陆1》，之后会陆续更新其他小说");
        System.out.println("请输入抓取文件后保存的绝对路径，该文件路径对应的文件夹必须存在！（以斜线结尾）");
        String filePath = scanner.nextLine();

        Douluo1Spider.execute(filePath);
    }
}
