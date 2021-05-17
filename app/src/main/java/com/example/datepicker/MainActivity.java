package com.example.datepicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button b1;
    static  int year,month,day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c= Calendar.getInstance();
        year= c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);


        b1=findViewById(R.id.btnclick);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(),"datepicker");
            }
        });
    }

    public static class DatePickerFragment extends DialogFragment  implements DatePickerDialog.OnDateSetListener{

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
        {
            return  new DatePickerDialog(getActivity(),this,2021,MainActivity.month,MainActivity.day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            Toast.makeText(getActivity(), "Date"+"Year"+":" +(month+1) + dayOfMonth, Toast.LENGTH_SHORT).show();
        }
    }
}