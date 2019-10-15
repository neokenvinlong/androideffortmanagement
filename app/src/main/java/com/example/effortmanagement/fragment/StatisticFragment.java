package com.example.effortmanagement.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.EmployeeProContract;
import com.example.effortmanagement.contract.ProjectInfoContract;
import com.example.effortmanagement.contract.TaskEffortContract;
import com.example.effortmanagement.contract.TaskEmpEffortContract;
import com.example.effortmanagement.model.Task;
import com.example.effortmanagement.model.dto.EmployeeProDTO;
import com.example.effortmanagement.model.dto.ProjectByPMDTO;
import com.example.effortmanagement.model.dto.TaskEffortDTO;
import com.example.effortmanagement.model.dto.TaskEmpEffortDTO;
import com.example.effortmanagement.presenter.EmployeeProPresenter;
import com.example.effortmanagement.presenter.ProjectInfoPresenter;
import com.example.effortmanagement.presenter.TaskEffortPresenter;
import com.example.effortmanagement.presenter.TaskEmpEffortPresenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.example.effortmanagement.fragment.TaskListFragment.employeeID;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticFragment extends Fragment implements ProjectInfoContract.View, TaskEffortContract.View
        , EmployeeProContract.View, TaskEmpEffortContract.View
        , OnChartValueSelectedListener{

    private String token;
    private ProjectInfoPresenter projectInfoPresenter;
    private TaskEffortPresenter taskEffortPresenter;
    private EmployeeProPresenter employeeProPresenter;
    private TaskEmpEffortPresenter taskEmpEffortPresenter;
    private Spinner spinner;
    private Spinner spinnerP;
    private int projectID;
    private int empID;
    private ArrayAdapter<String> dataAdapter;
    private PieChart pieChart;
    private BarChart chart;

    public StatisticFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistic, container, false);
        init();

        token = this.getActivity().getIntent().getStringExtra("token");

        projectInfoPresenter.getProjectInfo(employeeID,token);

        employeeProPresenter.getEmployeeProInfo(6,token);
        System.out.println("ngoai2 la" + projectID);
        System.out.println("ngoai2 la" + empID);

        //aaaaaaa
        chart = (BarChart) view.findViewById(R.id.bar_chart);

        //pie chart 2
        pieChart = view.findViewById(R.id.piechart);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = view.findViewById(R.id.spinProject);
        spinnerP = view.findViewById(R.id.spin_emp);

    }

    private void init() {
        projectInfoPresenter = new ProjectInfoPresenter();
        projectInfoPresenter.setmView(this);

        taskEffortPresenter = new TaskEffortPresenter();
        taskEffortPresenter.setmView(this);

        employeeProPresenter = new EmployeeProPresenter();
        employeeProPresenter.setmView(this);

        taskEmpEffortPresenter = new TaskEmpEffortPresenter();
        taskEmpEffortPresenter.setmView(this);
    }
    private void doSomething(int projectID1){
        projectID = projectID1;
        System.out.println(projectID+" project id ngoai");
    }

    private void getEmpID(int empID1){
        empID = empID1;
        System.out.println(empID+"employee id ngoai");
    }
    @Override
    public void getProjectInfoSuccess(final List<ProjectByPMDTO> projectByPMDTOList) {
        List<String> projectName = new ArrayList<>();
        System.out.println("cccc"+projectByPMDTOList);
        for (ProjectByPMDTO dto: projectByPMDTOList){
            projectName.add(dto.getProjectName());
        }
        System.out.println("aaaa"+projectName);
        dataAdapter= new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_item, projectName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String proName = parent.getItemAtPosition(position).toString();
                System.out.println(proName);
                for(ProjectByPMDTO dto: projectByPMDTOList){
                    if(proName.equals(dto.getProjectName())){
                        doSomething(dto.getProjectId());
                        taskEffortPresenter.getTaskEffortChart(dto.getProjectId(),token);
                        break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void getProjectInfoFailure(String message) {

    }

    @Override
    public void getTaskEffortChartSuccess(List<TaskEffortDTO> dtoList) {
        if(dtoList.size() > 0) {
            try {
                pieChart.setUsePercentValues(true);

                pieChart.getDescription().setEnabled(false);
                pieChart.setHoleRadius(25f);
                pieChart.setTransparentCircleRadius(25f);

                List<PieEntry> value = new ArrayList<>();

                for (int i = 0; i < dtoList.size(); i++) {
                    String title = dtoList.get(i).getTitle();
                    float calendarEffort = dtoList.get(i).getCalendarEffort().floatValue();
                    value.add(new PieEntry(calendarEffort, title));
                }
                PieDataSet pieDataSet = new PieDataSet(value, "Calendar Effort");
                PieData pieData = new PieData(pieDataSet);

                pieChart.setData(pieData);
                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                pieChart.animateXY(1400,1400);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            Toast.makeText(getActivity().getBaseContext(), "There no task!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getTaskEffortChartFailure(String message) {

    }

    @Override
    public void getEmployeeProInfoSuccess(final List<EmployeeProDTO> listDTO) {
        System.out.println("list dto..."+listDTO);
        List<String> employeeName = new ArrayList<>();
        for (EmployeeProDTO dto: listDTO){
            employeeName.add(dto.getEmployeeName());
        }
        System.out.println("Employee....."+employeeName);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_item, employeeName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerP.setAdapter(dataAdapter);

        spinnerP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String empName = parent.getItemAtPosition(position).toString();
                System.out.println(empName);
                for(EmployeeProDTO dto: listDTO){
                    if(empName.equals(dto.getEmployeeName())){
                        employeeID = dto.getEmployeeID();
                        taskEmpEffortPresenter.getTaskEmpEffortChart(dto.getEmployeeID(),token);
                        getEmpID(employeeID);
                        break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void getEmployeeProInfoFailure(String message) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void getTaskEmpEffortChartSuccess(List<TaskEmpEffortDTO> listDTO) {
        chart.setOnChartValueSelectedListener(this);
        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.setHighlightFullBarEnabled(false);

        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setAxisMaximum(25f);
        chart.getAxisRight().setAxisMinimum(-25f);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setDrawZeroLine(true);
        chart.getAxisRight().setLabelCount(7, false);
        chart.getAxisRight().setTextSize(9f);

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setTextSize(9f);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(110f);
        xAxis.setCenterAxisLabels(true);
        xAxis.setLabelCount(12);
        xAxis.setGranularity(10f);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setFormToTextSpace(4f);
        l.setXEntrySpace(6f);

        // IMPORTANT: When using negative values in stacked bars, always make sure the negative values are in the array first
        List<Integer> actualList = new ArrayList<>();
        for(int i = 0; i < listDTO.size(); i++){
            actualList.add((listDTO.get(i).getEffort())-((listDTO.get(i).getEffort())*2));
        }

        List<Integer> calendarList = new ArrayList<>();
        for(int i = 0; i < listDTO.size(); i++){
            calendarList.add(listDTO.get(i).getCalendarEffort());
        }

        ArrayList<BarEntry> values = new ArrayList<>();
        int temp = 0 ;
        for(int i=0; i < listDTO.size(); i++){
            temp += 15;
            values.add(new BarEntry(temp, new float[]{actualList.get(i),calendarList.get(i)}));
        }
//        values.add(new BarEntry(5, new float[]{ -10, 10 }));
//        values.add(new BarEntry(15, new float[]{ -12, 13 }));
//        values.add(new BarEntry(25, new float[]{ -15, 15 }));
//        values.add(new BarEntry(35, new float[]{ -17, 17 }));
//        values.add(new BarEntry(45, new float[]{ -19, 20 }));
//        values.add(new BarEntry(45, new float[]{ -19, 20 }));
//        values.add(new BarEntry(55, new float[]{ -19, 19 }));
//        values.add(new BarEntry(65, new float[]{ -16, 16 }));
//        values.add(new BarEntry(75, new float[]{ -13, 14 }));
//        values.add(new BarEntry(85, new float[]{ -10, 11 }));
//        values.add(new BarEntry(95, new float[]{ -5, 6 }));
//        values.add(new BarEntry(105, new float[]{ -1, 2 }));

        BarDataSet set = new BarDataSet(values, "Actual - Calendar Effort");
        set.setDrawIcons(false);
        set.setValueTextSize(7f);
        set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set.setColors(Color.rgb(67,67,72), Color.rgb(124,181,236));
        set.setStackLabels(new String[]{
                "Actual", "Calendar"
        });

        BarData data = new BarData(set);
        data.setBarWidth(8.5f);
        chart.setData(data);
        chart.invalidate();

        int empIDTemp=0;

        if(empIDTemp == 0){
            empIDTemp = empID;
            System.out.println("Temp id la "+ empIDTemp);
        }
        if(empIDTemp != empID){
            chart.setData(data);
            chart.invalidate();
            empIDTemp = empID;
            System.out.println("Temp id sua lai la"+empIDTemp);
        }
    }

    @Override
    public void getTaskEmpEffortChartFailure(String message) {

    }
}
