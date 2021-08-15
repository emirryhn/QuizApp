package com.example.ujianquizapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Questions implements Parcelable {

    private String name;
    private String level;

    public Questions(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.level);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.level = source.readString();
    }

    protected Questions(Parcel in) {
        this.name = in.readString();
        this.level = in.readString();
    }

    public static final Parcelable.Creator<Questions> CREATOR = new Parcelable.Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel source) {
            return new Questions(source);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };
}
