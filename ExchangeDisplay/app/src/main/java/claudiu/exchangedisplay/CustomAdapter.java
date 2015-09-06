package claudiu.exchangedisplay;

/**
 * Created by Claudiu on 9/6/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Response.RatesEntity> mExchangeItem;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext, List<Response.RatesEntity> mExchangeItem) {
        this.mContext = mContext;
        this.mExchangeItem = mExchangeItem;
    }

    @Override
    public int getCount() {
        return mExchangeItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mExchangeItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.each_list_item,parent,false);

        Response.RatesEntity item = (Response.RatesEntity) getItem(position);

        //ImageView thumbnail = (ImageView) rowView.findViewById(R.id.thumbnail);
        TextView currency = (TextView) rowView.findViewById(R.id.id_currency);
        TextView value = (TextView) rowView.findViewById(R.id.value );
        TextView id = (TextView) rowView.findViewById(R.id.id_currency );

        //String imageURL = item.getPosters().getOriginal();
       // Picasso.with(mContext).load(imageURL).into(thumbnail);
        id.setText(getItem(position).toString());
        currency.setText(item.getBBD());
        value.setText(item.getVND());


        return rowView;
    }
}

