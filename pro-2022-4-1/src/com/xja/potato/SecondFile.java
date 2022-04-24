package com.xja.potato;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @author potato
 * @create 2022-04-01 17:07
 */
public class SecondFile {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("请输入你要创建的文件夹/文件");
        String addOneFile = input.next();
        if ("-1".equals(addOneFile)){
            System.out.println("没有创建");
        }else {
            addSomeFile(addOneFile);
        }
        System.out.println("请输入你要查看的目录");
        String showOneDirectory = input.next();
        File file = new File(showOneDirectory);
        recordNumber(file);
        circulationFile(file);
    }
    //需求：输入一个路径创建对应的文件
    public static void addSomeFile(String addString){
        int i = addString.lastIndexOf("/");
        String strings = addString.substring(0,i);
        File file = new File(strings);
        boolean setFile=file.mkdirs();
        File file1 = new File(addString);
        try {
            boolean createFile = file1.createNewFile();
        } catch (IOException e) {
            System.out.println("创建失败！");
        }
    }
    //需求：统计一个文件夹内所有的文件类型的个数
    public static void recordNumber(File showTheFile){
        HashMap<String, Integer> map = new HashMap<>();
        File[] files = showTheFile.listFiles();
        for (File

                file : files) {
            if (file.isDirectory()){
                if (map.containsKey("key")){
                    Integer i = map.get("key");
                    map.put("key",++i);
                }else {
                    map.put("key",1);
                }
            }else{
                Integer j = file.getName().lastIndexOf("/");
                String fileName = file.getName().substring(j+1);
                if (map.containsKey(fileName)){
                    Integer fileValue=map.get(fileName);
                    map.put(fileName,++fileValue);
                }else{
                    map.put(fileName,1);
                }
            }
            Set<String> strings = map.keySet();
            for (String string : strings) {
                System.out.println(string+"有"+map.get(string)+"个文件");
            }
        }
    }
    //需求：展示指定目录下所有的文件和文件夹(包含子孙文件)
    public static void circulationFile(File file){
        File[] file1 = file.listFiles();
        for (File file2 : file1) {
            if (file2.isFile()){
                System.out.println(file2.getName());
            }else {
                System.out.println(file2.getName());
                circulationFile(file2);
            }
        }
    }
}
