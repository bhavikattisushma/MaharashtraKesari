package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sushma.mahakesari.maharashtrakesari.R;

import java.util.ArrayList;

import custome.view.ZoomableImageView;

/**
 * Created by sushma on 4/20/16.
 */
public class CalendarPagerAdapter extends PagerAdapter {

    private ImageLoader imageLoader;
    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<Integer> pages = new ArrayList<>();

    public CalendarPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);

        imageLoader = ImageLoader.getInstance();
        int fallback=R.drawable.android_logo;
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(fallback)
                .showImageOnFail(fallback)
                .showImageOnLoading(fallback).build();
    }

    public void setCalendarData(ArrayList<Integer> calendarPages)
    {
        pages=calendarPages;
    }

    // Returns the number of pages to be displayed in the ViewPager.
    @Override
    public int getCount() {
        return pages.size();
    }

    // Returns true if a particular object (page) is from a particular page
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // This method should create the page for the given position passed to it as an argument.
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Inflate the layout for the page
        View itemView = mLayoutInflater.inflate(R.layout.calendar_item, container, false);
        // Find and populate data into the page (i.e set the image)
        final ZoomableImageView imageView = (ZoomableImageView) itemView.findViewById(R.id.calendar_img);
        String url = "drawable://" + R.drawable.january;
        imageLoader.loadImage(url, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                imageView.setImageBitmap(loadedImage);
            }
        });


        // Add the page to the container
        container.addView(itemView);
        // Return the page
        return itemView;
    }

    // Removes the page from the container for the given position.
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
