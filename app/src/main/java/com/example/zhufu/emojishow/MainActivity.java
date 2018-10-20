package com.example.zhufu.emojishow;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spannable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhufu.emojishow.util.EditTextUtils;
import com.example.zhufu.emojishow.util.EmojiconUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    RecyclerView rl;
    EmojiAdapter emojiAdapter;
    Context mContext;
    ArrayList<Emoji> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        et = findViewById(R.id.et);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, et.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        initEmojiList();
        initRecyclerView();
    }

    private void initEmojiList() {
        list = new ArrayList<>();
        list.addAll(EmojiconUtils.getEmojis1());
        list.addAll(EmojiconUtils.getEmojis2());
        list.addAll(EmojiconUtils.getEmojis3());
    }

    private void initRecyclerView() {
        rl = findViewById(R.id.rl);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 8);
        rl.setLayoutManager(gridLayoutManager);
        emojiAdapter = new EmojiAdapter(list);
        rl.setAdapter(emojiAdapter);
        emojiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Emoji emoji = emojiAdapter.getItem(position);
                EditTextUtils.addChar(et,
                        EmojiconUtils.buildEmotionSpannable(mContext, emoji.getDesc(),
                                (int) et.getTextSize()));
            }
        });
    }
}
