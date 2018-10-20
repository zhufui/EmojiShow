package com.example.zhufu.emojishow;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author:zhufu
 * email:zhufui@sina.com
 * time:2018/10/20
 * desc:
 * version:1.0
 */
public class EmojiAdapter extends BaseQuickAdapter<Emoji, BaseViewHolder> {
    public EmojiAdapter(@Nullable List<Emoji> data) {
        super(R.layout.item_emoji, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Emoji item) {
        helper.setImageResource(R.id.ivItemEmoji, item.getImageId());
    }
}
