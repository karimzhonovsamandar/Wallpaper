package com.sammy.wallpaper

import android.app.AlertDialog
import android.app.WallpaperManager
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sammy.wallpaper.databinding.ActivityGetImageBinding

class GetImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val image = intent.getIntExtra("selectedImage", 0)
        binding.imageBuildings.setImageResource(image)
        binding.setupWallpaper.setOnClickListener {

            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Установить обои")
            alertDialogBuilder.setMessage("Вы уверены, что хотите установить это изображение как обои?")
            alertDialogBuilder.setPositiveButton("Да") { dialogInterface: DialogInterface, _: Int ->
                setWallpaper(image)
                dialogInterface.dismiss()
                Toast.makeText(this, "Обои установлены", Toast.LENGTH_SHORT).show()
                finish()
            }
            alertDialogBuilder.setNegativeButton("Отмена") { dialogInterface: DialogInterface, _: Int ->
                dialogInterface.dismiss()
            }
            alertDialogBuilder.create().show()

        }


    }
    private fun setWallpaper(imageResId: Int) {
        try {
            // Получение Bitmap из ресурса изображения
            val bitmap: Bitmap = BitmapFactory.decodeResource(resources, imageResId)

            // Получение менеджера обоев
            val wallpaperManager = WallpaperManager.getInstance(applicationContext)

            // Установка обоев
            wallpaperManager.setBitmap(bitmap)

            // Опционально: установка обоев с определенной шириной и высотой
            // wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}