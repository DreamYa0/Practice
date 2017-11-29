package codecomplete;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/10.
 *         P43
 */
public class ErgodicArray {
    public static void main(String[] args) {
        String[] aves = new String[]{"白鹭", "丹顶鹤", "黄鹂", "鹦鹉", "乌鸦", "喜鹊", "布谷鸟", "灰纹鸟", "百灵鸟"};
        int index = 0;
        System.out.println("我的花园里有很多鸟，种类大约包括：");
        while (index < aves.length) {
            System.out.println(aves[index++]);
        }
    }
}
