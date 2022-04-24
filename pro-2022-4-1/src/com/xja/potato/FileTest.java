package com.xja.potato;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author potato
 * @create 2022-04-01 15:30
 */
public class FileTest {
    //需求：输入一个路径创建对应的文件
    //需求：统计一个文件夹内所有的文件类型的个数
    //需求：展示指定目录下所有的文件和文件夹(包含子孙文件)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要添加的文件");
        String addFile = input.next();
        addSomeFile(addFile);

        showFileNum();

        File file = new File("D:/APPstudy/typora笔记/柳老师");
        showAllFileName(file);

    }

    /**
     * 需求：输入一个路径创建对应的文件
     * @param addFile 要创建的文件夹/文件
     */
    public static void addSomeFile(String addFile){
        int i = addFile.lastIndexOf("/");
        String directory = addFile.substring(0,i);
        File file1 = new File(directory);
        file1.mkdirs();
        File file2 = new File(addFile);
        try {
            file2.createNewFile();
        } catch (IOException e) {
            System.out.println("创建失败！！");
        }
    }

    /**
     * 需求：统计一个文件夹内所有的文件类型的个数
     */
    public static void showFileNum(){
        File file = new File("D:/APPstudy/typora笔记/柳老师");
        HashMap<String, Integer> map = new HashMap<>();
        File[] files= file.listFiles();
        //遍历这个文件夹里面的所有文件
        for (File file1 : files) {
            //判断这个元素是文件还是文件夹
            if (file1.isDirectory()) {
                if (map.containsKey("key")) {
                    Integer init = map.get("key");
                    map.put("key", ++init);
                } else {
                    map.put("key", 1);
                }
            } else if (file1.isFile()) {
                int i = file1.getName().lastIndexOf("/");
                String key = file1.getName().substring(i + 1);
                if (map.containsKey(key)) {
                    Integer init = map.get(key);
                    map.put(key, ++init);
                } else {
                    map.put(key, 1);
                }
            }//判断(文件/文件夹)结束
        }//遍历所有文件结束
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string+"有"+map.get(string)+"个");
        }
    }

    /**
     * 需求：展示指定目录下所有的文件和文件夹(包含子孙文件)
     * @param file 传入一个地址
     */
    public static void showAllFileName(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()){
                System.out.println(file1.getName());
            }else {
                System.out.println(file1.getName());
                showAllFileName(file1);
            }
        }
    }
}
