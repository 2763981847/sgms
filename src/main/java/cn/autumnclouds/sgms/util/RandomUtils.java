package cn.autumnclouds.sgms.util;

import cn.hutool.Hutool;
import cn.hutool.core.util.RandomUtil;

import java.util.Random;

/**
 * @author Fu Qiujie
 * @since 2024/4/2
 */
public class RandomUtils {

    private static final String[] COMMON_SURNAMES = {"张", "李", "王", "赵", "周", "吴", "郑", "王", "陈", "董", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "於", "惠", "甄", "麴", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仉", "秋", "仇", "甘", "斋", "厉", "边", "卜", "帅", "南", "牟", "佘", "佴", "候", "官", "窦", "郜", "亓", "英", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "薄", "印", "宿", "白", "怀", "蒲", "台", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "鬼", "邱", "阮", "桂", "闵", "欧阳", "夏侯", "诸葛", "上官", "欧阳", "司徒", "东方", "独孤", "南宫", "万俟", "闻人", "东郭", "南门", "呼延", "归海", "羊舌", "微生", "岳", "帅", "缑", "亢", "农", "郗", "浦", "阡", "佟", "爱", "年", "阳", "佟", "言", "福"};

    public static String randomChineseName() {
        // 随机生成姓
        StringBuilder name = new StringBuilder(RandomUtil.randomEle(COMMON_SURNAMES));
        // 随机生成名
        name.append(RandomUtil.randomChinese());
        if (RandomUtil.randomBoolean()) {
            // 有一半的概率生成两字名
            name.append(RandomUtil.randomChinese());
        }
        return name.toString();
    }
}
