package pansong291.xposed.wejump;

import de.robv.android.xposed.XposedBridge;

public class Log
{
 public static int a=5;

 public static void d(String str,String str2)
 {
  if(a<=3)
  {
   XposedBridge.log(str+" D: "+str2);
  }
 }

 public static void e(String str,String str2)
 {
  if(a<=6)
  {
   XposedBridge.log(str+" E: "+str2);
  }
 }
}
