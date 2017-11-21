package com.xwsxjt.common.util; /**
 * @Project: zyht_web
 * @Package com.common.util
 * @author xiaoshijie
 * @date 2017/10/10 10:24
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.io.*;

/**
 * @author xiaoshijie
 * @ClassName FileUtils
 * @Description 文件操作工具类
 * @date 2017/10/10
 */
public class FileUtils {
    /**
     * @Title: checkInFileAndOutDir
     * @Description: 检查源文件是否存在，是否为目录，并返回复制文件对象
     * @author xiaoshijie
     * @date 2017-08-29
     * @param inFile 源文件
     * @param dirPath 文件存放目录路径
     * @param fileName 文件名
     * @return File
     */
    public static File checkInFileAndOutDir(File inFile, String dirPath, String fileName){
        //如果源文件不存在
        if (!inFile.exists() || inFile.isDirectory()){
            return null;
        }

        File outFileDir = new File(dirPath);
        //如果目标目录不存在，创建目录
        if (!outFileDir.exists()){
            outFileDir.mkdirs();
        }
        //设置复制结果文件
        File outFile = new File(dirPath+"/"+fileName);
        System.out.println(dirPath+"/"+fileName);
        //如果文件不存在，创建文件
        if (!outFile.exists()){
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return outFile;
    }

    /**
     * @Title: copyFileByByte
     * @Description: 通过字节流复制文件
     * @author xiaoshijie
     * @date 2017-08-28
     * @param dirPath 文件存放目录路径
     * @param fileName 文件名
     * @return File
     */
    public static File copyFileByByte(File inFile, String dirPath, String fileName){
        //检查源文件，并新建复制文件
        File outFile = checkInFileAndOutDir(inFile, dirPath, fileName);
        if (outFile == null){
            return null;
        }

        //定义输入流
        InputStream inputStream = null;
        //定义输入缓冲流
        BufferedInputStream bufferedInputStream = null;
        //定义输出流
        OutputStream outputStream = null;
        //定义输出缓冲流
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //初始化输入流
            inputStream = new FileInputStream(inFile);
            //初始化缓冲输入流
            bufferedInputStream = new BufferedInputStream(inputStream);
            //初始化输出流
            outputStream = new FileOutputStream(outFile);
            //初始化缓冲输出流
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            //定义字符数组
            byte[] bytes = new byte[1024];
            //定义判断变量，初始化为-1（当为-1时，退出循环），避免出现死循环
            int length = -1;
            //从输入文件中读取字符,并将返回字符的读取长度赋值给length
            while ((length=bufferedInputStream.read(bytes, 0, bytes.length))!=-1){
                //通过字符长度写入相应字符
                bufferedOutputStream.write(bytes,0,length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }finally {
            try {
                //清空缓存
                outputStream.flush();
                bufferedOutputStream.flush();
                //关闭输入输出流
                inputStream.close();
                bufferedInputStream.close();
                outputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return outFile;
    }
}

