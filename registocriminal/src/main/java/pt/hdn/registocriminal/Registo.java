package pt.hdn.registocriminal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.GsonBuilder;

import java.time.ZonedDateTime;
import java.util.List;

import pt.hdn.registocriminal.adapters.ByteArrayTypeAdapter;
import pt.hdn.registocriminal.adapters.ZonedDateTimeTypeAdapter;

public class Registo implements Parcelable {

    //region vars
    public static final Creator<Registo> CREATOR = new Creator<Registo>() {
        @Override
        public Registo createFromParcel(Parcel in) {
            return new Registo(in);
        }

        @Override
        public Registo[] newArray(int size) {
            return new Registo[size];
        }
    };

    private String accessCode;
    private boolean activityInvolvingRegularContactsWithChildren;
    private ZonedDateTime creationDate;
    private ZonedDateTime dateOfBirth;
    private List<Event> events;
    private ZonedDateTime expirationDate;
    private String identityCardNumber;
    private byte[] issuerSignature;
    private ZonedDateTime issuerTimestamp;
    private String jobSpecification;
    private String name;
    private String nationality;
    private String placeOfBirth;
    private String requestPurpose;
    private String townOfBirth;
    //endregion vars

    public static Registo from(String json){
        return new GsonBuilder()
                .registerTypeHierarchyAdapter(byte[].class, new ByteArrayTypeAdapter())
                .registerTypeHierarchyAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                .create()
                .fromJson(json, Registo.class);
    }

    private Registo() {

    }

    private Registo(Parcel in) {
        accessCode = in.readString();
        activityInvolvingRegularContactsWithChildren = in.readByte() != 0;
        creationDate = ZonedDateTime.parse(in.readString());
        dateOfBirth = ZonedDateTime.parse(in.readString());
        events = in.createTypedArrayList(Event.CREATOR);
        expirationDate = ZonedDateTime.parse(in.readString());
        identityCardNumber = in.readString();
        issuerSignature = in.createByteArray();
        issuerTimestamp = ZonedDateTime.parse(in.readString());
        jobSpecification = in.readString();
        name = in.readString();
        nationality = in.readString();
        placeOfBirth = in.readString();
        requestPurpose = in.readString();
        townOfBirth = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accessCode);
        dest.writeByte((byte) (activityInvolvingRegularContactsWithChildren ? 1 : 0));
        dest.writeString(creationDate.toString());
        dest.writeString(dateOfBirth.toString());
        dest.writeTypedList(events);
        dest.writeString(expirationDate.toString());
        dest.writeString(identityCardNumber);
        dest.writeByteArray(issuerSignature);
        dest.writeString(issuerTimestamp.toString());
        dest.writeString(jobSpecification);
        dest.writeString(name);
        dest.writeString(nationality);
        dest.writeString(placeOfBirth);
        dest.writeString(requestPurpose);
        dest.writeString(townOfBirth);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean isActivityInvolvingRegularContactsWithChildren() {
        return activityInvolvingRegularContactsWithChildren;
    }

    public boolean hasNoEvent() {
        return events.size() == 0;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Event> getEvents() {
        return events;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public byte[] getIssuerSignature() {
        return issuerSignature;
    }

    public ZonedDateTime getIssuerTimestamp() {
        return issuerTimestamp;
    }

    public String getJobSpecification() {
        return jobSpecification;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getRequestPurpose() {
        return requestPurpose;
    }

    public String getTownOfBirth() {
        return townOfBirth;
    }
}
