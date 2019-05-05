package com.example.project.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DataInstansiDao {
    @Insert
    long insertData(DataInstansi dataInstansi);

    @Query("Select * from instansi_db")
    List<DataInstansi> getData();

    @Update
    int updateData(DataInstansi item);

    @Delete
    void deleteData(DataInstansi item);
}
