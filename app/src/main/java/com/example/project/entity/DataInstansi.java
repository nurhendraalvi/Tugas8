package com.example.project.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
@Entity(tableName = "instansi_db")
public class DataInstansi {
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        private String id;

        @ColumnInfo(name = "nomorInstansi")
        private String nomorInstansi;

        @ColumnInfo(name = "lat")
        private String lat;

        @ColumnInfo(name = "namaKabupaten")
        private String namaKabupaten;

        @ColumnInfo(name = "jenisInstansi")
        private String jenisInstansi;

        @ColumnInfo(name = "alamatInstansi")
        private String alamatInstansi;

        @ColumnInfo(name = "namaInstansi")
        private String namaInstansi;

        @ColumnInfo(name = "idKabupaten")
        private String idKabupaten;

        public void setNomorInstansi(String nomorInstansi){
            this.nomorInstansi = nomorInstansi;
        }

        public String getNomorInstansi(){
            return nomorInstansi;
        }

        public void setLat(String lat){
            this.lat = lat;
        }

        public String getLat(){
            return lat;
        }

        public void setNamaKabupaten(String namaKabupaten){
            this.namaKabupaten = namaKabupaten;
        }

        public String getNamaKabupaten(){
            return namaKabupaten;
        }

        public void setJenisInstansi(String jenisInstansi){
            this.jenisInstansi = jenisInstansi;
        }

        public String getJenisInstansi(){
            return jenisInstansi;
        }

        public void setAlamatInstansi(String alamatInstansi){ this.alamatInstansi = alamatInstansi; }

        public String getAlamatInstansi(){
            return alamatInstansi;
        }

        public void setId(String id){
            this.id = id;
        }

        public String getId(){
            return id;
        }

        public void setNamaInstansi(String namaInstansi){
            this.namaInstansi = namaInstansi;
        }

        public String getNamaInstansi(){
            return namaInstansi;
        }

        public void setIdKabupaten(String idKabupaten){
            this.idKabupaten = idKabupaten;
        }

        public String getIdKabupaten(){
            return idKabupaten;
        }
}
