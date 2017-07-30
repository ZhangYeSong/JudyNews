# JudyNews 仿网易新闻应用

* 功能：查看新闻（部分栏目接口过期），笑话，观看斗鱼直播。新闻实现缓存，下拉刷新下拉加载更多以及自定义栏目。
* 新闻API接口来自[天行API]{https://www.tianapi.com/}
* 直播源分析来自[斗鱼API](https://github.com/soimort/you-get/blob/0984190f93bd0b5c55748c41ca657d1ba6bf5a6b/src/you_get/extractors/douyutv.py)，请勿用作学习以外的其他用途。
* 视频播放器选用视频播放器使用[Vitamio](https://www.vitamio.org/)，构建项目需要下载最新版本的Vitamio作为module导入项目，根目录下也有apk直接安装
* 其他技术选型：MVP + Retrofit + RxJava + Glide + XRecyclerview

<img src="https://github.com/ZhangYeSong/JudyNews/blob/master/screenshot/%E6%96%B0%E9%97%BB%E7%95%8C%E9%9D%A2.jpeg" width="40%" height="40%" alt="新闻界面"/> <img src="https://github.com/ZhangYeSong/JudyNews/blob/master/screenshot/%E8%B0%83%E6%95%B4%E6%A0%8F%E7%9B%AE.jpeg" width="40%" height="40%" alt="调整栏目"/>


<img src="https://github.com/ZhangYeSong/JudyNews/blob/master/screenshot/%E7%9B%B4%E6%92%AD%E5%88%97%E8%A1%A8.jpeg" width="40%" height="40%" alt="直播列表"/> <img src="https://github.com/ZhangYeSong/JudyNews/blob/master/screenshot/%E7%9B%B4%E6%92%AD%E8%8A%82%E7%9B%AE.jpeg" width="40%" height="40%" alt="直播节目"/>

