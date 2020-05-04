package pt.hdn.registocriminal;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {

    //region vars
    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
    //endregion vars


    private Event() {

    }

    private Event(Parcel in) {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }


    @Override
    public int describeContents() {
        return 0;
    }
}
