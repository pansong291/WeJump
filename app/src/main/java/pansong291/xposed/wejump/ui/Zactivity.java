package pansong291.xposed.wejump.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Zactivity extends Activity
{

 @Override
 protected void onResume()
 {
  super.onResume();
  
 }
 
 @Override
 protected void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
 }

 @Override
 protected void onDestroy()
 {
  super.onDestroy();
 }
 
 public void toast(String s)
 {
  toast(s,0);
 }
 
 public void toast(String s,int i)
 {
  Toast.makeText(this,s,i).show();
 }
 
}
