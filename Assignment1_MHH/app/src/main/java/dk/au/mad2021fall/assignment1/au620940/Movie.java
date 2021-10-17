package dk.au.mad2021fall.assignment1.au620940;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Movie implements Parcelable, Serializable {
    private String title_ = "Not available";
    private Integer year_ = 9999;
    private Double userRating_ = 0.0;
    private String genre_ = "Default";
    private String description_ = "Not available";
    private Double imdbRating_ = 0.0;
    private String userNote_ = "Not available";

    public Movie(String title, Integer year, Double userRating, String genre, String description, Double imdbRating, String userNote )
    {
        this.title_ = title;
        this.year_ = year;
        this.userRating_ = userRating;
        this.genre_ = genre;
        this.description_ = description;
        this.imdbRating_ = imdbRating;
        this.userNote_ = userNote;
    }

    protected Movie(Parcel in) {
        title_ = in.readString();
        if (in.readByte() == 0) {
            year_ = null;
        } else {
            year_ = in.readInt();
        }
        if (in.readByte() == 0) {
            userRating_ = null;
        } else {
            userRating_ = in.readDouble();
        }
        genre_ = in.readString();
        description_ = in.readString();
        if (in.readByte() == 0) {
            imdbRating_ = null;
        } else {
            imdbRating_ = in.readDouble();
        }
        userNote_ = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle()
    {
        return this.title_;
    }

    public Integer getYear()
    {
        return this.year_;
    }

    public Double getUserRating()
    {
        return this.userRating_;
    }

    public void setUserRating(Double userRating)
    {
        this.userRating_ = userRating;
    }

    public String getGenre()
    {
        return this.genre_;
    }

    public String getDescription()
    {
        return this.description_;
    }

    public Double getImdbRating()
    {
        return this.imdbRating_;
    }

    public String getUserNote()
    {
        return this.userNote_;
    }

    public void setUserNote(String userNote)
    {
        this.userNote_ = userNote;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title_);
        if (year_ == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(year_);
        }
        if (userRating_ == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(userRating_);
        }
        parcel.writeString(genre_);
        parcel.writeString(description_);
        if (imdbRating_ == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(imdbRating_);
        }
        parcel.writeString(userNote_);
    }
}
