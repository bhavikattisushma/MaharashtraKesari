package adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sushma.mahakesari.maharashtrakesari.R;

import java.util.ArrayList;
import java.util.List;

import custome.view.ZoomableImageView;
import data.CalendarPage;

public class CalendarAdapter extends BaseAdapter {

  private LayoutInflater inflater;

  private int repeatCount = 1;

  private List<CalendarPage.Data> travelData;

  private Activity activity;

  public CalendarAdapter(Context context) {
    activity=(Activity)context;
    inflater = LayoutInflater.from(context);
    travelData = new ArrayList<CalendarPage.Data>(CalendarPage.IMG_DESCRIPTIONS);
  }

  @Override
  public int getCount() {
    return travelData.size() * repeatCount;
  }

  public int getRepeatCount() {
    return repeatCount;
  }

  public void setRepeatCount(int repeatCount) {
    this.repeatCount = repeatCount;
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View layout = convertView;
    if (convertView == null) {
      layout = inflater.inflate(R.layout.activity_main, null);
//      system.print("created new view from adapter: %d", position);
    }

    final CalendarPage.Data data = travelData.get(position % travelData.size());


    loadCalendar();


    return layout;
  }

  private void loadCalendar()
  {
    String url = "drawable://" + R.drawable.january;

    ImageLoader imageLoader = ImageLoader.getInstance();
    int fallback=R.drawable.android_logo;
    DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
            .cacheOnDisc(true).resetViewBeforeLoading(true)
            .showImageForEmptyUri(fallback)
            .showImageOnFail(fallback)
            .showImageOnLoading(fallback).build();

    //initialize image view
    final ZoomableImageView imageView = (ZoomableImageView) activity.findViewById(R.id.calendar_img);

    //download and display image from url

    imageLoader.loadImage(url, new SimpleImageLoadingListener()
    {
      @Override
      public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)
      {
        imageView.setImageBitmap(loadedImage);
      }
    });
  }

  public void removeData(int index) {
    if (travelData.size() > 1) {
      travelData.remove(index);
    }
  }
}
