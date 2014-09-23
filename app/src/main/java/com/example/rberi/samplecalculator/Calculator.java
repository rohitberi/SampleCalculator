package com.example.rberi.samplecalculator;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Calculator extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnMinus;
    private Button btnPlus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEquals;
    private Button btnDecimal;
    private Button btnClear;
    private Button btnMemoryClear;
    private Button btnMemoryPlus;
    private Button btnMemoryMinus;
    private TextView txtResults;
    private String sBeforeOperatorDisplayValue;
    private TextView txtOperator;
    private String sOperator = "";


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        txtResults = (TextView) findViewById(R.id.txtResults);
        txtOperator = (TextView) findViewById(R.id.txtOperator);
        sBeforeOperatorDisplayValue = "";

        btn1 = (Button) findViewById(R.id.btn1);
        btn0 = (Button) findViewById(R.id.btn0);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnMemoryClear = (Button) findViewById(R.id.btnClear);
        btnMemoryPlus = (Button) findViewById(R.id.btnMemoryPlus);
        btnMemoryMinus = (Button) findViewById(R.id.btnMemoryMinus);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnMemoryClear.setOnClickListener(this);
        btnMemoryPlus.setOnClickListener(this);
        btnMemoryMinus.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (txtResults.getText().equals("0")) {
            txtResults.setText("");
        }

        // Store value of currently selected Operator in this variable.
        sOperator = txtOperator.getText().toString();

        switch (v.getId()) {
            case R.id.btn1:
                txtResults.setText(txtResults.getText() + "1");
                break;

            case R.id.btn2:
                txtResults.setText(txtResults.getText() + "2");
                break;

            case R.id.btn3:
                txtResults.setText(txtResults.getText() + "3");
                break;

            case R.id.btn4:
                txtResults.setText(txtResults.getText() + "4");
                break;

            case R.id.btn5:
                txtResults.setText(txtResults.getText() + "5");
                break;

            case R.id.btn6:
                txtResults.setText(txtResults.getText() + "6");
                break;

            case R.id.btn7:
                txtResults.setText(txtResults.getText() + "7");
                break;

            case R.id.btn8:
                txtResults.setText(txtResults.getText() + "8");
                break;

            case R.id.btn9:
                txtResults.setText(txtResults.getText() + "9");
                break;

            case R.id.btn0:
                if (txtResults.getText().equals("")) {
                    // do nothing
                } else {
                    txtResults.setText(txtResults.getText() + "0");
                }
                break;

            case R.id.btnEquals:
                Log.e("DEBUG", "Entering Switch case for Equals...");
                if (!sBeforeOperatorDisplayValue.equals("") && sOperator != "") {
                    switch (sOperator) {
                        case "+":
                            Log.e("DEBUG", "Addition Operation to begin");
                            Log.e("DEBUG", "sBeforeOperatorDisplayValue: " + sBeforeOperatorDisplayValue);
                            Log.e("DEBUG", "txtResults.getText: " + txtResults.getText());

                            try {
                                int iTotal = Integer.parseInt(sBeforeOperatorDisplayValue) + Integer.parseInt(txtResults.getText().toString());
                                txtResults.setText(String.valueOf(iTotal));
                            } catch (NumberFormatException nfe) {
                                System.out.println("Could not parse " + nfe);
                                Log.e("ERROR", "nfe.getMessage(): " + nfe.getMessage());
                            }

							/*
                            //String sumExpression = "2+6";
							String sumExpression = txtResults.getText().toString();
							String[] numbers = sumExpression.split("\\+");
							int total = 0;

							for (String number: numbers) {
								total += Integer.parseInt(number.trim());
							}
							txtResults.setText(String.valueOf(total));
							*/

                            break;

                        case "-":
                            Log.e("DEBUG", "Subtraction Operation to begin");

                            try {
                                int iTotal = Integer.parseInt(sBeforeOperatorDisplayValue) - Integer.parseInt(txtResults.getText().toString());
                                txtResults.setText(String.valueOf(iTotal));
                            } catch (NumberFormatException nfe) {
                                System.out.println("Could not parse " + nfe);
                                Log.e("ERROR", "nfe.getMessage(): " + nfe.getMessage());
                            }

                            break;

                        case "/":
                            Log.e("DEBUG", "Division Operation to begin");

                            try {
                                int iTotal = Integer.parseInt(sBeforeOperatorDisplayValue) / Integer.parseInt(txtResults.getText().toString());
                                txtResults.setText(String.valueOf(iTotal));
                            } catch (NumberFormatException nfe) {
                                System.out.println("Could not parse " + nfe);
                                Log.e("ERROR", "nfe.getMessage(): " + nfe.getMessage());
                            }

                            break;

                        case "*":
                            Log.e("DEBUG", "Multiplication Operation to begin");

                            try {
                                int iTotal = Integer.parseInt(sBeforeOperatorDisplayValue) * Integer.parseInt(txtResults.getText().toString());
                                txtResults.setText(String.valueOf(iTotal));
                            } catch (NumberFormatException nfe) {
                                System.out.println("Could not parse " + nfe);
                                Log.e("ERROR", "nfe.getMessage(): " + nfe.getMessage());
                            }

                            break;
                    }
                    txtOperator.setText("");
                    sBeforeOperatorDisplayValue="";
                    sOperator="";
                    //txtResults =   sBeforeOperatorDisplayValue
                }
                break;

            case R.id.btnPlus:
                //Toast.makeText(this, "Button + pressed", Toast.LENGTH_SHORT).show();
              //  Toast.makeText(this, "sOperator = '" + sOperator.toString() + "' pressed", Toast.LENGTH_SHORT).show();
                if (sOperator.equals("")) {
                    // if the operator is being pressed the first time
                    sOperator = "+";
                    txtOperator.setText("+");
                    sBeforeOperatorDisplayValue = txtResults.getText().toString();
                    txtResults.setText("");
                } else {
                    // if the operator is already set, leave it as is.
                }
                break;

            case R.id.btnDivide:
                if (sOperator.equals("")) {
                    // if the operator is being pressed the first time
                    sOperator = "/";
                    txtOperator.setText("/");
                    sBeforeOperatorDisplayValue = txtResults.getText().toString();
                    txtResults.setText("");
                } else {
                    // if the operator is already set, leave it as is.
                }
                break;

            case R.id.btnMinus:
                if (sOperator.equals("")) {
                    // if the operator is being pressed the first time
                    sOperator = "-";
                    txtOperator.setText("-");
                    sBeforeOperatorDisplayValue = txtResults.getText().toString();
                    txtResults.setText("");
                } else {
                    // if the operator is already set, leave it as is.
                }
                break;

            case R.id.btnMultiply:
                if (sOperator.equals("")) {
                    // if the operator is being pressed the first time
                    sOperator = "*";
                    txtOperator.setText("*");
                    sBeforeOperatorDisplayValue = txtResults.getText().toString();
                    txtResults.setText("");
                } else {
                    // if the operator is already set, leave it as is.
                }
                break;

            case R.id.btnClear:
                sOperator = "";
                txtOperator.setText("");
                txtResults.setText("0");
                sBeforeOperatorDisplayValue = "";
                break;

            case R.id.btnMemoryClear:
                break;
            case R.id.btnMemoryPlus:
                break;
            case R.id.btnMemoryMinus:
                break;
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.calculator, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((Calculator) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
