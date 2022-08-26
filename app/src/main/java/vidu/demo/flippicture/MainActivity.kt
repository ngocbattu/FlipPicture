package vidu.demo.flippicture

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vidu.demo.flippicture.Model.CorrectPhoto
import vidu.demo.flippicture.Model.PhotoAnswer

class MainActivity : AppCompatActivity() {
    lateinit var imagePhotoDapAn:ImageView
    lateinit var imagePhotoA:ImageView
    lateinit var imagePhotoB:ImageView
    lateinit var imagePhotoC:ImageView
    lateinit var imagePhotoD:ImageView
    lateinit var txtThoiGian : TextView
    val listCorectPhoto : MutableList<CorrectPhoto> = mutableListOf()
    val listPhotoAnsw : MutableList<PhotoAnswer> = mutableListOf()
    val listPhotoAnsw1 : MutableList<PhotoAnswer> = mutableListOf()
    val listPhotoAnsw2 : MutableList<PhotoAnswer> = mutableListOf()
    val listPhotoAnsw3 : MutableList<PhotoAnswer> = mutableListOf()
    var count : Int = 0
    var correct : CorrectPhoto = CorrectPhoto()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        insertPhotosAnswen()
        inserCorrectPhoto()
        setCauHoi(listCorectPhoto.get(count))
        check()
        time60sGameOver()
    }

    private fun setCauHoi(correctPhoto: CorrectPhoto) {
        correct = correctPhoto
        for (i in listCorectPhoto.indices){
            if(listCorectPhoto.get(i).idPhoto == correctPhoto.idPhoto){
                Glide.with(this).load(listCorectPhoto.get(i).imagePhotoNeedToFind).into(imagePhotoDapAn)
                Glide.with(this).load(listCorectPhoto.get(i).list.get(0).imageAnsewn).into(imagePhotoA)
                Glide.with(this).load(listCorectPhoto.get(i).list.get(1).imageAnsewn).into(imagePhotoB)
                Glide.with(this).load(listCorectPhoto.get(i).list.get(2).imageAnsewn).into(imagePhotoC)
                Glide.with(this).load(listCorectPhoto.get(i).list.get(3).imageAnsewn).into(imagePhotoD)
            }
        }
    }

    fun init(){
        imagePhotoDapAn = findViewById(R.id.imageCanTim)
        imagePhotoA = findViewById(R.id.imageAnh1)
        imagePhotoB = findViewById(R.id.imageAnh2)
        imagePhotoC = findViewById(R.id.imageAnh3)
        imagePhotoD = findViewById(R.id.imageAnh4)
        txtThoiGian = findViewById(R.id.txtThoiGian)
    }
    fun insertPhotosAnswen(){
        listPhotoAnsw.add(PhotoAnswer(R.drawable.gau6,true))
        listPhotoAnsw.add(PhotoAnswer(R.drawable.gau9,false))
        listPhotoAnsw.add(PhotoAnswer(R.drawable.gau7,false))
        listPhotoAnsw.add(PhotoAnswer(R.drawable.gau8,false))

        listPhotoAnsw1.add(PhotoAnswer(R.drawable.gau6,false))
        listPhotoAnsw1.add(PhotoAnswer(R.drawable.gau9,true))
        listPhotoAnsw1.add(PhotoAnswer(R.drawable.gau7,false))
        listPhotoAnsw1.add(PhotoAnswer(R.drawable.gau8,false))

        listPhotoAnsw2.add(PhotoAnswer(R.drawable.gau6,false))
        listPhotoAnsw2.add(PhotoAnswer(R.drawable.gau9,false))
        listPhotoAnsw2.add(PhotoAnswer(R.drawable.gau7,true))
        listPhotoAnsw2.add(PhotoAnswer(R.drawable.gau8,false))

        listPhotoAnsw3.add(PhotoAnswer(R.drawable.gau6,false))
        listPhotoAnsw3.add(PhotoAnswer(R.drawable.gau9,false))
        listPhotoAnsw3.add(PhotoAnswer(R.drawable.gau7,false))
        listPhotoAnsw3.add(PhotoAnswer(R.drawable.gau8,true))
    }
    fun inserCorrectPhoto(){
        listCorectPhoto.add(CorrectPhoto(0,R.drawable.gau6,listPhotoAnsw))
        listCorectPhoto.add(CorrectPhoto(1,R.drawable.gau9,listPhotoAnsw1))
        listCorectPhoto.add(CorrectPhoto(2,R.drawable.gau7,listPhotoAnsw2))
        listCorectPhoto.add(CorrectPhoto(3,R.drawable.gau8,listPhotoAnsw3))
    }
    fun check(){
        imagePhotoA.setOnClickListener(View.OnClickListener {
            checkAnswen(correct,correct.list.get(0))
        })
        imagePhotoB.setOnClickListener(View.OnClickListener {
            checkAnswen(correct,correct.list.get(1))
        })
        imagePhotoC.setOnClickListener(View.OnClickListener {
            checkAnswen(correct,correct.list.get(2))
        })
        imagePhotoD.setOnClickListener(View.OnClickListener {
            checkAnswen(correct,correct.list.get(3))
        })
    }

    fun checkAnswen(correctPhoto: CorrectPhoto , photo: PhotoAnswer){
        if(photo.check){
            Toast.makeText(this, "Bạn thât là giỏi >>" , Toast.LENGTH_SHORT).show()
            setNext()
        }else {
            Toast.makeText(this, "Sai rùi lew lew out trình -.- <<", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setNext() {
        if(count == listCorectPhoto.size - 1 ){
            Toast.makeText(this, "Chúc mừng bạn đã phá đảo game ", Toast.LENGTH_SHORT).show()
        }else {
            count++
            setCauHoi(listCorectPhoto.get(count))
        }
    }
    fun time60sGameOver(){
        object  : CountDownTimer(60000,1000){
            override fun onTick(p0: Long) {
               txtThoiGian.text = (p0 / 1000).toString()
            }

            override fun onFinish() {
                val dialog : Dialog = Dialog(this@MainActivity)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setContentView(R.layout.dia_log_lose)
                val btnTiepTuc : Button = dialog.findViewById(R.id.btnChoiLai)
                btnTiepTuc.setOnClickListener(View.OnClickListener {
                    dialog.dismiss()
                    time60sGameOver()
                    setCauHoi(listCorectPhoto.get(count))
                })
                dialog.show()
            }

        }.start()
    }

}