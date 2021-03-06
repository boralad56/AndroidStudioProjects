package com.medha.group02_hw08;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Prathyusha on 4/17/16.
 */
public class ConversationsAdapter extends ArrayAdapter<Users> {

    List<Users> mData;
    Context mContext;
    int mResource;
    public ConversationsAdapter(Context context, int resource, List<Users> objects) {
        super(context, resource, objects);
        this.mContext = context;

        this.mData = objects ;

        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(mResource, parent, false);

        }

        Users users = mData.get(position);

        ImageView user_image = (ImageView) convertView.findViewById(R.id.imageView_picture);
        ImageView msg_image = (ImageView) convertView.findViewById(R.id.imageView_unread);
        ImageView phone_image = (ImageView) convertView.findViewById(R.id.imageView_call);
        TextView name = (TextView) convertView.findViewById(R.id.textView_listname);
        String encodedImage = users.getPicture();
        byte[] decodeString;
        Bitmap userImage = null;
        if(encodedImage != null){
        decodeString = Base64.decode(encodedImage, Base64.DEFAULT);
         userImage = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);}
        if(userImage != null)
            user_image.setImageBitmap(userImage);

        msg_image.setImageResource(R.drawable.red_bubble_clipart_1);
        phone_image.setImageResource(R.drawable.phone_icon_hi);

        name.setText(users.getFull_name());


        return convertView;
    }
}
