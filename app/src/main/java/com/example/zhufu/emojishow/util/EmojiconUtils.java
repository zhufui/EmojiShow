package com.example.zhufu.emojishow.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.ArrayMap;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.example.zhufu.emojishow.Emoji;
import com.example.zhufu.emojishow.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author:zhufu
 * email:zhufui@sina.com
 * time:2018/10/17
 * desc:
 * version:1.0
 */
public final class EmojiconUtils {
    private EmojiconUtils() {
    }

    private static final ArrayMap<String, Integer> sEmojisMap = new ArrayMap<>();

    static {
        sEmojisMap.put("[呲牙]", R.drawable.emoji_1);
        sEmojisMap.put("[调皮]", R.drawable.emoji_2);
        sEmojisMap.put("[汗]", R.drawable.emoji_3);
        sEmojisMap.put("[偷笑]", R.drawable.emoji_4);
        sEmojisMap.put("[拜拜]", R.drawable.emoji_5);
        sEmojisMap.put("[打你]", R.drawable.emoji_6);
        sEmojisMap.put("[擦汗]", R.drawable.emoji_7);
        sEmojisMap.put("[猪头]", R.drawable.emoji_8);
        sEmojisMap.put("[玫瑰]", R.drawable.emoji_9);
        sEmojisMap.put("[流泪]", R.drawable.emoji_10);
        sEmojisMap.put("[快哭了]", R.drawable.emoji_11);
        sEmojisMap.put("[嘘]", R.drawable.emoji_12);
        sEmojisMap.put("[酷]", R.drawable.emoji_13);
        sEmojisMap.put("[抓狂]", R.drawable.emoji_14);
        sEmojisMap.put("[委屈]", R.drawable.emoji_15);
        sEmojisMap.put("[屎]", R.drawable.emoji_16);
        sEmojisMap.put("[炸弹]", R.drawable.emoji_17);
        sEmojisMap.put("[菜刀]", R.drawable.emoji_18);
        sEmojisMap.put("[可爱]", R.drawable.emoji_19);
        sEmojisMap.put("[色]", R.drawable.emoji_20);
        sEmojisMap.put("[害羞]", R.drawable.emoji_21);
        sEmojisMap.put("[得意]", R.drawable.emoji_22);
        sEmojisMap.put("[吐]", R.drawable.emoji_23);
        sEmojisMap.put("[微笑]", R.drawable.emoji_24);
        sEmojisMap.put("[发火]", R.drawable.emoji_25);
        sEmojisMap.put("[尴尬]", R.drawable.emoji_26);
        sEmojisMap.put("[惊恐]", R.drawable.emoji_27);
        sEmojisMap.put("[冷汗]", R.drawable.emoji_28);
        sEmojisMap.put("[心]", R.drawable.emoji_29);
        sEmojisMap.put("[嘴唇]", R.drawable.emoji_30);
        sEmojisMap.put("[白眼]", R.drawable.emoji_31);
        sEmojisMap.put("[傲慢]", R.drawable.emoji_32);
        sEmojisMap.put("[难过]", R.drawable.emoji_33);
        sEmojisMap.put("[惊讶]", R.drawable.emoji_34);
        sEmojisMap.put("[疑问]", R.drawable.emoji_35);
        sEmojisMap.put("[睡]", R.drawable.emoji_36);
        sEmojisMap.put("[亲亲]", R.drawable.emoji_37);
        sEmojisMap.put("[憨笑]", R.drawable.emoji_38);
        sEmojisMap.put("[爱情]", R.drawable.emoji_39);
        sEmojisMap.put("[衰]", R.drawable.emoji_40);
        sEmojisMap.put("[撇嘴]", R.drawable.emoji_41);
        sEmojisMap.put("[奸笑]", R.drawable.emoji_42);
        sEmojisMap.put("[奋斗]", R.drawable.emoji_43);
        sEmojisMap.put("[发呆]", R.drawable.emoji_44);
        sEmojisMap.put("[右哼哼]", R.drawable.emoji_45);
        sEmojisMap.put("[抱抱]", R.drawable.emoji_46);
        sEmojisMap.put("[坏笑]", R.drawable.emoji_47);
        sEmojisMap.put("[企鹅亲]", R.drawable.emoji_48);
        sEmojisMap.put("[鄙视]", R.drawable.emoji_49);
        sEmojisMap.put("[晕]", R.drawable.emoji_50);
        sEmojisMap.put("[大兵]", R.drawable.emoji_51);
        sEmojisMap.put("[拜托]", R.drawable.emoji_52);
        sEmojisMap.put("[强]", R.drawable.emoji_53);
        sEmojisMap.put("[垃圾]", R.drawable.emoji_54);
        sEmojisMap.put("[握手]", R.drawable.emoji_55);
        sEmojisMap.put("[胜利]", R.drawable.emoji_56);
        sEmojisMap.put("[抱拳]", R.drawable.emoji_57);
        sEmojisMap.put("[枯萎]", R.drawable.emoji_58);
        sEmojisMap.put("[米饭]", R.drawable.emoji_59);
        sEmojisMap.put("[蛋糕]", R.drawable.emoji_60);
        sEmojisMap.put("[西瓜]", R.drawable.emoji_61);
        sEmojisMap.put("[啤酒]", R.drawable.emoji_62);
        sEmojisMap.put("[瓢虫]", R.drawable.emoji_63);
        sEmojisMap.put("[勾引]", R.drawable.emoji_64);
        sEmojisMap.put("[哦了]", R.drawable.emoji_65);
        sEmojisMap.put("[手势]", R.drawable.emoji_66);
        sEmojisMap.put("[咖啡]", R.drawable.emoji_67);
        sEmojisMap.put("[月亮]", R.drawable.emoji_68);
        sEmojisMap.put("[匕首]", R.drawable.emoji_69);
        sEmojisMap.put("[发抖]", R.drawable.emoji_70);
        sEmojisMap.put("[菜]", R.drawable.emoji_71);
        sEmojisMap.put("[拳头]", R.drawable.emoji_72);
    }

    private static Pattern sPatternEmotion = Pattern.compile("\\[([\u4e00-\u9fa5\\w])+\\]");

    /**
     * @param context
     * @param text     文本内容
     * @param textSize 文本字体大小
     * @return
     */
    public static Spannable buildEmotionSpannable(Context context, String text, int textSize) {
        Matcher matcherEmotion = sPatternEmotion.matcher(text);
        SpannableString spannableString = new SpannableString(text);

        while (matcherEmotion.find()) {
            String key = matcherEmotion.group();
            int imgRes = sEmojisMap.get(key);
            if (imgRes != -1) {
                int start = matcherEmotion.start();
                ImageSpan span = createImageSpanByRes(imgRes, context, textSize);
                spannableString.setSpan(span, start, start + key.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        return spannableString;
    }

    /**
     * 创建ImageSpan
     *
     * @param imgRes   表情资源id
     * @param context
     * @param textSize 文本大小
     * @return
     */
    private static ImageSpan createImageSpanByRes(int imgRes, Context context, int textSize) {
        Resources res = context.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, imgRes);
        ImageSpan span = null;
        int size = textSize * 13 / 10;
        Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
        span = new ImageSpan(context, scaleBitmap);

        return span;
    }

    public static ArrayList<Emoji> getEmojis1() {
        ArrayList<Emoji> list = new ArrayList<>();
        list.add(new Emoji("[呲牙]", R.drawable.emoji_1));
        list.add(new Emoji("[调皮]", R.drawable.emoji_2));
        list.add(new Emoji("[汗]", R.drawable.emoji_3));
        list.add(new Emoji("[偷笑]", R.drawable.emoji_4));
        list.add(new Emoji("[拜拜]", R.drawable.emoji_5));
        list.add(new Emoji("[打你]", R.drawable.emoji_6));
        list.add(new Emoji("[擦汗]", R.drawable.emoji_7));
        list.add(new Emoji("[猪头]", R.drawable.emoji_8));
        list.add(new Emoji("[玫瑰]", R.drawable.emoji_9));
        list.add(new Emoji("[流泪]", R.drawable.emoji_10));
        list.add(new Emoji("[快哭了]", R.drawable.emoji_11));
        list.add(new Emoji("[嘘]", R.drawable.emoji_12));
        list.add(new Emoji("[酷]", R.drawable.emoji_13));
        list.add(new Emoji("[抓狂]", R.drawable.emoji_14));
        list.add(new Emoji("[委屈]", R.drawable.emoji_15));
        list.add(new Emoji("[屎]", R.drawable.emoji_16));
        list.add(new Emoji("[炸弹]", R.drawable.emoji_17));
        list.add(new Emoji("[菜刀]", R.drawable.emoji_18));
        list.add(new Emoji("[可爱]", R.drawable.emoji_19));
        list.add(new Emoji("[色]", R.drawable.emoji_20));
        list.add(new Emoji("[害羞]", R.drawable.emoji_21));
        list.add(new Emoji("[得意]", R.drawable.emoji_22));
        list.add(new Emoji("[吐]", R.drawable.emoji_23));
        list.add(new Emoji("[微笑]", R.drawable.emoji_24));
        return list;
    }

    public static ArrayList<Emoji> getEmojis2() {
        ArrayList<Emoji> list = new ArrayList<>();
        list.add(new Emoji("[发火]", R.drawable.emoji_25));
        list.add(new Emoji("[尴尬]", R.drawable.emoji_26));
        list.add(new Emoji("[惊恐]", R.drawable.emoji_27));
        list.add(new Emoji("[冷汗]", R.drawable.emoji_28));
        list.add(new Emoji("[心]", R.drawable.emoji_29));
        list.add(new Emoji("[嘴唇]", R.drawable.emoji_30));
        list.add(new Emoji("[白眼]", R.drawable.emoji_31));
        list.add(new Emoji("[傲慢]", R.drawable.emoji_32));
        list.add(new Emoji("[难过]", R.drawable.emoji_33));
        list.add(new Emoji("[惊讶]", R.drawable.emoji_34));
        list.add(new Emoji("[疑问]", R.drawable.emoji_35));
        list.add(new Emoji("[睡]", R.drawable.emoji_36));
        list.add(new Emoji("[亲亲]", R.drawable.emoji_37));
        list.add(new Emoji("[憨笑]", R.drawable.emoji_38));
        list.add(new Emoji("[爱情]", R.drawable.emoji_39));
        list.add(new Emoji("[衰]", R.drawable.emoji_40));
        list.add(new Emoji("[撇嘴]", R.drawable.emoji_41));
        list.add(new Emoji("[奸笑]", R.drawable.emoji_42));
        list.add(new Emoji("[奋斗]", R.drawable.emoji_43));
        list.add(new Emoji("[发呆]", R.drawable.emoji_44));
        list.add(new Emoji("[右哼哼]", R.drawable.emoji_45));
        list.add(new Emoji("[抱抱]", R.drawable.emoji_46));
        list.add(new Emoji("[坏笑]", R.drawable.emoji_47));
        list.add(new Emoji("[企鹅亲]", R.drawable.emoji_48));
        return list;
    }

    public static ArrayList<Emoji> getEmojis3() {
        ArrayList<Emoji> list = new ArrayList<>();
        list.add(new Emoji("[鄙视]", R.drawable.emoji_49));
        list.add(new Emoji("[晕]", R.drawable.emoji_50));
        list.add(new Emoji("[大兵]", R.drawable.emoji_51));
        list.add(new Emoji("[拜托]", R.drawable.emoji_52));
        list.add(new Emoji("[强]", R.drawable.emoji_53));
        list.add(new Emoji("[垃圾]", R.drawable.emoji_54));
        list.add(new Emoji("[握手]", R.drawable.emoji_55));
        list.add(new Emoji("[胜利]", R.drawable.emoji_56));
        list.add(new Emoji("[抱拳]", R.drawable.emoji_57));
        list.add(new Emoji("[枯萎]", R.drawable.emoji_58));
        list.add(new Emoji("[米饭]", R.drawable.emoji_59));
        list.add(new Emoji("[蛋糕]", R.drawable.emoji_60));
        list.add(new Emoji("[西瓜]", R.drawable.emoji_61));
        list.add(new Emoji("[啤酒]", R.drawable.emoji_62));
        list.add(new Emoji("[瓢虫]", R.drawable.emoji_63));
        list.add(new Emoji("[勾引]", R.drawable.emoji_64));
        list.add(new Emoji("[哦了]", R.drawable.emoji_65));
        list.add(new Emoji("[手势]", R.drawable.emoji_66));
        list.add(new Emoji("[咖啡]", R.drawable.emoji_67));
        list.add(new Emoji("[月亮]", R.drawable.emoji_68));
        list.add(new Emoji("[匕首]", R.drawable.emoji_69));
        list.add(new Emoji("[发抖]", R.drawable.emoji_70));
        list.add(new Emoji("[菜]", R.drawable.emoji_71));
        list.add(new Emoji("[拳头]", R.drawable.emoji_72));
        return list;
    }

    private static Map<String, Integer> getEmojiMap(String key, Integer value) {
        Map<String, Integer> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
