package pansong291.xposed.wejump;

import android.content.Context;
import android.os.Process;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class XposedInit implements IXposedHookLoadPackage
{
 private static final String TAG="XposedInit";
 private static final String WECHAT_PKG_NAME="com.tencent.mm";

 public void handleLoadPackage(LoadPackageParam pkg)
 {
  Log.d(TAG,"handleLoadPackage "+pkg.packageName+", "+Process.myPid()+", "+pkg.processName);
  if(WECHAT_PKG_NAME.equals(pkg.packageName)
   &&pkg.processName!=null
   &&pkg.processName.startsWith("com.tencent.mm:appbrand"))
  {
   try
   {
    Class<?> clazz=XposedHelpers.findClass("android.app.ActivityThread",null);
    Object obj=XposedHelpers.callStaticMethod(clazz,"currentActivityThread");
    Context context=(Context)XposedHelpers.callMethod(obj,"getSystemContext");
    
    String str=context.getPackageManager().getPackageInfo(pkg.packageName,0).versionName;
    Log.d(TAG,pkg.packageName+" "+str);
    if("6.6.1".equals(str))
    {
     Aa.hookTinkerApplicationOnCreate(pkg);
    }else if("6.6.2".equals(str))
    {
     Bb.a(pkg);
    }
   }catch(Throwable th)
   {
    Log.e(TAG,""+th);
   }
  }
 }
}
