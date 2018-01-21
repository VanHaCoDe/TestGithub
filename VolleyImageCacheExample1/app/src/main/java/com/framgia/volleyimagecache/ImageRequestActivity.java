package com.framgia.volleyimagecache;

import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.framgia.volleyimagecache.utils.Const;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Hoalq
 * @date Dec 26, 2014
 */
public class ImageRequestActivity extends Activity{
	
	private static final String TAG = ImageRequestActivity.class.getSimpleName();
	private Button btnImageRequest;
	private NetworkImageView imgNetworkView;
	private ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_request);
		
		btnImageRequest = (Button)findViewById(R.id.button_Image_Request);
		imgNetworkView = (NetworkImageView)findViewById(R.id.imgNetwork);
		imageView = (ImageView)findViewById(R.id.imgView);
		
		btnImageRequest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				makeImageRequest();
			}
		});
	}
	
	private void makeImageRequest(){
		ImageLoader imageLoader = ApplicationController.getInstance().getImageLoader();
		
		// If you are using NetworkImageView
		imgNetworkView.setImageUrl(Const.URL_IMAGE_REQUEST, imageLoader);
		
		// If you are using normal ImageView
		imageLoader.get(Const.URL_IMAGE_REQUEST, new ImageListener() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				VolleyLog.d(TAG, "Error:"+ error.getMessage());
				
			}
			
			@Override
			public void onResponse(ImageContainer paramImageContainer, boolean paramBoolean) {
				// Load image into ImageView
				imageView.setImageBitmap(paramImageContainer.getBitmap());
			}
		});
		
		/*
		// Loading image with placeholder and error image
		imageLoader.get(Const.URL_IMAGE_REQUEST, ImageLoader.getImageListener(imageView, R.drawable.ico_loading, R.drawable.ico_error));
		Cache cache = ApplicationController.getInstance().getRequestQueue().getCache();
		Entry entry = cache.get(Const.URL_IMAGE_REQUEST);
		if (entry != null) {
			try {
				String data = new String(entry.data, "UTF-8");
				//handle data, like converting it to xml, json, bitmap etc...
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// cached response doesn't exists. Make a network call here
		}
		
		*/
	}

}
