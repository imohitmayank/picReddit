/**@Mohit
 * 
 */
package mohits.app.picreddit;

import java.util.ArrayList;
import java.util.List;

import mohits.app.picreddit.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Mohit
 *
 * 
 */
public class itemlist extends Activity {
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemlist);
		
		MyAdapter ma = new MyAdapter();
		ListView lv = (ListView)findViewById(R.id.listView);
		lv.setAdapter(ma);
		
	}
	
	public class RowItems {
        String userdata;
        String timedata;
    }

	public class MyAdapter extends BaseAdapter {
		
		
	        List<RowItems> rowItemsList = getDataForListView();
	        @Override
	        public int getCount() {
	            // TODO Auto-generated method stub
	            return rowItemsList.size();
	        }

	        @Override
	        public RowItems getItem(int arg0) {
	            // TODO Auto-generated method stub
	            return rowItemsList.get(arg0);
	        }

	        @Override
	        public long getItemId(int arg0) {
	            // TODO Auto-generated method stub
	            return arg0;
	        }

	        @Override
	        public View getView(int arg0, View arg1, ViewGroup arg2) {

	            if(arg1==null)
	            {
	                LayoutInflater inflater = (LayoutInflater) itemlist.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                arg1 = inflater.inflate(R.layout.items, arg2,false);
	            }

	            TextView user = (TextView)arg1.findViewById(R.id.user_tv_item);
	            TextView time = (TextView)arg1.findViewById(R.id.time_tv_item);

	            RowItems chapter = rowItemsList.get(arg0);

	            user.setText(chapter.userdata);
	            time.setText(chapter.timedata);

	            return arg1;
	        }
	        
	        public List<RowItems> getDataForListView()
	        {
	            List<RowItems> rowItemList = new ArrayList<RowItems>();

	            for(int i=0;i<25;i++)
	            {

	            	RowItems chapter = new RowItems();
	                chapter.userdata = "user name: "+i;
	                chapter.timedata = "time: "+i;
	                rowItemList.add(chapter);
	            }

	            return rowItemList;

	        }

	    }

}

