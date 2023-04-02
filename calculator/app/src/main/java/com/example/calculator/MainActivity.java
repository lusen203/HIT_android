package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.calculator.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn_0, btn_1,btn_2,btn_3,btn_4,btn_5,
            btn_6,btn_7,btn_8,btn_9,btnCong,btnTru,btnNhan,btnChia,
            btnAC,btnPhamTram,btnPhan,btnBang;
    private TextView solution,result;
    double firstNumber=0,lastNumber=0;
    boolean operator=false;
    String status=null;
    private String number=null;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=this.findViewById(R.id.btn_0);
        btn_1=this.findViewById(R.id.btn_1);
        btn_2=this.findViewById(R.id.btn_2);
        btn_3=this.findViewById(R.id.btn_3);
        btn_4=this.findViewById(R.id.btn_4);
        btn_5=this.findViewById(R.id.btn_5);
        btn_6=this.findViewById(R.id.btn_6);
        btn_7=this.findViewById(R.id.btn_7);
        btn_8=this.findViewById(R.id.btn_8);
        btn_9=this.findViewById(R.id.btn_9);

        btnCong=this.findViewById(R.id.btnCong);
        btnTru=this.findViewById(R.id.btnTru);
        btnNhan=this.findViewById(R.id.btnNhan);
        btnChia=this.findViewById(R.id.btnChia);

        btnAC=this.findViewById(R.id.btnAC);
        btnPhan=this.findViewById(R.id.btnPhan);
        btnPhamTram=this.findViewById(R.id.btnPhamTram);
        btnBang=this.findViewById(R.id.btnBang);

        solution=this.findViewById(R.id.solution);
        result=this.findViewById(R.id.result);

        btn_0.setOnClickListener(view -> numberclick("0"));
        btn_1.setOnClickListener(view -> numberclick("1"));
        btn_2.setOnClickListener(view -> numberclick("2"));
        btn_3.setOnClickListener(view -> numberclick("3"));
        btn_4.setOnClickListener(view -> numberclick("4"));
        btn_5.setOnClickListener(view -> numberclick("5"));
        btn_6.setOnClickListener(view -> numberclick("6"));
        btn_7.setOnClickListener(view -> numberclick("7"));
        btn_8.setOnClickListener(view -> numberclick("8"));
        btn_9.setOnClickListener(view -> numberclick("9"));

        btnCong.setOnClickListener(view -> {
            if(operator){
                if(status=="Nhan"){
                    Nhan();
                }else {
                    if(status=="Chia"){
                        Chia();
                    }else{
                        if(status=="Tru"){
                            Tru();
                        }else{
                            if(status=="Cong"){
                                Cong();
                            }
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="Cong";
        });

        btnTru.setOnClickListener(view -> {
            if(operator){
                if(status=="Nhan"){
                    Nhan();
                }else {
                    if(status=="Chia"){
                        Chia();
                    }else{
                        if(status=="Cong"){
                            Cong();
                        }else{
                            if(status=="Tru"){
                                Tru();
                            }
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="Tru";
        });
        btnNhan.setOnClickListener(view -> {
            if(operator){
                if(status=="Cong"){
                    Cong();
                }else {
                    if(status=="Chia"){
                        Chia();
                    }else{
                        if(status=="Tru"){
                            Tru();
                        }else{
                            if(status=="Nhan"){
                                Nhan();
                            }
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="Nhan";
        });

        btnTru.setOnClickListener(view -> {
            if(operator){
                if(status=="Nhan"){
                    Nhan();
                }else {
                    if(status=="Cong"){
                        Cong();
                    }else{
                        if(status=="Tru"){
                            Tru();
                        }else{
                            if(status=="Chia"){
                                Chia();
                            }
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="Chia";
        });

        btnTru.setOnClickListener(view -> {
            if(operator){
                if(status=="Nhan"){
                    Nhan();
                }else {
                    if(status=="Chia"){
                        Chia();
                    }else{
                        if(status=="Cong"){
                            Cong();
                        }else{
                            if(status=="Tru"){
                                Tru();
                            }
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="minus";
        });

    }

    public void numberclick(String view){
        if(number==null){
            number=view;
        }else{
            number=number+view;
        }

        result.setText(number);
        operator=true;
    }

    public void Tru(){
        if(firstNumber==0){
            firstNumber=Double.parseDouble(result.getText().toString());
        }else{
            lastNumber=Double.parseDouble(result.getText().toString());
            firstNumber=firstNumber-lastNumber;
        }
        result.setText(""+firstNumber);
    }
    public void Cong(){
        lastNumber=Double.parseDouble(result.getText().toString());
        firstNumber=firstNumber+lastNumber;
        result.setText(""+firstNumber);
    }

    public void Chia(){
        if(firstNumber==0){
            firstNumber=Double.parseDouble(result.getText().toString());
            firstNumber=lastNumber;
        }else{
            lastNumber=Double.parseDouble(result.getText().toString());
            firstNumber=firstNumber/lastNumber;
        }
        result.setText(""+firstNumber);
    }

    public void Nhan(){
        if(firstNumber==0) {
            firstNumber = 1;
        }
        lastNumber=Double.parseDouble(result.getText().toString());
        firstNumber=firstNumber*lastNumber;
        result.setText(""+firstNumber);
    }

}