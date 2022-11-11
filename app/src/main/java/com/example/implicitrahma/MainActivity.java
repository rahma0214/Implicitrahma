package com.example.implicitrahma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editUrl;
    private EditText editLocation;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrl = findViewById(R.id.editUrl);
        editLocation = findViewById(R.id.editLocation);
        editText = findViewById(R.id.editText);

        Button button=(Button) findViewById(R.id.btn4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);

                intent.setData(Uri.parse("https://www.smkn5solo.sch.id/"));
                startActivity(intent);
            }
        });
    }

    public void openWeb(View view) {
        String url=editUrl.getText().toString();
        Uri webpage= Uri.parse(url);
        Intent intent= new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void openLocation(View view) {
        String lokasi = editLocation.getText().toString();
        Uri address = Uri.parse("geo:0,0?q="+lokasi);
        Intent intent = new Intent(Intent.ACTION_VIEW,address);
        startActivity(intent);
    }

    public void ShareText(View view) {
        String share=editText.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle("Share text width :")
                .setText(share)
                .setType("text/plain")
                .startChooser();
    }

}