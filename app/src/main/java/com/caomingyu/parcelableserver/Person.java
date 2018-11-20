package com.caomingyu.parcelableserver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by caomingyu on 2018/11/20.
 */

public class Person implements Parcelable {
    private String name;
    private int age;

    public Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public String toString() {
        return "{ name = " + name + " , age = " + age + "}";
    }
}
