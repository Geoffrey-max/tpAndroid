package com.ynov.tpandroid.bo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by quentin for YnovChat on 28/01/2022.
 */
public class ImageBnb implements Parcelable {
    String url;

    public ImageBnb(String url) {
        this.url = url;
    }

    protected ImageBnb(Parcel in) {
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImageBnb> CREATOR = new Creator<ImageBnb>() {
        @Override
        public ImageBnb createFromParcel(Parcel in) {
            return new ImageBnb(in);
        }

        @Override
        public ImageBnb[] newArray(int size) {
            return new ImageBnb[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
