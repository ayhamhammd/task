package com.example.testapp.UI.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.testapp.R
import com.example.testapp.UI.MainActivity
import com.example.testapp.UI.MainActivityViewModel
import com.example.testapp.utils.Resource

class ViewFragment:Fragment(R.layout.fargment_view) {

    lateinit var viewModel: MainActivityViewModel

    lateinit var coverImage:ImageView

    lateinit var image_1:ImageView
    lateinit var image_2:ImageView
    lateinit var image_3:ImageView
    lateinit var image_4:ImageView

    lateinit var infoTV:TextView

    val Tag ="Fragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infoTV= view.findViewById(R.id.textInfo)
        coverImage=view.findViewById(R.id.CoverImage)
        image_1=view.findViewById(R.id.image1)
        image_2=view.findViewById(R.id.image2)
        image_3=view.findViewById(R.id.image3)
        image_4=view.findViewById(R.id.image4)

        viewModel=(activity as MainActivity).viewModel
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            response->

            when(response){
                is Resource.Success ->{

                    response.data?.let { responseData ->

                        infoTV.text=responseData.body.toString()

                        Glide.with(this)
                            .load(responseData.cover_image)
                            .fitCenter()
                            .into(coverImage)

                        Glide.with(this)
                            .load(responseData.images[0])
                            .fitCenter()
                            .into(image_1)

                        Glide.with(this)
                            .load(responseData.images[1])
                            .fitCenter()
                            .into(image_2)

                        Glide.with(this)
                            .load(responseData.images[2])
                            .fitCenter()
                            .into(image_3)

                        Glide.with(this)
                            .load(responseData.images[3])
                            .fitCenter()
                            .into(image_4)
                    }

                    
                }
                is Resource.Error ->{
                    response.message.let {message ->
                        Log.e(Tag, "an error occurred $message")
                    }

                }
                is Resource.Loading ->{
                    //nothing
                }
            }
        })
    }


}