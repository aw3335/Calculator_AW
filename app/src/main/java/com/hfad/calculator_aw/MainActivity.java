package com.hfad.calculator_aw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String numbers = "";
    private boolean isEquationSign = true;
    private boolean isRepeated = false;
    private String equationSign = "";
    private boolean isSecondEquation = false;
    private boolean equalLoop = false;
    private int counterForLoop = 0;
    private String storedNum = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnZero = findViewById(R.id.btn0);
        Button btnOne = findViewById(R.id.btn1);
        Button btnTwo = findViewById(R.id.btn2);
        Button btnThree = findViewById(R.id.btn3);
        Button btnFour = findViewById(R.id.btn4);
        Button btnFive = findViewById(R.id.btn5);
        Button btnSix = findViewById(R.id.btn6);
        Button btnSeven = findViewById(R.id.btn7);
        Button btnEight = findViewById(R.id.btn8);
        Button btnNine = findViewById(R.id.btn9);

        Button btnAC = findViewById(R.id.btnAC);
        Button btnNegPos = findViewById(R.id.btnNegPos);
        Button btnPercent = findViewById(R.id.btnPercent);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnAdd = findViewById(R.id.btnPlus);
        Button btnDecimal = findViewById(R.id.btnDecimal);
        Button btnEquals = findViewById(R.id.btnEquals);
        TextView tvDisplay = findViewById(R.id.Display);

        ArrayList<String> equation = new ArrayList<String>();


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("0", tvDisplay, equation);
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("1", tvDisplay, equation);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("2", tvDisplay, equation);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("3", tvDisplay, equation);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("4", tvDisplay, equation);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("5", tvDisplay, equation);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("6", tvDisplay, equation);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("7", tvDisplay, equation);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("8", tvDisplay, equation);
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("9", tvDisplay, equation);
            }
        });


        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.clear();
                numbers = "";
                tvDisplay.setText("0");
                isRepeated = false;
                isSecondEquation = false;
                isEquationSign = true;
                equationSign = "";


            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("+", tvDisplay, equation);
                numbers = "";
                isEquationSign = true;
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("-", tvDisplay, equation);
                numbers = "";
                isEquationSign = true;
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("X", tvDisplay, equation);
                numbers = "";
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("/", tvDisplay, equation);
                numbers = "";
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total = "";

                if(numbers != "") {
                    if (equalLoop == true && counterForLoop > 0) {
                        equation.add(equationSign);
                        equation.add(storedNum);

                        equalsEquation(equation, storedNum, tvDisplay);
                    }
                    else
                    {
                        equation.add(numbers);
                        equalLoop = true;
                        counterForLoop += 1;
                        equalsEquation(equation, numbers, tvDisplay);
                        storedNum = numbers;
                        numbers = "";

                    }
                    total = equation.toString();
                    tvDisplay.setText(total.replace("[", "").replace("]", ""));

                }
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numbers.equals("0"))
                {

                }
                else {
                    double percent = Double.parseDouble(numbers);
                    percent /= 100;
                    numbers = "" + percent;
                    tvDisplay.setText(numbers);
                }
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(".",tvDisplay, equation);
            }
        });

        btnNegPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numbers.contains("-"))
                {
                    numbers =  numbers.replace("-", "");
                }
                else
                {
                    numbers = "-" + numbers;
                }
                tvDisplay.setText(numbers);
            }
        });



    }
    public void addOn(String addNum, TextView display, ArrayList<String> equation)
    {

        switch(addNum) {
            case "0":
                numbers += "0";
                isEquationSign = false;
                break;
            case "1":
                numbers += "1";
                isEquationSign = false;
                break;
            case "2":
                numbers += "2";
                isEquationSign = false;
                break;
            case "3":
                numbers += "3";
                isEquationSign = false;
                break;
            case "4":
                numbers += "4";
                isEquationSign = false;
                break;
            case "5":
                numbers += "5";
                isEquationSign = false;
                break;
            case "6":
                numbers += "6";
                isEquationSign = false;
                break;
            case "7":
                numbers += "7";
                isEquationSign = false;
                break;
            case "8":
                numbers += "8";
                isEquationSign = false;
                break;
            case "9":
                numbers += "9";
                isEquationSign = false;
                break;
            default:
                break;
        }
        isSecondEquation = false;
        equalLoop = false;
        if(!numbers.contains(".") && addNum == ".")
        {
            numbers += ".";
        }
        display.setText(numbers);
    }
    public void setEquationSign(String sign, TextView disp, ArrayList<String> equation)
    {
        if(!isSecondEquation){
            if(isEquationSign == false)
            {
                if(sign.equals("+"))
                {
                    if (numbers.equals(""))
                    {
                        numbers = "0";
                    }
                    else if(!isRepeated) {
                        equation.add(numbers);
                        isRepeated = false;
                    }

                    equation.add("+");
                    equationSign = "+";
                    disp.setText(sign);
                    numbers = "";
                    isSecondEquation = true;
                }
                else if(sign.equals("-"))
                {
                    if (numbers.equals(""))
                    {
                        numbers = "0";
                    }
                    else if(!isRepeated) {
                        equation.add(numbers);
                        isRepeated = false;
                    }

                    equation.add("-");
                    disp.setText(sign);
                    numbers = "";
                    equationSign = "-";
                    isSecondEquation = true;
                }
                else if(sign.equals("X"))
                {
                    if (numbers.equals(""))
                    {
                        numbers = "0";
                    }
                    else if(!isRepeated) {
                        equation.add(numbers);
                        isRepeated = false;
                    }

                    equation.add("X");
                    disp.setText(sign);
                    numbers = "";
                    equationSign = "X";
                    isSecondEquation = true;
                }
                else if(sign.equals("/"))
                {
                    if (numbers.equals(""))
                    {
                        numbers = "0";
                    }
                    else if(!isRepeated) {
                        equation.add(numbers);
                        isRepeated = false;
                    }

                    equation.add("/");
                    disp.setText(sign);
                    numbers = "";
                    equationSign = "/";
                    isSecondEquation = true;
                }
            }
           else
            {
                equation.add(equationSign);
                equation.add(numbers);
                numbers = "";
                isEquationSign = false;
            }}
    }

    public void equalsEquation(ArrayList<String> equation, String input, TextView display)
    {

        int indexM = 0;
        int indexD = 0;
        int indexSmall = 0;

        indexM = equation.indexOf("X");
        indexD = equation.indexOf("/");

        while(indexM != -1 || indexD != -1)
        {
            indexSmall = findMinIndex(equation, "X", "/");
            performOperation(equation, indexSmall, display);

            indexM = equation.indexOf("X");
            indexD = equation.indexOf("/");
        }

        int indexA = 0;
        int indexS = 0;

        indexA = equation.indexOf("+");
        indexS = equation.indexOf("-");

        while(indexA != -1 || indexS != -1)
        {
            indexSmall = findMinIndex(equation, "+", "-");
            performOperation(equation, indexSmall, display);
            //System.out.println(equation);
            indexA = equation.indexOf("+");
            indexS = equation.indexOf("-");
        }


    }

    public static int findMinIndex(ArrayList<String> wE, String op1, String op2)
    {
        int indexM = 0;
        int indexD = 0;
        int indexSmall = 0;

        indexM = wE.indexOf(op1);
        indexD = wE.indexOf(op2);

        if(indexM == -1)
        {
            indexSmall = indexD;
        }
        else if (indexD == -1)
        {
            indexSmall = indexM;
        }
        else if (indexM < indexD)
        {
            indexSmall = indexM;
        }
        else
            indexSmall = indexD;
        return indexSmall;
    }

    public void performOperation(ArrayList<String> equation, int i, TextView disp)
    {
        double num1 = Double.parseDouble(equation.get(i-1).toString());
        double num2 = Double.parseDouble(equation.get(i+1).toString());
        String op = equation.get(i).toString();
        double answer = 0;

        if(op.equals("X"))
        {
            answer = num1 * num2;
        }
        else if (op.equals("/"))
        {
            if(num2 == 0 || num2 == 0.00)
            {
                Context context = getApplicationContext();

                String text = "Divide by Zero Error. It has been taken out of the problem.";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                answer = num1 / 1;
            }
            else {
                answer = num1 / num2;
            }
        }
        else if (op.equals("+"))
        {
            answer = num1 + num2;
        }
        else
        {
            answer = num1 - num2;
        }
        equation.remove(i+1);
        equation.remove(i-1);

        String total = "";

        if(answer % 1 != 0) {
            total = String.format("%.2f", answer);
        }
        else
        {
            total = String.format("%.0f", answer);
        }
        equation.set(i-1, total);
    }
}
