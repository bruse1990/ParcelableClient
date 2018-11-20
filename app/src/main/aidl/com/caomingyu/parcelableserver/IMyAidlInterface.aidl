// IMyAidlInterface.aidl
package com.caomingyu.parcelableserver;

import com.caomingyu.parcelableserver.Person;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    List<Person> addPerson(in Person person);
}
