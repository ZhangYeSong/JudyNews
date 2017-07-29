package com.song.judynews.entity;

/**
 * Created by judy on 2017/7/29.
 */

public class RoomIdEntity {

    /**
     * error : 0
     * data : {"hls_url":"http://hls1a.douyucdn.cn/live/1746151rRTnHIxZj_550/playlist.m3u8?wsSecret=f33ebff231bf5546c693abbc0853c6b5&wsTime=1501309025&did=h5-douyu&ver="}
     */

    private int error;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hls_url : http://hls1a.douyucdn.cn/live/1746151rRTnHIxZj_550/playlist.m3u8?wsSecret=f33ebff231bf5546c693abbc0853c6b5&wsTime=1501309025&did=h5-douyu&ver=
         */

        private String hls_url;

        public String getHls_url() {
            return hls_url;
        }

        public void setHls_url(String hls_url) {
            this.hls_url = hls_url;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "hls_url='" + hls_url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RoomIdEntity{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }
}
