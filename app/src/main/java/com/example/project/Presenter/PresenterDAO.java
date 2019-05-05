package com.example.project.Presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.project.entity.AppDatabase;
import com.example.project.entity.DataInstansi;
import com.example.project.view.MainContact;

public class PresenterDAO implements MainContact.datapresenter {
    MainContact.view view;
    MainContact.hapus viewH;

    public PresenterDAO(MainContact.view view) {
        this.view = view;
    }

    public PresenterDAO(MainContact.hapus viewH) {
        this.viewH = viewH;
    }

    class DeleteData extends AsyncTask<Void, Void, Void>{
        private AppDatabase database;
        private DataInstansi dataInstansi;
        Context context;
        public DeleteData(AppDatabase database, DataInstansi dataInstansi) {
            this.database = database;
            this.dataInstansi = dataInstansi;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataInstansi);
            return  null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewH.sukses();
        }
    }
    @Override
    public void deleteData(DataInstansi dataInstansi, AppDatabase database) {
        new DeleteData(database,dataInstansi).execute();
    }
}

