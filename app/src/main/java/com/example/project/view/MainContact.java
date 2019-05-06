package com.example.project.view;

import android.view.View;

import com.example.project.entity.AppDatabase;
import com.example.project.entity.DataInstansi;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void resetForm();
        void sukses();
        //void getData(List<DataSekolah> list);
        void editData(DataInstansi item);
        //void deleteData(DataSekolah item);
    }
    interface datapresenter{
        //readData(AppDatabase database);
        //void editData(String jml_siswa, String jml_guru, String nama_sekolah, String alamat, int id, AppDatabase database);
        //void deleteData(DataInstansi dataDiri, AppDatabase database);

        void deleteData(AppDatabase database, DataInstansi dataInstansi);
    }
    interface Cetak extends View.OnClickListener{
        void getData(List<DataInstansi> list);
    }
    interface hapus{
        // void resetForm();
        void sukses();
        void deleteData(DataInstansi item);
    }
}
