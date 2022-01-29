package com.ynov.tpandroid.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Ville implements Parcelable {
    int id;
    String name;
    ImageBnb pic;

    public Ville(int id, String name, ImageBnb image) {
        this.id = id;
        this.name = name;
        this.pic = image;
    }


    protected Ville(Parcel in) {
        id = in.readInt();
        name = in.readString();
        pic = in.readParcelable(ImageBnb.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(pic, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ville> CREATOR = new Creator<Ville>() {
        @Override
        public Ville createFromParcel(Parcel in) {
            return new Ville(in);
        }

        @Override
        public Ville[] newArray(int size) {
            return new Ville[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageBnb getPic() {
        return pic;
    }

    public void setPic(ImageBnb pic) {
        this.pic = pic;
    }
}
