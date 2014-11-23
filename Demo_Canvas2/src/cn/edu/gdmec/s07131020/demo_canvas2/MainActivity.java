package cn.edu.gdmec.s07131020.demo_canvas2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
     private List<PointF> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	private class MyView extends View{
          Paint paint=new Paint();
		public MyView(Context context) {
			super(context);
			list=new ArrayList<PointF>();
			paint.setColor(Color.BLACK);
			paint.setStrokeWidth(5);
		}

		@Override
		protected void onDraw(Canvas canvas) {
		   for(PointF f : list){
			   canvas.drawPoint(f.x, f.y, paint);
		   }
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			PointF point=new PointF(event.getX(),event.getY());
			list.add(point);
			invalidate();
			return true;
		}
      
	}
}
