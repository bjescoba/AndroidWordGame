package com.escobar.brian.thewordgame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button start_button = (Button) findViewById(R.id.start_button);
        final TextView timer = (TextView) findViewById(R.id.timer);
        final TextView restrictions_text = (TextView) findViewById(R.id.restrictions_text);
        final EditText word_field = (EditText) findViewById(R.id.word_field);
        final TextView word_bank = (TextView) findViewById(R.id.word_bank);
        final int randomN = randomNumber(4, 6);
        final char randomL = randomLetter();
        final int[] listCount = {0};

        word_field.setEnabled(false);
        word_field.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_button.setEnabled(false);
                word_field.setEnabled(true);
                word_field.requestFocus();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(word_field, InputMethodManager.SHOW_IMPLICIT);

                new CountDownTimer(60000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        int secondsLeft = (int) millisUntilFinished / 1000;
                        timer.setText("" + secondsLeft);

                        if (secondsLeft <= 10) {
                            timer.setTextColor(Color.RED);
                        }
                    }

                    @Override
                    public void onFinish() {
                        word_field.setEnabled(false);
                        timer.setText("Time's Up!");
                        timer.setTextColor(Color.RED);
                    }
                }.start();

                restrictions_text.setText(randomN + "-letter word starting with '" + randomL + ".'");
            }
        });

        timer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(timer.getText().toString().matches("Time's Up!")){
                    AlertDialog.Builder abuilder = new AlertDialog.Builder(MainActivity.this);
                    abuilder.setTitle("Results:")
                            .setMessage("Total Accepted Words: \t" + listCount[0] + "\nx Length Difficulty:         \t" + randomN + "\n\nYour Total Score:          \t" + (listCount[0] * randomN))
                            .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    startActivity(getIntent());
                                }
                            })
                            .setNegativeButton("BACK TO GAME", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    AlertDialog alertd = abuilder.create();
                    alertd.show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        word_field.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    String entered_word = word_field.getText().toString().trim();
                    if(entered_word.isEmpty()){
                        return true;
                    }else if (entered_word.startsWith(String.valueOf(randomL))
                            && entered_word.length() == randomN) {
                        word_field.setText("");

                        String str_name = String.valueOf(randomL).toUpperCase() + "_" + randomN;
                        String str;

                        switch (str_name) {
                            case "A_4":
                                str = getString(R.string.A_4);
                                break;
                            case "A_5":
                                str = getString(R.string.A_5);
                                break;
                            case "A_6":
                                str = getString(R.string.A_6);
                                break;
                            case "B_4":
                                str = getString(R.string.B_4);
                                break;
                            case "B_5":
                                str = getString(R.string.B_5);
                                break;
                            case "B_6":
                                str = getString(R.string.B_6);
                                break;
                            case "C_4":
                                str = getString(R.string.C_4);
                                break;
                            case "C_5":
                                str = getString(R.string.C_5);
                                break;
                            case "C_6":
                                str = getString(R.string.C_6);
                                break;
                            case "D_4":
                                str = getString(R.string.D_4);
                                break;
                            case "D_5":
                                str = getString(R.string.D_5);
                                break;
                            case "D_6":
                                str = getString(R.string.D_6);
                                break;
                            case "E_4":
                                str = getString(R.string.E_4);
                                break;
                            case "E_5":
                                str = getString(R.string.E_5);
                                break;
                            case "E_6":
                                str = getString(R.string.E_6);
                                break;
                            case "F_4":
                                str = getString(R.string.F_4);
                                break;
                            case "F_5":
                                str = getString(R.string.F_5);
                                break;
                            case "F_6":
                                str = getString(R.string.F_6);
                                break;
                            case "G_4":
                                str = getString(R.string.G_4);
                                break;
                            case "G_5":
                                str = getString(R.string.G_5);
                                break;
                            case "G_6":
                                str = getString(R.string.G_6);
                                break;
                            case "H_4":
                                str = getString(R.string.H_4);
                                break;
                            case "H_5":
                                str = getString(R.string.H_5);
                                break;
                            case "H_6":
                                str = getString(R.string.H_6);
                                break;
                            case "I_4":
                                str = getString(R.string.I_4);
                                break;
                            case "I_5":
                                str = getString(R.string.I_5);
                                break;
                            case "I_6":
                                str = getString(R.string.I_6);
                                break;
                            case "J_4":
                                str = getString(R.string.J_4);
                                break;
                            case "J_5":
                                str = getString(R.string.J_5);
                                break;
                            case "J_6":
                                str = getString(R.string.J_6);
                                break;
                            case "K_4":
                                str = getString(R.string.K_4);
                                break;
                            case "K_5":
                                str = getString(R.string.K_5);
                                break;
                            case "K_6":
                                str = getString(R.string.K_6);
                                break;
                            case "L_4":
                                str = getString(R.string.L_4);
                                break;
                            case "L_5":
                                str = getString(R.string.L_5);
                                break;
                            case "L_6":
                                str = getString(R.string.L_6);
                                break;
                            case "M_4":
                                str = getString(R.string.M_4);
                                break;
                            case "M_5":
                                str = getString(R.string.M_5);
                                break;
                            case "M_6":
                                str = getString(R.string.M_6);
                                break;
                            case "N_4":
                                str = getString(R.string.N_4);
                                break;
                            case "N_5":
                                str = getString(R.string.N_5);
                                break;
                            case "N_6":
                                str = getString(R.string.N_6);
                                break;
                            case "O_4":
                                str = getString(R.string.O_4);
                                break;
                            case "O_5":
                                str = getString(R.string.O_5);
                                break;
                            case "O_6":
                                str = getString(R.string.O_6);
                                break;
                            case "P_4":
                                str = getString(R.string.P_4);
                                break;
                            case "P_5":
                                str = getString(R.string.P_5);
                                break;
                            case "P_6":
                                str = getString(R.string.P_6);
                                break;
                            case "Q_4":
                                str = getString(R.string.Q_4);
                                break;
                            case "Q_5":
                                str = getString(R.string.Q_5);
                                break;
                            case "Q_6":
                                str = getString(R.string.Q_6);
                                break;
                            case "R_4":
                                str = getString(R.string.R_4);
                                break;
                            case "R_5":
                                str = getString(R.string.R_5);
                                break;
                            case "R_6":
                                str = getString(R.string.R_6);
                                break;
                            case "S_4":
                                str = getString(R.string.S_4);
                                break;
                            case "S_5":
                                str = getString(R.string.S_5);
                                break;
                            case "S_6":
                                str = getString(R.string.S_6);
                                break;
                            case "T_4":
                                str = getString(R.string.T_4);
                                break;
                            case "T_5":
                                str = getString(R.string.T_5);
                                break;
                            case "T_6":
                                str = getString(R.string.T_6);
                                break;
                            case "U_4":
                                str = getString(R.string.U_4);
                                break;
                            case "U_5":
                                str = getString(R.string.U_5);
                                break;
                            case "U_6":
                                str = getString(R.string.U_6);
                                break;
                            case "V_4":
                                str = getString(R.string.V_4);
                                break;
                            case "V_5":
                                str = getString(R.string.V_5);
                                break;
                            case "V_6":
                                str = getString(R.string.V_6);
                                break;
                            case "W_4":
                                str = getString(R.string.W_4);
                                break;
                            case "W_5":
                                str = getString(R.string.W_5);
                                break;
                            case "W_6":
                                str = getString(R.string.W_6);
                                break;
                            case "X_4":
                                str = getString(R.string.X_4);
                                break;
                            case "X_5":
                                str = getString(R.string.X_5);
                                break;
                            case "X_6":
                                str = getString(R.string.X_6);
                                break;
                            case "Y_4":
                                str = getString(R.string.Y_4);
                                break;
                            case "Y_5":
                                str = getString(R.string.Y_5);
                                break;
                            case "Y_6":
                                str = getString(R.string.Y_6);
                                break;
                            case "Z_4":
                                str = getString(R.string.Z_4);
                                break;
                            case "Z_5":
                                str = getString(R.string.Z_5);
                                break;
                            case "Z_6":
                                str = getString(R.string.Z_6);
                                break;
                            default:
                                str = "";
                        }

                        if (!str.contains(entered_word)) {
                            word_field.setText(entered_word.toString().trim());
                            word_field.selectAll();
                            Toast toast = Toast.makeText(getBaseContext(), "Error: Undefined word '" + entered_word + "'", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 350);
                            toast.show();
                            return true;
                        } else if(word_bank.getText().toString().contains(entered_word)){
                            word_field.setText(entered_word.toString().trim());
                            word_field.selectAll();
                            Toast toast = Toast.makeText(getBaseContext(), "Error: Repeated word '" + entered_word + "'", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 350);
                            toast.show();
                            return true;
                        }else{
                            if (++listCount[0] < 10) {
                                word_bank.append(listCount[0] + ".   " + entered_word + "\n");
                                return true;
                            } else {
                                word_bank.append(listCount[0] + ". " + entered_word + "\n");
                                return true;
                            }
                        }
                    } else if (entered_word.length() != randomN && !entered_word.startsWith(String.valueOf(randomL))) {
                        word_field.setText(entered_word.toString().trim());
                        word_field.selectAll();
                        Toast toast = Toast.makeText(getBaseContext(), "Error: Must be " + randomN + " characters long\n and begin with '" + randomL + "'", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 300);
                        toast.show();
                        return true;
                    } else if (entered_word.length() != randomN) {
                        word_field.setText(entered_word.toString().trim());
                        word_field.selectAll();
                        Toast toast = Toast.makeText(getBaseContext(), "Error: Must be " + randomN + " characters long", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 350);
                        toast.show();
                        return true;
                    } else {
                        word_field.setText(entered_word.toString().trim());
                        word_field.selectAll();
                        Toast toast = Toast.makeText(getBaseContext(), "Error: Must begin with the letter '" + randomL + "'", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 350);
                        toast.show();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.how_to_play){
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("How To Play:");
            alert.setMessage("1. Click the 'Start Game!' button.\n" +
                    "2. You have 60 seconds to enter as many words as possible.\n" +
                    "3. To record a word, type it and press the enter key.\n" +
                    "4. Words must comply with the length and letter restrictions given.");
            alert.setButton("BACK TO GAME", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
            return true;
        }

        if(id == R.id.new_game){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Begin New Game:")
                    .setMessage("Are you sure you want to restart?")
                    .setPositiveButton("YES, NEW GAME", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            startActivity(getIntent());
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int randomNumber(int min, int max){
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }

    public char randomLetter(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char letter = alphabet.charAt((int) Math.floor(Math.random() * alphabet.length()));
        return letter;
    }
}
