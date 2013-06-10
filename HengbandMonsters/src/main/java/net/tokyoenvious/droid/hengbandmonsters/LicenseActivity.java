package net.tokyoenvious.droid.hengbandmonsters;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.*;

public class LicenseActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

        try {
            InputStream is = getResources().openRawResource(R.raw.jlicense);
            BufferedReader bufferedReader = null;
            bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            TextView textViewLicense = (TextView)findViewById(R.id.textViewLicense);
            textViewLicense.setText(sb.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}