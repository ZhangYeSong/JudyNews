package com.song.judynews.entity;

import java.util.List;

/**
 * Created by judy on 2017/6/28.
 */

public class JokeEntity {

    /**
     * code : 200
     * msg : isSuccessful
     * newslist : [{"id":32729,"title":"经验主义","content":"已出版两部小说的作家安妮与喜好文学的麦克争论着。安妮终于忍不住暴躁地说道：\u201c不，麦克，你根本不知道什么是小说。因为你连一本小说也没有写过。\u201d\u201c没这回事，\u201d麦克说道，\u201c这样的论调实在是很差的经验主义。你想想看我不曾生过鸡蛋，但菜肉蛋卷味道如何，我可比母鸡还清楚。\u201d"},{"id":32729,"title":"模仿","content":"一次，好莱坞为电影表演艺术家查理·卓别林举行生日宴会。宴会结束前，卓别林用抒情高音演唱了一首意大利歌剧插曲。 在座的一位朋友惊叹不已：\u201c查理，我们相处多年，也不知道你唱得这么好啊！\u201d 卓别林回答：\u201c我根本不会唱歌。这只不过是在模仿剧中人恩瑞柯·卡如索罢了！\u201d"},{"id":32729,"title":"别致的求婚","content":"日本电影明星柴田恭兵十分爱恋一位姑娘，但不知说什么好．有一天他 终于鼓足勇 气，对姑娘说：＂不知您愿不愿意和我一起变成老公公，老婆婆？＂ 姑娘听后，忍不 住笑了，接着又羞答答地点点头．"},{"id":32729,"title":"辛普森吓破了胆","content":"辛普森杀妻案重新审理.律师满头大汗跑来:\"大事不好了......\" \"不要慌,先生,\"辛普森微笑着说,\"他们没有足够的证据,而我们有最好的律师.\" \"不,他们派来一名中国足球裁判做法官!\"律师喊道. 辛普森大惊失色,战战兢兢道:\"可是......可是我们还有陪审团?\" \"这更糟!陪审团成员都是中国的巡边员!\"辛普森拔腿就跑,至今下落不明."},{"id":32729,"title":"还未到吻的时候","content":" 在一次社交会上，法国神父米尼耶（1853\u20141944年）坐在一位长得特别迷人的姑娘旁边 。一位先生问他是否有胆量吻她一下。 \u201c当然不敢！\u201d神父说，\u201c她还没成为圣物。\u201d"},{"id":32729,"title":"约翰·威尔克斯","content":"英国政治家约翰·威尔克斯（1725一1797年）有一次跟一个罗马天主教的教徒为宗教信仰问题争论了起来。天主教徒说：\u201c在马丁路德的宗教改革以前，你的信仰是什么？\u201d 威尔克斯反问说：\u201c你早上洗过脸了吗？\u201d 天主教徒回答说洗过了之后，威尔克斯继续问道：\u201c那么，请你告诉我，你在洗脸之前脸在什么地方？\u201d"},{"id":32729,"title":"戴高乐","content":"法国总统戴高乐（1809一1970年）下班后，喜欢出去散散步。有一天，他与一位朋友散步公园里。当那位朋友看到一对依偎在一起的情侣时，十分感叹他说：\u201c还有什么比一对青年男女更美好的呢！\u201d 戴高乐安祥地答道：\u201c有，老夫老妻。\u201d"},{"id":32729,"title":"黛玉葬花","content":"话说贾宝玉在后花园遇到拿著锄头的林黛玉，宝玉问黛玉说：『你在埋甚么啊！』黛玉呜噎的说：『花、花\u2026\u2026\u2026。』宝玉赞叹的说：『你的心肠真好！』黛玉松了口气心想不小心的破的古董『花瓶』，埋起来应该没人看到吧！"},{"id":32729,"title":"霍普:不入官场","content":"鲍勃．霍普在美国家喻户晓，因为他极善于用诙谐幽默的语言批评时弊， 尤其是政府的错误．新一任总统上台后，决定请他出任要职．他讥笑着说－ －＂假如我也去当官，谁还来批评当官的呢？＂"},{"id":32729,"title":"歌德","content":"有一次，德国著名诗人歌德在公园里散步，在一条仅能让一个人通过的小道上，他遇到了一位曾经尖锐地批评过他的作品的批评家，两人越走越近。\u201c我是从来不给蠢货让路的！\u201d批评家傲慢地开口说。\u201c我却正好相反。\u201d歌德说完，笑着退到路边。"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * id : 32729
         * title : 经验主义
         * content : 已出版两部小说的作家安妮与喜好文学的麦克争论着。安妮终于忍不住暴躁地说道：“不，麦克，你根本不知道什么是小说。因为你连一本小说也没有写过。”“没这回事，”麦克说道，“这样的论调实在是很差的经验主义。你想想看我不曾生过鸡蛋，但菜肉蛋卷味道如何，我可比母鸡还清楚。”
         */

        private int id;
        private String title;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    @Override
    public String toString() {
        return "JokeEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist +
                '}';
    }
}
