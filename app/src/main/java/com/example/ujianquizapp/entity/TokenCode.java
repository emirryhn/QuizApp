
package com.example.ujianquizapp.entity;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenCode implements Serializable, Parcelable
{

    @SerializedName("token")
    @Expose
    private String token;
    public final static Creator<TokenCode> CREATOR = new Creator<TokenCode>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TokenCode createFromParcel(android.os.Parcel in) {
            return new TokenCode(in);
        }

        public TokenCode[] newArray(int size) {
            return (new TokenCode[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5804047897286602148L;

    protected TokenCode(android.os.Parcel in) {
        this.token = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public TokenCode() {
    }

    /**
     * 
     * @param token
     */
    public TokenCode(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TokenCode.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("token");
        sb.append('=');
        sb.append(((this.token == null)?"<null>":this.token));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.token == null)? 0 :this.token.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TokenCode) == false) {
            return false;
        }
        TokenCode rhs = ((TokenCode) other);
        return ((this.token == rhs.token)||((this.token!= null)&&this.token.equals(rhs.token)));
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(token);
    }

    public int describeContents() {
        return  0;
    }

}
