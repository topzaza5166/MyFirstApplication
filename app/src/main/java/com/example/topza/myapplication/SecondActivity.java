package com.example.topza.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends Activity {
    TextView tvResult;
    int result;
    Button OKButton;
    EditText EditReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent intent = getIntent();

        CoordinateParcelable c3 = intent.getParcelableExtra("cParcelable");

        result = c3.x + c3.y + c3.z ;

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText("Result = " + result);

        EditReturn = (EditText) findViewById(R.id.editReturn);

        OKButton = (Button) findViewById(R.id.OKButton);
        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",EditReturn.getText().toString());
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
