package com.example.project.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project.R
import com.example.project.adapter.ImageViewPager
import com.example.project.databinding.FragmentGraphBinding
import com.example.project.model.Photo
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import java.util.Timer
import java.util.TimerTask


class FragmentGraph : Fragment() {
    private lateinit var binding: FragmentGraphBinding
    private lateinit var photoAdapter: ImageViewPager
    lateinit var timmer: Timer
    var listPhoto = ArrayList<Photo>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGraphBinding.inflate(inflater, container, false)
        setupBarChart()
        setUpPieChart()
        photoAdapter = ImageViewPager(getList(), requireContext())
        binding.viewpager.adapter = photoAdapter
        binding.cicleIndicator.setViewPager(binding.viewpager)
        photoAdapter.registerDataSetObserver(binding.cicleIndicator.dataSetObserver)
        return binding.root
    }

    private fun getList(): ArrayList<Photo> {
        listPhoto = ArrayList<Photo>()
        listPhoto.add(Photo("https://nguyenhuuloc99.000webhostapp.com/image/todo/to-do-list.jpeg"))
        listPhoto.add(Photo("https://nguyenhuuloc99.000webhostapp.com/image/todo/todo_list_1.png"))
        listPhoto.add(Photo("https://nguyenhuuloc99.000webhostapp.com/image/todo/to_do.png"))
        return listPhoto
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setupBarChart() {
        val barEntry: List<BarEntry> = data()
        val barDataset = BarDataSet(barEntry, "task done")
        val barData = BarData(barDataset)
        barDataset.setDrawValues(false)
        binding.taskDone.data = barData
        barDataset.setColors(R.color.color_green)
        barDataset.valueTextSize = 16f
        binding.taskDone.run {
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
        autoImageSilde()
        binding.taskDone.invalidate()
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
        return list;
    }

    private fun setUpPieChart() {
        val pieEntry: List<PieEntry> = dataPie()
        val pieDataset = PieDataSet(pieEntry, "Độ ưu tiên")
        pieDataset.valueTextSize = 16f
        pieDataset.setColors(R.color.color_green)
        //
        val colors = ArrayList<Int>()
        colors.add(resources.getColor(R.color.purple_200))
        colors.add(resources.getColor(R.color.yellow))
        colors.add(resources.getColor(R.color.red))
        pieDataset.colors = colors

        val piedata = PieData(pieDataset)
        binding.pieChart.run {
            data = piedata
            description.isEnabled = false
            centerText = "Độ ưu tiên"
            animate()
        }
        binding.pieChart.invalidate()
    }

    private fun autoImageSilde() {
        timmer = Timer()
        timmer.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post(object : Runnable {
                    override fun run() {
                        var currentItem = binding.viewpager.currentItem
                        val toltalItem = listPhoto.size - 1
                        if (currentItem < toltalItem) {
                            currentItem++
                            binding.viewpager.currentItem = currentItem
                        } else {
                            binding.viewpager.currentItem = 0
                        }
                    }

                })
            }

        }, 500, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        timmer.cancel()
        timmer == null
    }
}