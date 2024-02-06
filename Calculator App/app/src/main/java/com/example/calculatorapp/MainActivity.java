package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtInput;
    Button btnCncl, btnBck, btnEql;
    Button btnPlus, btnMinus, btnMulti, btnDev;
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;

    String input;
    int First;
    int Second;
    int answer;
    String sign;
    String error;
    DecimalFormat DF = new DecimalFormat("###,######.#####################################################################");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edtInput);
        edtInput.setShowSoftInputOnFocus(false);

        btnCncl = findViewById(R.id.btnCancel);
        btnBck = findViewById(R.id.btnBack);
        btnEql = findViewById(R.id.btnEqual);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDev = findViewById(R.id.btnDevide);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        input = "";
        First = 0;
        Second = 0;
        sign = "";
        answer = 0;
        error = "";


        btnCncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText("");
                input = "";
                answer = 0;
                First = 0;
                Second = 0;
                sign = "";
            }
        });

        btnBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                char[] rem;

                if(input != null)
                {
                    rem = input.toCharArray();
                    int last = input.length() - 1;
                    rem[last] = ' ';
                    input = String.valueOf(rem).trim();
                    edtInput.setText(input);
                }

                if(answer != 0)
                {
                    edtInput.setText("");
                    answer = 0;
                }
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "0";
                edtInput.setText(input);
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "1";
                edtInput.setText(input);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "2";
                edtInput.setText(input);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "3";
                edtInput.setText(input);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "4";
                edtInput.setText(input);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "5";
                edtInput.setText(input);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "6";
                edtInput.setText(input);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "7";
                edtInput.setText(input);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "8";
                edtInput.setText(input);
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "9";
                edtInput.setText(input);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                First = Integer.valueOf(input);
                //input += " + ";
                sign = "+";
                edtInput.setText(input);
                input = "";
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                First = Integer.valueOf(input);
                //input += " - ";
                sign = "-";
                edtInput.setText(input);
                input = "";
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                First = Integer.valueOf(input);
                //input += " x ";
                sign = "*";
                edtInput.setText(input);
                input = "";
            }
        });
        btnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                First = Integer.valueOf(input.trim());
                //input += " / ";
                sign = "/";
                edtInput.setText(input);
                input = "";
            }
        });


        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = 0;

                Second = Integer.valueOf(input.trim());

                if(sign.equals("+"))
                {
                    answer = (int) (First + Second);
                    edtInput.setText("\n" + answer);
                    input = String.valueOf(answer);
                }else
                if(sign.equals("-"))
                {
                    answer = (int) (First - Second);
                    edtInput.setText("\n" + answer);
                    input = String.valueOf(answer);

                }else
                if(sign.equals("*"))
                {
                    answer = (int) (First * Second);
                    edtInput.setText("\n" + answer);
                    input = String.valueOf(answer);
                }else
                if(sign.equals("/"))
                {
                    double ans = 0.0;

                    if(Second != 0)
                    {
                        if (First % Second == 0)
                        {
                            answer = (int) (First / Second);
                            edtInput.setText("\n" + answer);
                            input = String.valueOf(answer);

                        } else {

                            ans = (double)(First / Second);
                            DF.setGroupingSize(3);
                            edtInput.setText("\n" + DF.format(ans).replace(",","."));
                            input = String.valueOf((int) ans);
                        }

                    }else
                    {
                        error = "Maths Error!";
                        edtInput.setText("\n" + error);
                    }
                }else
                {
                    First = Integer.valueOf(input.trim());
                    edtInput.setText("\n" + First);
                    input = String.valueOf(First);
                }


                First = 0;
                Second = 0;
                sign = "";
            }
        });
    }
}