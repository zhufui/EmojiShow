package com.example.zhufu.emojishow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author:zhufu
 * email:zhufui@sina.com
 * time:2018/10/17
 * desc:emoji表情
 * version:1.0
 */
public class Emoji implements Parcelable {
    //描述
    private String desc;
    //图片
    private int imageId;

    public Emoji(String desc, int imageId) {
        this.desc = desc;
        this.imageId = imageId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.desc);
        dest.writeInt(this.imageId);
    }

    protected Emoji(Parcel in) {
        this.desc = in.readString();
        this.imageId = in.readInt();
    }

    public static final Creator<Emoji> CREATOR = new Creator<Emoji>() {
        @Override
        public Emoji createFromParcel(Parcel source) {
            return new Emoji(source);
        }

        @Override
        public Emoji[] newArray(int size) {
            return new Emoji[size];
        }
    };
}
