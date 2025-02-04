package com.example.addressbook

import android.os.Parcelable
import java.io.Serializable

data class User(val name: String, val age: Int, val email: String) : Serializable

data class UserParcelable(val name: String, val age: Int, val email: String) : Parcelable{
    constructor(parcel: android.os.Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserParcelable> {
        override fun createFromParcel(parcel: android.os.Parcel): UserParcelable {
            return UserParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UserParcelable?> {
            return arrayOfNulls(size)
        }
    }
}
