package pansong291.xposed.wejump.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Switch;
import pansong291.xposed.wejump.R;

public class MainActivity extends Zactivity 
{
 private Switch a;
 
 @Override
 protected void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  //requestWindowFeature(1);
  setContentView(R.layout.activity_main);
  
  a=(Switch)findViewById(R.id.activity_main_switch1);
  a.setChecked(a());

 }

 // $FF: synthetic method
 static void a(MainActivity var0,boolean var1)
 {
  var0.a(var1);
 }

 private void a(boolean var1)
 {
  Editor var2 = PreferenceManager.getDefaultSharedPreferences(this).edit();
  if(var2!=null)
  {
   var2.putBoolean("jump_flag",var1).commit();
  }

 }

 private boolean a()
 {
  SharedPreferences var2=PreferenceManager.getDefaultSharedPreferences(this);
  if(var2!=null)
  {
   return var2.getBoolean("jump_flag",true);
  }
  return false;
 }

 // Inner Class

 class MainActivity$1
 {
  // $FF: synthetic field
  final MainActivity a;

  MainActivity$1(MainActivity var1)
  {
   this.a=var1;
  }

  public void a(Switch var1,boolean var2)
  {
   MainActivity.a(this.a,var2);
  }
 }


}
