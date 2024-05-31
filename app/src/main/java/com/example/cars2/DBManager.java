package com.example.cars2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {

        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean saveCarToDatabase(Cars car) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase(); // получили ссылку на базу данных
// создание переменной для хранения данных в формате "ключ-значение" // по сути формируем запись для вставки в БД
        ContentValues cv = new ContentValues();
        cv.put("name", car.getName());
        cv.put("number", car.getNumber());
        cv.put("year", car.getYear());
//вставка записи в таблицу базы данных
//метод возвращает номер строки в случае успешной вставки или -1, если произошла ошибка
        long rowId = db.insert("TABLE_CARS", null, cv);
        cv.clear(); // очистка
        db.close(); // закрытие базы данных
        return rowId != -1;
        // возвращаем результат вставки
    }


    public ArrayList<Cars> loadAllCarsFromDatabase() {
        ArrayList<Cars> cars = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getReadableDatabase();
        Cursor dbCursor = db.query("TABLE_CARS",
                null, null, null, null, null, null);
        while (dbCursor.moveToNext()) {
            String name = dbCursor.getString(dbCursor.getColumnIndexOrThrow("name"));
            String number = dbCursor.getString(dbCursor.getColumnIndexOrThrow("number"));
            int year = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("year"));
            cars.add(new Cars(name, number, year));
        }
        dbCursor.close();
        return cars;
    }
}
