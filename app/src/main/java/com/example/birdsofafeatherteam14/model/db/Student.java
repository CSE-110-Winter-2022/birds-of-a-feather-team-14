package com.example.birdsofafeatherteam14.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {


    public Student(int studentId, int sessionId, String name, String photo, String uuid, boolean isFav) {
        this.studentId = studentId;
        this.sessionId = sessionId;
        this.name = name;
        this.photo = photo;
        this.uuid = uuid;
        this.wave = false;
        this.isFav = isFav;
    }

    @PrimaryKey
    @ColumnInfo(name = "student_id")
    public int studentId;

    @ColumnInfo(name = "uuid")
    public String uuid;

    @ColumnInfo(name = "session_id")
    public int sessionId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "photo")
    public String photo;

    @ColumnInfo(name = "wave")
    public boolean wave;
    @ColumnInfo(name = "is_fav")
    public boolean isFav;

    public String getName() {return name;}

    public String getPhoto() {return photo;}

    public String getUuid() {return uuid;}

    public int getId() {return this.studentId;}

    public int getSessionId() {return this.sessionId;}

    public boolean getFavourite(){return this.isFav;}

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;

        if (obj.getClass() != this.getClass()) return false;

        Student student = (Student) obj;
        if (this.studentId != student.studentId) return false;

        return true;
    }
}
