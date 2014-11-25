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
import android.widget.GridView;
import android.widget.TextView;

/**
 * @author Mohit
 *
 * 
 */
public class itemgrid extends Activity {
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridmain);
		
		MyAdapter ma = new MyAdapter();
		GridView lv = (GridView)findViewById(R.id.gridview);
		lv.setAdapter(ma);
		
	}
	
	public class RowItems {
        String userdata;
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
	                LayoutInflater inflater = (LayoutInflater) itemgrid.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                arg1 = inflater.inflate(R.layout.gridmainitems, arg2,false);
	            }

	            TextView user = (TextView)arg1.findViewById(R.id.gridmain_tv);

	            RowItems chapter = rowItemsList.get(arg0);

	            user.setText(chapter.userdata);

	            return arg1;
	        }
	        
	        public List<RowItems> getDataForListView()
	        {
	            List<RowItems> rowItemList = new ArrayList<RowItems>();

	            for(int i=0;i<25;i++)
	            {

	            	RowItems chapter = new RowItems();
	                chapter.userdata = "user name: "+i;
	                rowItemList.add(chapter);
	            }

	            return rowItemList;

	        }

	    }

}

