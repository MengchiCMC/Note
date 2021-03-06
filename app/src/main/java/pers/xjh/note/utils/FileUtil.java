package pers.xjh.note.utils;


import android.os.Environment;

import java.io.File;
import java.io.IOException;

import pers.xjh.note.runtime.RunTime;

/**
 * 文件管理工具类
 * Created by xjh on 2017/1/18.
 */
public class FileUtil {

    /** 保存视频的文件夹名 */
    private static String mVideoDir = "/video";
    /** 保存音频的文件夹名 */
    private static String mVoiceDir = "/voice";

    /**
     * 注:getExternalCacheDir得到外部的缓存路径
     *    getExternalFilesDir得到外部文件路径
     *    getCacheDir得到内部的缓存路径
     *    getFilesDir得到内部文件路径
     */

    /**
     * 得到视频的文件夹的路径
     * @return
     */
    public static File getVideoDir() {
        File videoDir= new File(RunTime.getApplication().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsoluteFile(), mVideoDir);
        if(!videoDir.exists()) {
            videoDir.mkdir();
        }
        return videoDir;
    }

    /**
     * 得到音频的文件夹的路径
     * @return
     */
    public static File getVoiceDir() {
        File voiceDir = new File(RunTime.getApplication().getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsoluteFile(), mVoiceDir);
        if(!voiceDir.exists()) {
            voiceDir.mkdir();
        }
        return voiceDir;
    }

    /**
     * 生成一个对应名字的视频路径
     * @return
     */
    public static File getVideoFile(String fileName) {
        File videoFile = new File(getVideoDir().getAbsolutePath(), fileName);
        try {
            if(!videoFile.exists()) {
                videoFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return videoFile;
    }

    /**
     * 生成一个对应名字的音频路径
     * @return
     */
    public static File getVoiceFile(String fileName) {
        File voiceFile = new File(getVoiceDir().getAbsolutePath(), fileName);
        try {
            if(!voiceFile.exists()) {
                voiceFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return voiceFile;
    }

    /**
     * 删除一个文件
     * @param path
     */
    public static void deleteFile(String path) {
        File file = new File(path);
        if(file.exists()) {
            file.delete();
        }
    }
}
