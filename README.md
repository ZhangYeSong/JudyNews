# JudyNews 仿网易新闻应用

* 功能：查看新闻（部分栏目接口过期），笑话，观看斗鱼直播。新闻实现缓存，下拉刷新下拉加载更多以及自定义栏目。
* 新闻API接口来自[天行API]{https://www.tianapi.com/}
* 直播源分析来自[斗鱼API](https://github.com/soimort/you-get/blob/0984190f93bd0b5c55748c41ca657d1ba6bf5a6b/src/you_get/extractors/douyutv.py)，请勿用作学习以外的其他用途。
* 视频播放器选用视频播放器使用[Vitamio](https://www.vitamio.org/)，构建项目需要下载最新版本的Vitamio作为module导入项目
* 其他技术选型：MVP + Retrofit + RxJava + Glide + XRecyclerview
