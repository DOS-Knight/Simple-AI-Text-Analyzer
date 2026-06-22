package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.github.mikephil.charting.components.Legend;

public class MainActivity extends AppCompatActivity {

    EditText edtInput;
    PieChart pieChart;

    TextView txtEmotion, txtTopic, txtKeywords, txtSummary;
    ProgressBar progressBar;

    DatabaseHelper dbHelper;

    boolean isDarkMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView builder = findViewById(R.id.builder);

        builder.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    android.net.Uri.parse("https://github.com/DOS-Knight/Simple-AI-Text-Analyzer")
            );
            startActivity(intent);
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        setSupportActionBar(toolbar);
        edtInput = findViewById(R.id.edtInput);

        pieChart = findViewById(R.id.pieChart);

        txtEmotion = findViewById(R.id.txtEmotion);
        txtTopic = findViewById(R.id.txtTopic);
        txtKeywords = findViewById(R.id.txtKeywords);
        txtSummary = findViewById(R.id.txtSummary);

        progressBar = findViewById(R.id.progressBar);

        dbHelper = new DatabaseHelper(this);
        setupPieChart();
        findViewById(R.id.btnAnalyze).setOnClickListener(v -> analyzeText());

    }

    //  تحلیل
    private void analyzeText() {

        String text = edtInput.getText().toString().trim();

        if (text.isEmpty()) {
            Toast.makeText(this, " لطفا متنی وارد کنید. ", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> {

            String emotion = SentimentAnalyzer.analyze(text);
            String topic = TopicAnalyzer.analyze(text);
            String keywords = KeywordExtractor.extract(text);
            String summary = SummaryGenerator.summarize(text);

            txtEmotion.setText(" احساس غالب : " + emotion);
            txtTopic.setText(" موضوعات : " + topic);
            txtKeywords.setText(" کلمات کلیدی متن : " + keywords);
            txtSummary.setText(" خلاصه متن : " + summary);

            dbHelper.insertAnalysis(text, emotion, topic, keywords, summary);

            showPieChart(text);

            progressBar.setVisibility(View.GONE);

        }, 800);
    }

    //  PieChart تنظیم اولیه

    private void setupPieChart() {

        pieChart.getDescription().setEnabled(false);
        pieChart.setUsePercentValues(true);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setCenterText(" احساسات ");
        pieChart.setCenterTextSize(16f);

        pieChart.getLegend().setEnabled(false);


    }

    //  PieChart
    private void showPieChart(String text) {

        HashMap<String, Float> data = SentimentAnalyzer.analyzePercent(text);

        ArrayList<PieEntry> entries = new ArrayList<>();

        for (String key : data.keySet()) {
            float value = data.get(key);
            if (value > 0) {
                entries.add(new PieEntry(value, key));
            }
        }

        PieDataSet dataSet = new PieDataSet(entries, ""); 

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#4CAF50")); // خوشحال
        colors.add(Color.parseColor("#2196F3")); // غمگین
        colors.add(Color.parseColor("#F44336")); // عصبانی
        colors.add(Color.parseColor("#FF9800")); // مضطرب

        dataSet.setColors(colors);
        dataSet.setValueTextSize(13f);
        dataSet.setValueTextColor(Color.BLACK);

        PieData pieData = new PieData(dataSet);

        pieChart.setData(pieData);
        pieChart.animateY(900);
        pieChart.invalidate();
    }

    //  منو بالا
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {int id = item.getItemId();

        if (id == R.id.menu_history) {
            startActivity(new Intent(this, HistoryActivity.class));
            return true;
        }

        if (id == R.id.menu_theme) {
            toggleTheme();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //  شب/روز
    private void toggleTheme() {

        int mode = AppCompatDelegate.getDefaultNightMode();

        if (mode == AppCompatDelegate.MODE_NIGHT_YES) {

            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
            );

        } else {

            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
            );
        }
    }

}

