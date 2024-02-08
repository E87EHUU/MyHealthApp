package com.example.myhealth.data

import androidx.lifecycle.MutableLiveData
import com.example.myhealth.data.model.Health
import com.example.myhealth.data.model.Indication
import com.example.myhealth.utils.getDate
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class HealthRepository(private val db: DatabaseReference) {

    init {
        getHealth()
    }

    private val list: MutableList<Health> = mutableListOf()
    val liveData: MutableLiveData<List<Health>> = MutableLiveData()
    fun getHealth() {
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                snapshot.children.forEach { dateDB ->
                    val date = dateDB.key.toString()
                    val indications = mutableListOf<Indication>()
                    dateDB.children.forEach { child ->
                        child.getValue(Indication::class.java)?.let { indications.add(it) }
                    }
                    list.add(Health(date, indications.asReversed()))
                }
                liveData.postValue(list)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun setIndications(indication: Indication) {
        db.child(getDate()).push().setValue(indication)
    }
}