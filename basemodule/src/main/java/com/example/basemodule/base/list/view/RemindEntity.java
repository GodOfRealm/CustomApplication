package com.example.basemodule.base.list.view;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * 下拉刷新，刷新完毕提示实体类
 */
public class RemindEntity implements Parcelable {

    @SerializedName("bgColor")
    private String bgColor;
    @SerializedName("titleColor")
    private String titleColor;
    @SerializedName("title")
    private String title;
    @SerializedName("animeTime")
    private int animeTime;

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnimeTime() {
        return animeTime;
    }

    public void setAnimeTime(int animeTime) {
        this.animeTime = animeTime;
    }

    public RemindEntity() {
    }

    protected RemindEntity(Parcel in) {
        bgColor = in.readString();
        titleColor = in.readString();
        title = in.readString();
        animeTime = in.readInt();
    }

    public static final Creator<RemindEntity> CREATOR = new Creator<RemindEntity>() {
        @Override
        public RemindEntity createFromParcel(Parcel in) {
            return new RemindEntity(in);
        }

        @Override
        public RemindEntity[] newArray(int size) {
            return new RemindEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bgColor);
        dest.writeString(titleColor);
        dest.writeString(title);
        dest.writeInt(animeTime);
    }
}
