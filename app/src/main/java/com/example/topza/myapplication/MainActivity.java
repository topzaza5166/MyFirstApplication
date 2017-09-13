package com.example.topza.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editNum1;
    EditText editNUm2;
    TextView sumResult;
    Button calculateButton;
    CustomViewGroup viewGroup1;
    CustomViewGroup viewGroup2;
    CoordinateParcelable c3;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getBoolean(R.bool.portrait_only)) {
            //Fix screen orientation to Portrait
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(R.layout.activity_main);

        editNum1 = (EditText) findViewById(R.id.EditNum1);
        editNUm2 = (EditText) findViewById(R.id.EditNum2);
        sumResult = (TextView) findViewById(R.id.SumResult);

        calculateButton = (Button) findViewById(R.id.CalculateButton);
        calculateButton.setOnClickListener(Summation);

        viewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);

        viewGroup1.setButtonText("Hello");
        viewGroup2.setButtonText("World");

    }

    View.OnClickListener Summation = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);

            int val1 = 0, val2 = 0, sum;
            try {
                val1 = Integer.parseInt(editNum1.getText().toString());
            } catch (NumberFormatException e) {

            }
            try {
                val2 = Integer.parseInt(editNUm2.getText().toString());
            } catch (NumberFormatException e) {

            }

            sum = val1 + val2;
            sumResult.setText(String.valueOf(sum));

            c3 = new CoordinateParcelable();
            c3.x = 5;
            c3.y = 10;
            c3.z = 20;
            intent.putExtra("cParcelable",c3);

            startActivityForResult(intent,12345);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Check if it is a result from SecondActivity
        if(requestCode == 12345){
            if(resultCode == RESULT_OK){
                //Get data from data's extra
                String s = data.getStringExtra("result");
                Toast.makeText(MainActivity.this, s , Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(MainActivity.this, "ERROR RESULT CANCELED", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(MainActivity.this, "ERROR REQUEST CODE ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Click Setting", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save thing(s) here
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Restore thing(s) here
    }
}
