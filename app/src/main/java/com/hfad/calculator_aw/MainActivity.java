package com.hfad.calculator_aw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Main Class that runs the backend code for the calculator.
 * Author: Austin Weaver, A Little Help from Manny on the Equal Equation Method
 */
public class MainActivity extends AppCompatActivity {

    private String numbers = ""; //String variable that stores the numbers to be added to the arraylist
    private String equationSign = ""; //String variable that holds the equation sign that will be entered into the arraylist
    // String variable that holds the number when the numbers string is cleared for the loop of the equals method
    private String storedNum = "";
    private String secSign = ""; //String variable that stores the equation sign used previously
    //Boolean variable that checks if the previous input in the arraylist is a equation sign
    private boolean isEquationSign = true;
    private boolean isRepeated = false; //Boolean variable that checks if the equals method has been selected twice
    private boolean isSecondEquation = false; //Tell the program if the user is Entering more than one equation
    private boolean equalLoop = false; //Initiator for the equals method to loop the same arithmetic repeatedly
    private boolean numIsSelected = false; //Boolean variable that tells the program if the last entry was a number
    private int counterForLoop = 0; //Counter for the equal loop to allow the first iteration to be bypassed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        *For every button I created a object that can be called and acted upon
         */
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

        /*
        *Same for every button that was not a number
         */
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

        //Generate a empty ArrayList that will store the equation to be calculated
        ArrayList<String> equation = new ArrayList<String>();

        /**
         * OnClickListener for btnZero
         * When 0 button is selected add a zero to the numbers string
         */
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("0", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnOne
         * When 1 button is selected add a one to the numbers string
         */
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("1", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnTwo
         * When 2 button is selected add a two to the numbers string
         */
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("2", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnThree
         * When 3 button is selected add a three to the numbers string
         */
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("3", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnFour
         * When 4 button is selected add a four to the numbers string
         */
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("4", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnFive
         * When 5 button is selected add a five to the numbers string
         */
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("5", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnSix
         * When 6 button is selected add a six to the numbers string
         */
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("6", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnSeven
         * When 7 button is selected add a seven to the numbers string
         */
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("7", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnEight
         * When 8 button is selected add a eight to the numbers string
         */
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("8", tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnNine
         * When 9 button is selected add a nine to the numbers string
         */
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn("9", tvDisplay, equation);
            }
        });


        /**
         * OnClickListener for btnAC
         * When the AC button is click, the program clears
         * everything, setting them to default, so it can give the user an idea of a reset
         */
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
                numIsSelected = false;
            }
        });

        /**
         * OnClickListener for btnAdd
         * When the add button is clicked, call the setEquationSign method, adding a plus to the arraylist
         * Also clear numbers so it can take a second input, and let the program know the
         * last entered thing is a equation sign. Also save the plus sign in the secSign variable.
         */
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("+", tvDisplay, equation);
                numbers = "";
                isEquationSign = true;
                secSign = "+";
            }
        });

        /**
         * OnClickListener for btnSubtract
         * When the subtract button is pressed it does the same as the plus. First calls the setEquationSign
         * method which will add the minus sign to the arrayList and then clear the numbers string. Then let the
         * program know the last entered thing is an equation sign. And last save the minus sign in the secSign variable.
         */
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("-", tvDisplay, equation);
                numbers = "";
                isEquationSign = true;
                secSign = "-";
            }
        });

        /**
         * OnClickListener for btnMultiply
         * When the multiply button is pressed it does the same as the plus and minus. First it calls the setEquationSign
         * method which will add the multiply(X) sign to the arrayList and then clear the numbers string. Then it lets the
         * program know the last entered thing is an equation sign. And last it saves the X sign in the secSign variable.
         */
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("X", tvDisplay, equation);
                numbers = "";
                isEquationSign = true;
                secSign = "X";
            }
        });

        /**
         * OnClickListener for btDivide
         * When the divide button is pressed it does the same as the plus, minus, and multiply. First it calls
         * the setEquationSign method which will add the divide(/) sign to the arrayList and then clear the
         * numbers string. Then it lets the program know the last entered thing is an equation sign. And last
         * it saves the divide sign in the secSign variable.
         */
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEquationSign("/", tvDisplay, equation);
                numbers = "";
                isEquationSign = true;
                secSign = "/";
            }
        });

        /**
         * OnClickListener for btnEquals
         * When btnEquals is called it first checks to see if the user gave any number at all. This is done by the
         * numIsSelected boolean. If given the program know it can produce a equation to run. Next thing it checks
         * is if the number string contains any numbers. If it contains numbers it should run the program like (2 + 2)
         * else just run (+ 2) allowing for multiple iteration of the same equation. Once known if there is any
         * numbers, check if the program should run a loop and only if the counter is above zero. This stops it from
         * looping on the first iteration. After each section it calls the equalsEquation method which sets up the arraylist
         * properly for computation to be able to be held.
         */
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total = ""; //The value that is displayed on the textView
                if (numIsSelected == true && !numbers.equals("-")) {
                        if (equalLoop == true && counterForLoop > 0) {
                            equation.add(equationSign); //Adds the equation sign(*, /, +, -) to the arraylist
                            equation.add(storedNum); //Adds the stored number from the numbers string

                            equalsEquation(equation);
                        } else {
                            equation.add(numbers); //Adds the current number to the arraylist
                            equalLoop = true; //Allows the next time, so second time, the method is pressed to loop it
                            counterForLoop += 1; //Activates the second condition in order to loop the first part
                            equalsEquation(equation);
                            storedNum = numbers; //Stores the numbers so the program can clear it and allow for more input
                            numbers = ""; //Resets the numbers string to "" so the user can enter in more arithmetic numbers
                        }
                        total = equation.toString(); //Sets the total string to the equation arraylist
                        //Sets the display to the equationArraylist without the brackets
                        tvDisplay.setText(total.replace("[", "").replace("]", ""));
                    } else {
                        equation.add(secSign); // Adds the stored equation sign to the arrayList
                        equation.add(storedNum); //Adds the stored number from the numbers string
                        equalsEquation(equation);
                        total = equation.toString();//Sets the total string to the equation arraylist
                        //Sets the display to the equationArraylist without the brackets
                        tvDisplay.setText(total.replace("[", "").replace("]", ""));
                    }
                }
        });

        /**
         * OnClickListener for btnPercent
         * When the percent button is click it takes the current number and divides it by 100
         */
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //As long as the number does not equal zero continue with the division
                if(!numbers.equals("0") && !numbers.equals("") && !numbers.equals("-"))
                {
                    double percent = Double.parseDouble(tvDisplay.getText().toString()); //Turn the string into a double to be computed
                    percent /= 100; //Sets percent equal to itself / 100
                    numbers = "" + percent; //Adds that double number back into string format
                    tvDisplay.setText(numbers); //Displays that newly calclated number
                }
            }
        });

        /**
         * OnClickListener for btnDecimal
         * When the decimal button is selected the addOn function will be called
         * adding on a decimal to the string only once
         */
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOn(".",tvDisplay, equation);
            }
        });

        /**
         * OnClickListener for btnNegPos
         * When the negative/positive button is selected the program takes the current numbers and
         * checks if it contains a negative. If it does then it replaces it with nothing. If it does not,
         * then it adds it to the beginning of the string
         */
        btnNegPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If the number contains a negative sign then replace it else add it on
                if(numbers.contains("-"))
                {
                    numbers =  numbers.replace("-", "");
                }
                else
                {
                    numbers = "-" + numbers;
                }
                //Display the text after the change
                tvDisplay.setText(numbers);
            }
        });
    }

    /**
     * Add on function that takes in a string and if it matches a case in the switch statement, it will
     * add it to the numbers string.
     * @param addNum //The number the program should add
     * @param display //The textView so it can display the new number
     */
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
        /*if(check == true && !isSecondEquation && !equation.isEmpty())
        {
            //Attempt at stopping multiple equation being entered
            equation.clear();
            check = false;

        }*/

        isSecondEquation = false; //Lets the program know that the user is just entering a new number
        equalLoop = false; //Since a new number is pressed, the code is now open to doing a loop
        numIsSelected = true; //Lets the program know that a number has know been selected

        //If the number does not contain a decimal and the code wants to add it then allow it to be added
        if(!numbers.contains(".") && addNum == ".")
        {
            numbers += ".";
        }
        //Displays the newly generated number
        display.setText(numbers);
    }

    /**
     * setEquationSign Method that sets up the arraylist for the calculations. First this method checks
     * if a number has been selected. If so then proceed normally. If one has not been selected then depending
     * on which number add a zero before or after the equation sign so the code still runs. Next thing it checks
     * is if it is a secondEquation. If hit do nothing, if its not a second equation then proceed with the setup.
     * Next it checks to make sure there is not an equationSign selected before this one. If false then proceed normally.
     * If hit then just add the info needed and then don't do anything else. Finally we get the if statments
     * that check for each sign (*, /, +, -). When it hits a certain sign it first makes sure the number given
     * is not empty. If hit then set it to zero. Then it checks if it is not repeated. If not repeated then add the
     * number to the arraylist. After adding the number, it adds the equation sign and stores it for future usage.
     * The method then displays the sign so the user know that the sign has been selected. Then the method clears the
     * numbers string so the user can enter more and sets isSecondEquation to false
     */
    public void setEquationSign(String sign, TextView disp, ArrayList<String> equation)
    {
        if(numIsSelected)
        {
            if (!isSecondEquation)
            {
                if (isEquationSign == false)
                {
                    //If the sign equals + then add the number to the arraylist followed by the + and then sets
                    //it up for another number to be entered. This occurs for all 4 equation signs.
                    if (sign.equals("+"))
                    {
                        if (numbers.equals(""))
                        {
                            numbers = "0";
                        }
                        else if (!isRepeated)
                        {
                            equation.add(numbers);
                            isRepeated = false;
                        }
                        equation.add("+");
                        equationSign = "+";
                        disp.setText(sign);
                        numbers = "";
                        isSecondEquation = false;
                    }
                    else if (sign.equals("-"))
                    {
                        if (numbers.equals(""))
                        {
                            numbers = "0";
                        }
                        else if (!isRepeated)
                        {
                            equation.add(numbers);
                            isRepeated = false;
                        }
                        equation.add("-");
                        disp.setText(sign);
                        numbers = "";
                        equationSign = "-";
                        isSecondEquation = false;
                    }
                    else if (sign.equals("X"))
                    {
                        if (numbers.equals(""))
                        {
                            numbers = "0";
                        }
                        else if (!isRepeated)
                        {
                            equation.add(numbers);
                            isRepeated = false;
                        }
                        equation.add("X");
                        disp.setText(sign);
                        numbers = "";
                        equationSign = "X";
                        isSecondEquation = false;
                    }
                    else if (sign.equals("/"))
                    {
                        if (numbers.equals(""))
                        {
                            numbers = "0";
                        }
                        else if (!isRepeated)
                        {
                            equation.add(numbers);
                            isRepeated = false;
                        }
                        equation.add("/");
                        disp.setText(sign);
                        numbers = "";
                        equationSign = "/";
                        isSecondEquation = false;
                    }
                }
                else
                {
                    equation.add(equationSign);
                    equation.add(numbers);
                    numbers = "";
                    isEquationSign = false;
                }
            }
            numIsSelected = false;
        }
        else
        {
            //If the user enter (+3) the code will enter a zero before the plus to continue the code
            if(equation.isEmpty())
            {
                equation.add("0");
                equation.add(sign);
                numbers = "";
            }
            else
            {
                equation.add(sign);
            }
        }
    }

    /**
     * equalsEquation method that finds the indexes of the signs and calls the performOperation method to
     * calculate with the proper indexes
     * @param equation //The equation arrayList that allows the program to retireve info from it
     */
    public void equalsEquation(ArrayList<String> equation)
    {

        int multiplyIndex = 0;
        int divisionIndex = 0;
        int minimumIndex = 0;
        int additionIndex = 0;
        int subtractIndex = 0;

        multiplyIndex = equation.indexOf("X");
        divisionIndex = equation.indexOf("/");

        while(multiplyIndex != -1 || divisionIndex != -1)
        {
            minimumIndex = findMinIndex(equation, "X", "/");
            performOperation(equation, minimumIndex);

            multiplyIndex = equation.indexOf("X");
            divisionIndex = equation.indexOf("/");
        }

        additionIndex = equation.indexOf("+");
        subtractIndex = equation.indexOf("-");

        while(additionIndex != -1 || subtractIndex != -1)
        {
            minimumIndex = findMinIndex(equation, "+", "-");
            performOperation(equation, minimumIndex);
            additionIndex = equation.indexOf("+");
            subtractIndex = equation.indexOf("-");
        }


    }

    /**
     * findMinIndex function that find the first occurrence where the correct operation is located
     * in the arrayList
     * @param equation //The arrayList with the equation
     * @param operationOne //The first equation Sign that we are looking for
     * @param operationTwo //The second equation Sign that we are looking for
     * @return //The minimum index in the arrayList that either one of the string is located at(+ or -),(* or /)
     */
    public static int findMinIndex(ArrayList<String> equation, String operationOne, String operationTwo)
    {
        int indexM = 0;
        int indexD = 0;
        int indexSmall = 0;

        indexM = equation.indexOf(operationOne);
        indexD = equation.indexOf(operationTwo);

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

    /**
     * performOperation function that takes in the equation in the correct order and using the index
     * performs the correct calculations in order of pemdas. When dividing if the user enters zero the code will
     * just divide by one so nothing happens on the users side of the view. In the end display the answer with the
     * correct number of decimal points.
     * @param equation //The complete equation ready to be calculated
     * @param index //The point at which numbers to take to do the arithmetic
     */
    public void performOperation(ArrayList<String> equation, int index)
    {
        double num1 = Double.parseDouble(equation.get(index-1).toString());
        double num2 = Double.parseDouble(equation.get(index+1).toString());
        String op = equation.get(index).toString();
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
        equation.remove(index+1);
        equation.remove(index-1);

        String total = "";

        if(answer % 1 != 0) {
            total = String.format("%.2f", answer);
        }
        else
        {
            total = String.format("%.0f", answer);
        }
        equation.set(index-1, total);
    }
}
