package pansong291.xposed.wejump;

import android.app.Activity;
import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Aa
{
 private static boolean changedGame = false;
 private static boolean outGameJs2File = true;

 // $FF: synthetic method
 static boolean isChangedGame()
 {
  return changedGame;
 }

 // $FF: synthetic method
 static boolean setChangedGame(boolean var0)
 {
  changedGame=var0;
  return var0;
 }

 // $FF: synthetic method
 static boolean isOutGameJs2File()
 {
  return outGameJs2File;
 } 
 
 public static void hookTinkerApplicationOnCreate(LoadPackageParam pkg)
 {
  try
  {
   XposedHelpers.findAndHookMethod(
   "com.tencent.tinker.loader.app.TinkerApplication",
   pkg.classLoader,
   "onCreate",
   new XC_MethodHook()
   {
     protected void afterHookedMethod(MethodHookParam methodHookParam)throws Throwable
     {
      Application application=(Application)methodHookParam.thisObject;
      Log.d("JumpHook","com.tencent.tinker.loader.app.TinkerApplication.onCreate "+application.getClassLoader());
      if(loadClassMmPlugin(application.getClassLoader()))
      {
       hookPluginMethod_a(application.getClassLoader());
      }else
      {
       hookActivityOnCreate(application.getClassLoader());
      }
     }
   });
  }catch(Throwable var2)
  {
   Log.d("JumpHook",""+var2);
  }

 }

 protected static String replaceGameJS(String str0)
 {
  int index2 = str0.indexOf("this.combo=new ");
  int index4 = str0.indexOf("d.GAME");
  int index6 = str0.indexOf("scene.add");
  int index3 = str0.indexOf("this.renderer.render(this.scene,this.camera)");
  int index7 = str0.indexOf("bottle.status");
  int index5 = str0.indexOf("mouseDownTime");
  int index8 = str0.indexOf("d.BOTTLE");
  String str9 =null;
  int index1;
  if(index2!=-1)
  {
   index1=str0.indexOf(".","this.combo=new ".length()+index2);
   str9=null;
   if(index1!=-1)
   {
    str9=str0.substring("this.combo=new ".length()+index2,index1);
    Log.d("JumpHook","hookConfusedJs className ..."+str9+"...");
    str9.trim();
   }
  }

  index1=-1;
  if(!TextUtils.isEmpty(str9))
  {
   index1=str0.indexOf(str9+".Mesh");
  }

  Log.d("JumpHook","hookConfusedJs  ---index1 "+index2+", "+index4+", "+index6+", "+index3+", "+index7+", "+index5+", "+index8+", "+index1+", ..."+str9+"...");
  if(!TextUtils.isEmpty(str9)&&index2!=-1&&index4!=-1&&index6!=-1&&index3!=-1&&index7!=-1&&index5!=-1&&index8!=-1&&index1!=-1)
  {
   str9="this.vectorHelperOne=new "
       +str9+".Vector2(0, 0);this.vectorHelperTwo=new "
       +str9+".Vector2(0, 0);this.helperLine=new "
       +str9+".Line();this.helperLine.material.color.setHex(0x0000ff);var pointsOfHelperLine=new Float32Array(6);this.helperLine.geometry.addAttribute(\"position\",new "
       +str9+".BufferAttribute(pointsOfHelperLine,3));this.helperLine.geometry.attributes.position.setDynamic(true);this.helperLine.name=\"helper_line\";this.scene.add(this.helperLine);this.helperArrow=new "
       +str9+".Mesh(new "+str9+".CircleGeometry(.6, 50),new "
       +str9+".MeshBasicMaterial({color: 255}));this.helperArrow.name=\"helper_arrow\";this.helperArrow.position.x=-500;this.helperArrow.rotation.x=-Math.PI/2;this.scene.add(this.helperArrow);";
   str0=str0.substring(0,index2)+str9+str0.substring(index2,str0.length());
   index1=str0.indexOf("this.renderer.render(this.scene,this.camera)");
   str0=str0.substring(0,index1)
       +"if(\"prepare\" == this.bottle.status) {var i=(Date.now()-this.mouseDownTime)/1e3;var vz=Math.min(i*d.BOTTLE.velocityZIncrement,150);vz=+vz.toFixed(2);var vy=Math.min(d.BOTTLE.velocityY+i*d.BOTTLE.velocityYIncrement,180);vy=+vy.toFixed(2);this.vectorHelperOne.set(this.nextBlock.obj.position.x-this.bottle.obj.position.x,this.nextBlock.obj.position.z-this.bottle.obj.position.z);this.vectorHelperOne.x=+this.vectorHelperOne.x.toFixed(2);this.vectorHelperOne.y=+this.vectorHelperOne.y.toFixed(2);var r=vy/d.GAME.gravity*2;var n=this.bottle.obj.position.y.toFixed(2);var a=d.BLOCK.height/2-n;r=+(r-=+((-vy+Math.sqrt(Math.pow(vy,2)-2*d.GAME.gravity*a))/-d.GAME.gravity).toFixed(2)).toFixed(2);var s=[];this.vectorHelperTwo.set(this.bottle.obj.position.x,this.bottle.obj.position.z);var l=this.vectorHelperOne.setLength(vz * r);this.vectorHelperTwo.add(l);s.push(+this.vectorHelperTwo.x.toFixed(2),+this.vectorHelperTwo.y.toFixed(2));this.helperArrow.position.set(s[0],this.nextBlock.obj.position.y+d.BLOCK.height/2+.15,s[1]);var array=this.helperLine.geometry.attributes.position.array;array[0]=this.currentBlock.obj.position.x;array[1]=this.currentBlock.obj.position.y+d.BLOCK.height/2+.15;array[2]=this.currentBlock.obj.position.z;array[3]=s[0];array[4]=this.nextBlock.obj.position.y+d.BLOCK.height/2+.15;array[5]=s[1];this.helperLine.geometry.computeBoundingSphere();this.helperLine.geometry.attributes.position.needsUpdate=true;}else{this.helperArrow.position.set(-300,0,0);var array=this.helperLine.geometry.attributes.position.array;array[0]=-300;array[1]=0;array[2]=0;array[3]=-500;array[4]=0;array[5]=0;this.helperLine.geometry.computeBoundingSphere();this.helperLine.geometry.attributes.position.needsUpdate = true;}"
       +str0.substring(index1,str0.length());
  }else
  {
   str0=null;
  }

  return str0;
 }

 private static void hookActivityOnCreate(ClassLoader var0)
 {
  try
  {
   XposedHelpers.findAndHookMethod(
   "android.app.Activity",
   var0,
   "onCreate",
   new XC_MethodHook()
   {
     protected void beforeHookedMethod(MethodHookParam methodHookParam)throws Throwable
     {
      Activity activity = (Activity) methodHookParam.thisObject;
      Log.d("JumpHook","onCreate "+activity+", "+activity.getClassLoader());
      if(!isChangedGame()&&loadClassMmPlugin(activity.getClassLoader()))
      {
       hookPluginMethod_a(activity.getClassLoader());
       setChangedGame(true);
      }
     }
   });
  }catch(Throwable var2)
  {
   Log.d("JumpHook",""+var2);
  }

 }

 private static boolean loadClassMmPlugin(ClassLoader var0)
 {
  try
  {
   var0.loadClass("com.tencent.mm.plugin.appbrand.appcache.ai");
   var0.loadClass("com.tencent.mm.plugin.appbrand.e");
  }catch(Exception var2)
  {
   Log.d("JumpHook",""+var2);
   return false;
  }
  return true;
 }

 protected static void hookPluginMethod_a(ClassLoader var0)
 {
  try
  {
   XposedHelpers.findAndHookMethod(
   "com.tencent.mm.plugin.appbrand.appcache.ai",
   var0,
   "a",
   "com.tencent.mm.plugin.appbrand.e",
   String.class,
   new XC_MethodHook()
   {
     protected void afterHookedMethod(MethodHookParam methodHookParam)throws Throwable
     {
      Log.d("JumpHook","a ------------- args "+methodHookParam.args[0]+", "+methodHookParam.args[1]);
      if(MySharedPreference.opBoolean()&&methodHookParam.args[0]!=null)
      {
       Object objectField = XposedHelpers.getObjectField(methodHookParam.args[0],"hMz");
       if(objectField!=null)
       {
        if(!"wx7c8d593b2c3a7703".equals((String) XposedHelpers.getObjectField(objectField,"appId"))
         ||!"game.js".equals((String) methodHookParam.args[1]))
        {
         return;
        }
        CharSequence cs;
        String path_game_js=Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+methodHookParam.args[1];
        if(isOutGameJs2File())
        {
         Log.d("JumpHook","a1 ------------- filePath "+path_game_js);
         FileTool.write(path_game_js,(String) methodHookParam.getResult());
//         cs=FileTool.read("/sdcard/new.js");
//         if(!TextUtils.isEmpty(cs))
//         {
//          methodHookParam.setResult(cs);
//          return;
//         }
//         return;
        }
        String str2=(String) methodHookParam.getResult();
        if(!TextUtils.isEmpty(str2))
        {
         cs=replaceGameJS(str2);
         if(!TextUtils.isEmpty(cs))
         {
          FileTool.write(path_game_js.replace("game.js","new.js"),cs.toString());
          methodHookParam.setResult(cs);
         }
        }
       }
      }
     }
   });
  }catch(Throwable var3)
  {
   Log.d("JumpHook",""+var3);
  }

 }


 // Inner Class

}
