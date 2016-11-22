package tn.hajer.connexionwifi;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDetails;
    TextView txtBssid, txtEnabled, txtSsid,  txtMac, txtSpeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDetails = (Button) findViewById(R.id.btnWifi);
        txtEnabled = (TextView) findViewById(R.id.txtenabled);
        txtBssid = (TextView) findViewById(R.id.txtBSSID);
        txtSsid = (TextView) findViewById(R.id.txtSsid);
        txtMac = (TextView) findViewById(R.id.txtMac);
        txtSpeed = (TextView) findViewById(R.id.txtVitesse);

        txtEnabled.setText("No");

        txtSpeed.setText("");
        txtSsid.setText("");
        txtBssid.setText("");
        txtMac.setText("");

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi =  (WifiManager) getSystemService(Context.WIFI_SERVICE);

                if (wifi.isWifiEnabled()) {
                    txtEnabled.setText("Yes");
                    WifiInfo info = wifi.getConnectionInfo();
                    if (info.getBSSID() != null) {
                        txtSpeed.setText(String.valueOf(info.getLinkSpeed()+" " + WifiInfo.LINK_SPEED_UNITS));
                        txtSsid.setText(info.getSSID());
                        txtBssid.setText(info.getBSSID());
                        txtMac.setText(info.getMacAddress());

                    }
                }
                else{
                    txtEnabled.setText("No");

                    txtSpeed.setText("");
                    txtSsid.setText("");
                    txtBssid.setText("");
                    txtMac.setText("");
                }
            }
        });




    }
}
