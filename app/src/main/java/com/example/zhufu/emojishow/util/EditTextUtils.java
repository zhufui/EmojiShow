package com.example.zhufu.emojishow.util;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;

/**
 * author:zhufu
 * email:zhufui@sina.com
 * time:2018/10/18
 * desc:EditText的工具类
 * version:1.0
 */
public final class EditTextUtils {
    private EditTextUtils() {
    }

    /**
     * 往光标后添加
     *
     * @param editText
     * @param data
     */
    public static void addChar(EditText editText, CharSequence data) {
        if (editText == null) {
            throw new NullPointerException("editText is null");
        }

        if (TextUtils.isEmpty(data)) {
            return;
        }

        int index = editText.getSelectionStart();
        Editable editable = editText.getText();
        editable.insert(index, data);
    }

    /**
     * 删除光标前字符
     *
     * @param editText
     */
    public static void deleteChar(EditText editText) {
        if (editText == null) {
            throw new NullPointerException("editText is null");
        }

        if (TextUtils.isEmpty(editText.getText().toString())) {
            return;
        }
        int index = editText.getSelectionStart();
        Editable editable = editText.getText();
        editable.delete(index - 1, index);
    }

    /**
     * 模拟软件盘的删除按钮
     *
     * @param editText
     */
    public static void keyBoardDeleteChar(EditText editText) {
        if (editText == null) {
            throw new NullPointerException("editText is null");
        }

        int keyCode = KeyEvent.KEYCODE_DEL;
        KeyEvent keyEventDown = new KeyEvent(KeyEvent.ACTION_DOWN, keyCode);
        KeyEvent keyEventUp = new KeyEvent(KeyEvent.ACTION_UP, keyCode);
        editText.onKeyDown(keyCode, keyEventDown);
        editText.onKeyUp(keyCode, keyEventUp);
    }
}
