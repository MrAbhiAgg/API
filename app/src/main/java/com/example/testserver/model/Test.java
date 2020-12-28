package com.example.testserver.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Test implements Parcelable {
    private String id;
    private String cityname;
    private String rank;
    private String population;
    private String province;
    private String description;
    private String image;

    protected Test(Parcel in) {
        id = in.readString();
        cityname = in.readString();
        rank = in.readString();
        population = in.readString();
        province = in.readString();
        description = in.readString();
        image = in.readString();
    }

    public static final Creator<Test> CREATOR = new Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(cityname);
        dest.writeString(rank);
        dest.writeString(population);
        dest.writeString(province);
        dest.writeString(description);
        dest.writeString(image);
    }
}
