package com.song.judynews.util;

/**
 * Created by Judy on 2017/6/24.
 */

public class Urls {
    final public static String BASE_URL = "http://api.tianapi.com/";
    final public static String APIKEY = "9c9f740f78db90d248358a8ed88f044c";

    public static String getUrlByTitle(String title) {
        switch (title) {
            case "社会":
                return "social";
            case "国内":
                return "guonei";
            case "国际":
                return "world";
            case "娱乐":
                return "huabian";
            case "体育":
                return "tiyu";
            case "NBA":
                return "nba";
            case "足球":
                return "football";
            case "科技":
                return "keji";
            case "创业":
                return "startup";
            case "苹果":
                return "apple";
            case "军事":
                return "military";
            case "手机":
                return "mobile";
            case "旅游":
                return "trvael";
            case "健康":
                return "health";
            case "奇闻":
                return "qiwen";
            case "美女":
                return "meinv";
            case "VR":
                return "vr";
            case "IT":
                return "it";
            default:
                return "";
        }
    }
}
