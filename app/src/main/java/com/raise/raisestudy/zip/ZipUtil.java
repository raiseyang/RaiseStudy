package com.raise.raisestudy.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by raise.yang on 16/08/09.
 */
public class ZipUtil {
    /**
     * @param srcPath  源文件的绝对路径，可以为文件或文件夹
     * @param destPath 目标文件的绝对路径  /sdcard/.../file_name.zip
     * @return 压缩成功返回 true
     */
    public static boolean compress(String srcPath, String destPath) {
        CheckedOutputStream cos = null;
        try {
            // 对目标文件做CRC32校验
            cos = new CheckedOutputStream(new FileOutputStream(destPath), new CRC32());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;//目标文件不可写
        }
        //装饰一层ZipOutputStream，使用zos写入的数据就会被压缩啦
        //
        ZipOutputStream zos = new ZipOutputStream(cos);
        File srcFile = new File(srcPath);
        if (srcFile.isFile()) {
            //若是文件,那肯定是对单个文件压缩
            //ZipOutputStream在写入流之前，需要设置一个zipEntry
            ZipEntry entry = new ZipEntry(srcPath);
            InputStream is = null;
            try {
                is = new FileInputStream(srcFile);
                //写到这个zipEntry中，可以理解为一个压缩文件
                zos.putNextEntry(entry);
                byte[] buffer = new byte[1024 << 3];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    zos.write(buffer, 0, len);
                }
                //该文件写入结束
                zos.closeEntry();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                closeStream(is);
                closeStream(zos);
            }

        }


        return false;
    }

    /**
     * 关闭流的工具类
     *
     * @param stream
     */
    public static void closeStream(Object stream) {
        if (stream instanceof InputStream) {
            if (stream != null) {
                try {
                    ((InputStream) stream).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (stream instanceof OutputStream) {
            if (stream != null) {
                try {
                    ((OutputStream) stream).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
