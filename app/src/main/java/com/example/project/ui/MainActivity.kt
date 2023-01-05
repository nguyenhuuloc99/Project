package com.example.project.ui

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.project.R
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.ActivityMainBinding
import com.example.project.utils.IntentUtils


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var actionDrawerToggle: ActionBarDrawerToggle;
    var CURRENT_FRAGMENT: Int = 0;
    private var fragmentHome: FragmentHome? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        CURRENT_FRAGMENT = FRAGMENT_HOME
        actionDrawerToggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar, R.string.start, R.string.close
        )
        binding.drawerLayout.addDrawerListener(actionDrawerToggle)
        actionDrawerToggle.syncState()

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    replaceFragment(FragmentHome())
                    binding.navView.menu.findItem(R.id.nav_home).isCheckable = true
                }
                R.id.nav_info -> {
                    val facebookIntent = Intent(Intent.ACTION_VIEW)
                    val facebookUrl = getFacebookPageURL(this)
                    facebookIntent.data = Uri.parse(facebookUrl)
                    startActivity(facebookIntent)
                }
                R.id.nav_policy -> {
                    IntentUtils.toActivityPolicy(this)
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true

        }
        binding.toolbar.title = "Trang Chủ"
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    openFragmentHome()
                    binding.navView.menu.findItem(R.id.nav_home).isCheckable = true
                    binding.toolbar.title = "Trang Chủ"
                }
                R.id.menu_calendar -> {
                    openFragmentCalendar()
                    binding.navView.menu.findItem(R.id.nav_home).isCheckable = false
                }
                R.id.menu_chart -> {
                    openFragmentGraph()
                    binding.navView.menu.findItem(R.id.nav_home).isCheckable = false
                    binding.toolbar.title = "Thống kê"

                }
                R.id.menu_discovery -> {
                    openFragmentDiscovery()
                    binding.navView.menu.findItem(R.id.nav_home).isCheckable = false;
                    binding.toolbar.title = "Khám Phá"
                }
            }
            true
        }
        binding.navView.menu.findItem(R.id.nav_home).isCheckable = true
        fragmentHome = FragmentHome()
        replaceFragment(fragmentHome!!)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            R.id.menu_manager -> {
                return true
            }
            R.id.menu_search -> {
                return true
            }
            R.id.menu_sort -> {
                return true
            }
        }
        return true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsMenuClosed(menu: Menu?) {
        super.onOptionsMenuClosed(menu)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun openFragmentHome() {
        if (CURRENT_FRAGMENT != FRAGMENT_HOME) {
            supportActionBar?.show()
            replaceFragment(fragmentHome!!)
            CURRENT_FRAGMENT = FRAGMENT_HOME
        }
    }

    private fun openFragmentGraph() {
        if (CURRENT_FRAGMENT != FRAGMENT_MINE) {
            replaceFragment(FragmentGraph())
            supportActionBar?.show()
            CURRENT_FRAGMENT = FRAGMENT_MINE
        }
    }

    private fun openFragmentCalendar() {
        if (CURRENT_FRAGMENT != FRAGMENT_CALENDAR) {
            replaceFragment(FragmentCalendar())
            supportActionBar?.hide()
            CURRENT_FRAGMENT = FRAGMENT_CALENDAR
        }
    }

    private fun openFragmentDiscovery() {
        if (CURRENT_FRAGMENT != FRAGMENT_CALENDAR) {
            supportActionBar?.show()
            replaceFragment(FragmentDiscovery())
            CURRENT_FRAGMENT = FRAGMENT_CALENDAR
        }
    }

    var FACEBOOK_URL = "https://www.facebook.com/nguyenhuuloc99"
    var FACEBOOK_PAGE_ID = "YourPageName"

    private fun getFacebookPageURL(context: Context): String? {
        val packageManager: PackageManager = context.packageManager
        return try {
            val versionCode = packageManager.getPackageInfo("com.facebook.orca", 0).versionCode
            if (versionCode >= 3002850) { //newer versions of fb app
                "fb://facewebmodal/f?href=$FACEBOOK_URL"
            } else { //older versions of fb app
                "fb://page/$FACEBOOK_PAGE_ID"
            }
        } catch (e: PackageManager.NameNotFoundException) {
            FACEBOOK_URL //normal web url
        }
    }

    override fun onResume() {
        super.onResume()
        var taskDao: TaskDao? = null
        val dbHelper = DbHelper.getInstance(this)
        taskDao = dbHelper?.let { TaskDao.getInstace(it) }
        taskDao.getAllTask()
        // fragmentHome?.binding?.reTask?.adapter?.notifyDataSetChanged()
    }

    companion object {
        var FRAGMENT_HOME: Int = 0;
        var FRAGMENT_CALENDAR: Int = 1;
        var FRAGMENT_MINE: Int = 2;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        for (fragment in supportFragmentManager.fragments) {
            if (fragment is FragmentHome) {
                fragment?.onActivityResult(requestCode, resultCode, data)
            }
        }

    }

}