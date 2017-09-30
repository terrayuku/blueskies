package skies.blue.liberty.com.blueskies.analytics;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by simthembile on 2017/09/30.
 */

public class LineAnalytics extends AppCompatActivity {

    Context context;

    ArrayList<Entry> entries = new ArrayList<>();
    ArrayList<String> labels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        entries.add(new Entry(10,0));
        entries.add(new Entry(50,0));
        entries.add(new Entry(40,0));

        LineDataSet lineDataSet = new LineDataSet(entries, "Set 1");
        lineDataSet.setCircleColor(ColorTemplate.getHoloBlue());

        lineDataSet.setLineWidth(2f);
        lineDataSet.setFillAlpha(65);
        lineDataSet.setFillColor(ColorTemplate.getHoloBlue());
        lineDataSet.setHighLightColor(Color.rgb(244, 117, 117));

        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet); // add the datasets



    }
}
