package skies.blue.liberty.com.blueskies.analytics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import skies.blue.liberty.com.blueskies.MainActivity;
import skies.blue.liberty.com.blueskies.SelectedPolicy;
import skies.blue.liberty.com.blueskies.models.Utils;

/**
 * Created by simthembile on 2017/09/30.
 */

public class UserDashboard extends AppCompatActivity{

    // entries
    ArrayList<BarEntry> entries = new ArrayList<>();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        final Intent intent = new Intent(this, SelectedPolicy.class);

        entries.add(new BarEntry(1f, 0));
        entries.add(new BarEntry(2f, 1));
        entries.add(new BarEntry(8f, 2));
        entries.add(new BarEntry(18f, 3));
        entries.add(new BarEntry(16f, 4));
        entries.add(new BarEntry(12f, 5));

        BarDataSet dataset = new BarDataSet(entries, "Months");

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        final BarChart chart = new BarChart(context);
        setContentView(chart);

        LimitLine l1 = new LimitLine(5f);
        LimitLine l2 = new LimitLine(8f);

        BarData data = new BarData(labels, dataset);

        chart.setData(data);

        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Utils.saveSharedSetting(getApplicationContext(), "entry_data", entry.toString());
                startActivity(intent);
            }

            @Override
            public void onNothingSelected() {

            }
        });

        chart.setDescription("Number of Products");
    }
}
