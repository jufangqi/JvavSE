package net.Jdbc;

/**
 * Created by 存 on 2016/6/14.
 */
public class Test extends Dao {

    String[] xix = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "楮", "卫", "蒋", "沈",
            "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "哈", "孔", "曹", "严", "申", "冉",
            "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "章", "云", "苏", "潘", "葛", "范", "彭", "郎",
            "鲁", "韦", "董", "梁", "佟", "耿", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
            "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "殷", "罗", "毕", "关", "夏", "郝",
            "安", "常", "乐", "于", "时", "傅", "皮", "齐", "康", "伍", "余", "元", "顾", "孟", "平", "黄",
            "和", "穆", "萧", "尹", "姚", "邵", "辛", "简", "汪", "祁", "毛", "禹", "狄", "米", "贝", "荆",
            "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "敖", "冷",
            "聂", "杜", "阮", "席", "季", "麻", "贾", "江", "童", "梅", "林", "徐", "丘", "高", "尚", "农",
            "温", "庄", "柴", "瞿", "艾", "乔", "郁", "蔺", "蒙", "卓", "郁", "单", "杭", "洪", "包", "诸",
            "左", "石", "崔", "吉", "程", "邢", "裴", "陆", "荣", "荀", "羊", "欧", "广", "戈", "廖", "东",
            "易", "慎", "隆", "松", "段", "巫", "乌", "焦", "曾", "牧", "山", "谷", "车", "侯", "白", "怀",
            "蒲", "鄂", "咸", "赖", "司", "韶", "郜", "黎", "桑", "桂", "牛", "雍", "牟", "秋", "仲", "伊",
            "宫", "宁", "仇", "栾", "甘", "斜", "厉", "戎", "祖", "武", "符", "刘", "景", "詹", "束", "龙",
            "叶", "幸", "师", "古", "向", "苍", "双", "党", "翟", "谭", "劳"};
    String nim[] = {"英杰", "致远", "俊驰", "雨泽", "烨磊", "伟奇", "晟睿", "文博", "天佑", "文昊",
            "修洁", "黎昕", "远航", "旭尧", "国豪", "圣杰", "俊楠", "鸿涛", "伟祺", "荣轩", "越泽",
            "浩宇", "瑾瑜", "皓轩", "擎苍", "擎宇", "志泽", "子轩", "睿渊", "弘文", "哲瀚", "雨泽",
            "楷瑞", "建辉", "晋鹏", "天磊", "绍辉", "浩南", "泽洋", "鑫磊", "鹏煊", "博文", "昊强",
            "越泽", "旭尧", "伟宸", "博超", "君浩", "子骞", "鹏涛", "炎彬", "鹤轩", "伟泽", "越彬",
            "风华", "靖琪", "明辉", "伟诚", "明轩", "绍辉", "健柏", "英杰", "修杰", "志泽", "弘文",
            "峻熙", "嘉懿", "煜城", "懿轩", "烨伟", "苑博", "鹏涛", "炎彬", "鹤轩", "伟泽", "君昊",
            "熠彤", "鸿煊", "博涛", "苑杰", "黎昕", "烨霖", "晋鹏", "烨华", "煜祺", "智宸", "正豪",
            "昊然", "明杰", "立诚", "立轩", "立辉", "峻熙", "嘉懿", "煜城", "懿轩", "昊君", "致远",
            "雨泽", "烨磊", "伟奇","备","羽"};
    String[] vim = {"梦琪", "之桃", "慕青", "尔岚", "初夏", "沛菡", "傲珊", "曼文", "乐菱", "惜文", "友容",
            "香寒", "新柔", "若蕊", "问丝", "语蓉", "海安", "夜蓉", "涵柏", "水桃", "醉蓝", "语琴",
            "语兰", "又菱", "碧彤", "千易", "安露", "诗蕊", "山雁", "友菱", "香露", "如之", "寄瑶",
            "紫翠", "雨寒", "易烟", "如萱", "若南", "寻真", "晓亦", "向珊", "慕灵", "以蕊", "映易",
            "雪柳", "海云", "凝天", "沛珊", "寒云", "冰旋", "宛儿", "曼凝", "晓霜", "碧凡", "夏菡",
            "曼香", "若烟", "雅琴", "书瑶", "夏槐", "念芹", "代曼", "幻珊", "谷丝", "秋翠", "白晴",
            "海露", "代荷", "含玉", "书蕾", "尔丝", "以寒", "寒香", "小凡", "代亦", "梦露", "映波",
            "友蕊", "寄凡", "怜蕾", "雁枫", "水绿", "曼荷", "笑珊", "寒珊", "谷南", "慕儿", "夏岚",
            "友儿", "小萱", "紫青", "妙菱", "冬寒", "曼柔", "语蝶", "青筠", "夜安", "觅海", "问安",
            "夜白", "冷安", "灵竹", "念双", "念真", "曼寒", "夜天", "安筠", "觅柔", "初南", "秋蝶",
            "念露", "慕凝", "雅柔", "盼柳", "半青", "从霜", "怀柔", "怜晴", "夜蓉", "代双", "以南",
            "若菱", "芷文", "南晴", "梦寒", "初翠", "灵波", "问夏", "惜海", "亦旋", "沛芹", "幼萱",
            "白凝", "初露", "迎海", "绮玉", "凌香", "寻芹", "秋柳", "尔白", "映真", "含雁", "寒松",
            "寻雪", "青烟", "问蕊", "灵阳", "雪巧", "丹萱", "凡双", "孤萍", "紫菱", "寻凝", "傲柏"};

    int size = 4;

    public static void main(String[] args) {
        new ConnectionPool();
        for (int i = 0; i < 100; i++) {
            new Thread(new Test()).start();
        }
    }

    public void doSomeThing() {
        String temp;
        for (int i = 0; i < size; i++) {
            temp = xix[(int) (Math.random() * xix.length)];
            if ((int) (Math.random() * 5) < 2) {
                temp += nim[(int) (Math.random() * nim.length)];
                insert(temp, "男");
            } else {
                temp += vim[(int) (Math.random() * vim.length)];
                insert(temp, "女");
            }
        }
    }
}