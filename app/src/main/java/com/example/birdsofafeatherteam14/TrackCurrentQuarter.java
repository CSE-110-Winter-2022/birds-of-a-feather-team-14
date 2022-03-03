package com.example.birdsofafeatherteam14;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class TrackCurrentQuarter {

    public TrackCurrentQuarter(){}


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getQtr(){
        //get current Datetime from LocalDate api
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        String sYear = String.valueOf(year).substring(2);

        String sSeason = "";

        //SET WI qtr
        if(month == 1 || month == 2 || (month ==3 && day <=19)){
            sSeason ="WI";
        }
        //SET SP qtr
        if(month == 4 || month == 5 || (month ==3 && day >=19) || ( month == 6 && day <= 10)){
            sSeason ="SP";
        }

        //SET SS1 qtr
        if(month == 7 ||  (month ==6 && day >=27)){
            sSeason ="SS1";
        }

        //SET SS2 qtr
        if(month == 8 ||  (month == 9 && day <=3)){
            sSeason ="SS2";
        }

        //SET FA qtr
        if(month == 10 || month == 11 || month == 12|| (month ==9 && day >=20)){
            sSeason ="FA";
        }

        if(sSeason == ""){
            sSeason = "NOT IN ANY QUARTER";
        }

        //return in format "qtr + year" (i.e "FA22")
        return sSeason+sYear;

    }
}
