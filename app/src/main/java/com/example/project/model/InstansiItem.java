package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class InstansiItem{

	@SerializedName("nomor_instansi")
	private String nomorInstansi;

	@SerializedName("lat_")
	private String lat;

	@SerializedName("long_")
	private String long2;

	@SerializedName("nama_kabupaten")
	private String namaKabupaten;

	@SerializedName("jenis_instansi")
	private String jenisInstansi;

	@SerializedName("alamat_instansi")
	private String alamatInstansi;

	@SerializedName("id")
	private String id;

	@SerializedName("nama_instansi")
	private String namaInstansi;

	@SerializedName("id_kabupaten")
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

	public void setLong(String long2){
		this.long2 = long2;
	}

	public String getLong(){
		return long2;
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

	public void setAlamatInstansi(String alamatInstansi){
		this.alamatInstansi = alamatInstansi;
	}

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

	@Override
 	public String toString(){
		return 
			"InstansiItem{" + 
			"nomor_instansi = '" + nomorInstansi + '\'' + 
			",lat_ = '" + lat + '\'' + 
			",long_ = '" + long2 + '\'' +
			",nama_kabupaten = '" + namaKabupaten + '\'' + 
			",jenis_instansi = '" + jenisInstansi + '\'' + 
			",alamat_instansi = '" + alamatInstansi + '\'' + 
			",id = '" + id + '\'' + 
			",nama_instansi = '" + namaInstansi + '\'' + 
			",id_kabupaten = '" + idKabupaten + '\'' + 
			"}";
		}
}