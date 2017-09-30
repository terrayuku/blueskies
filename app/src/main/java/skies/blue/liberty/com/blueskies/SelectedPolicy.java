package skies.blue.liberty.com.blueskies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.data.Entry;

import skies.blue.liberty.com.blueskies.analytics.UserDashboard;
import skies.blue.liberty.com.blueskies.models.Utils;

/**
 * Created by simthembile on 2017/09/30.
 */

public class SelectedPolicy extends AppCompatActivity {

    TextView policy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_policy);
        policy = (TextView)findViewById(R.id.policy);
        policy.setText(Utils.readSharedSetting(getApplicationContext(), "entry_data", "NO Entry") + " " +
                Utils.readSharedSetting(getApplicationContext(), "highlight", "NO Entry"));

    }
}
