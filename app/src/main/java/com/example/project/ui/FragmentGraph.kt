package com.example.project.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project.R
import com.example.project.databinding.FragmentGraphBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*


class FragmentGraph : Fragment() {
    private var binding: FragmentGraphBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGraphBinding.inflate(inflater, container, false)
        setupBarChart()
        setUpPieChart()
        return binding!!.root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setupBarChart() {
        val barEntry: List<BarEntry> = data()
        val barDataset = BarDataSet(barEntry, "task done")
        val barData = BarData(barDataset)
        barDataset.setDrawValues(false)
        binding!!.taskDone.data = barData
        barDataset.setColors(R.color.color_green)
        barDataset.valueTextSize = 16f
        binding!!.taskDone.run {
            xAxis.setDrawGridLines(false);
            axisLeft.setDrawGridLines(false);
            axisRight.setDrawGridLines(false);
            setFitBars(true)
            setDrawGridBackground(false)
            description.isEnabled = false
            animateY(2000)
            val xAxis: XAxis = xAxis
            axisRight.setDrawLabels(false)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
        }
        binding!!.taskDone.invalidate()
    }

    private fun data(): List<BarEntry> {
        var list = arrayListOf<BarEntry>()
        list.add(BarEntry(2f, 10f))
        list.add(BarEntry(3f, 2f))
        list.add(BarEntry(4f, 15f))
        list.add(BarEntry(5f, 2f))
        list.add(BarEntry(6f, 8f))
        list.add(BarEntry(7f, 2f))
        list.add(BarEntry(8f, 2f))
        return list;
    }

    private fun dataPie(): List<PieEntry> {
        var list = arrayListOf<PieEntry>()
        list.add(PieEntry(2f, 10f))
        list.add(PieEntry(3f, 2f))
        list.add(PieEntry(4f, 15f))
        list.add(PieEntry(5f, 2f))
        list.add(PieEntry(6f, 8f))
        list.add(PieEntry(7f, 2f))
        list.add(PieEntry(8f, 2f))
        return list;
    }

    private fun setUpPieChart() {
        val pieEntry: List<PieEntry> = dataPie()
        val pieDataset = PieDataSet(pieEntry, "task done")
        pieDataset.valueTextSize = 16f
        pieDataset.setColors(R.color.color_green)
        //
        val colors = ArrayList<Int>()
        colors.add(resources.getColor(R.color.purple_200))
        colors.add(resources.getColor(R.color.yellow))
        colors.add(resources.getColor(R.color.red))
        pieDataset.colors = colors

        val piedata = PieData(pieDataset)
        binding!!.pieChart.run {
            data = piedata
            description.isEnabled = false
            centerText = "Task Done"
            animate()
        }
        binding!!.pieChart.invalidate()
    }
}