package pansong291.xposed.wejump;

import de.robv.android.xposed.XSharedPreferences;

public class MySharedPreference
{
 private static XSharedPreferences a=null;

 public static boolean opBoolean()
 {
  return getXSP().getBoolean("jump_flag",true);
 }

 private static XSharedPreferences getXSP()
 {
  if(a==null)
  {
   a=new XSharedPreferences(MySharedPreference.class.getPackage().getName());
   a.makeWorldReadable();
  }else
  {
   a.reload();
  }
  return a;
 }
}
