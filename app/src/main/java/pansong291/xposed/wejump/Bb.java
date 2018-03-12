package pansong291.xposed.wejump;

import android.app.Activity;
import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Bb {
 private static boolean a = false;
 private static boolean b = false;

 static String a(String var0) {
  return b(var0);
 }

 public static void a(LoadPackageParam var0) {
  try {
   ClassLoader var1 = var0.classLoader;
   b$1 var3 = new b$1();
   XposedHelpers.findAndHookMethod("com.tencent.tinker.loader.app.TinkerApplication", var1, "onCreate", new Object[]{var3});
  } catch (Throwable var2) {
   Log.d("JumpHook", "" + var2);
  }

 }

 // $FF: synthetic method
 static boolean a() {
  return a;
 }

 // $FF: synthetic method
 static boolean a(ClassLoader var0) {
  return e(var0);
 }

 // $FF: synthetic method
 static boolean a(boolean var0) {
  a = var0;
  return var0;
 }

 private static String b(String var0) {
  int var4 = var0.indexOf("this.combo=new ");
  int var2 = var0.indexOf("d.GAME");
  int var3 = var0.indexOf("scene.add");
  int var7 = var0.indexOf("this.renderer.render(this.scene,this.camera)");
  int var8 = var0.indexOf("bottle.status");
  int var5 = var0.indexOf("mouseDownTime");
  int var6 = var0.indexOf("d.BOTTLE");
  Object var10 = null;
  String var9 = (String)var10;
  int var1;
  if (var4 != -1) {
   var1 = var0.indexOf(".", "this.combo=new ".length() + var4);
   var9 = (String)var10;
   if (var1 != -1) {
    var9 = var0.substring("this.combo=new ".length() + var4, var1);
    Log.d("JumpHook", "hookConfusedJs className ..." + var9 + "...");
    var9.trim();
   }
  }

  var1 = -1;
  if (!TextUtils.isEmpty(var9)) {
   var1 = var0.indexOf(var9 + ".Mesh");
  }

  Log.d("JumpHook", "hookConfusedJs  ---index1 " + var4 + ", " + var2 + ", " + var3 + ", " + var7 + ", " + var8 + ", " + var5 + ", " + var6 + ", " + var1 + ", ..." + var9 + "...");
  if (!TextUtils.isEmpty(var9) && var4 != -1 && var2 != -1 && var3 != -1 && var7 != -1 && var8 != -1 && var5 != -1 && var6 != -1 && var1 != -1) {
   var9 = "this.vectorHelperOne=new " + var9 + ".Vector2(0, 0);this.vectorHelperTwo=new " + var9 + ".Vector2(0, 0);this.helperLine=new " + var9 + ".Line();this.helperLine.material.color.setHex(0x0000ff);var pointsOfHelperLine=new Float32Array(6);this.helperLine.geometry.addAttribute(\"position\",new " + var9 + ".BufferAttribute(pointsOfHelperLine,3));this.helperLine.geometry.attributes.position.setDynamic(true);this.helperLine.name=\"helper_line\";this.scene.add(this.helperLine);this.helperArrow=new " + var9 + ".Mesh(new " + var9 + ".CircleGeometry(.6, 50),new " + var9 + ".MeshBasicMaterial({color: 255}));this.helperArrow.name=\"helper_arrow\";this.helperArrow.position.x=-500;this.helperArrow.rotation.x=-Math.PI/2;this.scene.add(this.helperArrow);";
   var0 = var0.substring(0, var4) + var9 + var0.substring(var4, var0.length());
   var1 = var0.indexOf("this.renderer.render(this.scene,this.camera)");
   var0 = var0.substring(0, var1) + "if(\"prepare\" == this.bottle.status) {var i=(Date.now()-this.mouseDownTime)/1e3;var vz=Math.min(i*d.BOTTLE.velocityZIncrement,150);vz=+vz.toFixed(2);var vy=Math.min(d.BOTTLE.velocityY+i*d.BOTTLE.velocityYIncrement,180);vy=+vy.toFixed(2);this.vectorHelperOne.set(this.nextBlock.obj.position.x-this.bottle.obj.position.x,this.nextBlock.obj.position.z-this.bottle.obj.position.z);this.vectorHelperOne.x=+this.vectorHelperOne.x.toFixed(2);this.vectorHelperOne.y=+this.vectorHelperOne.y.toFixed(2);var r=vy/d.GAME.gravity*2;var n=this.bottle.obj.position.y.toFixed(2);var a=d.BLOCK.height/2-n;r=+(r-=+((-vy+Math.sqrt(Math.pow(vy,2)-2*d.GAME.gravity*a))/-d.GAME.gravity).toFixed(2)).toFixed(2);var s=[];this.vectorHelperTwo.set(this.bottle.obj.position.x,this.bottle.obj.position.z);var l=this.vectorHelperOne.setLength(vz * r);this.vectorHelperTwo.add(l);s.push(+this.vectorHelperTwo.x.toFixed(2),+this.vectorHelperTwo.y.toFixed(2));this.helperArrow.position.set(s[0],this.nextBlock.obj.position.y+d.BLOCK.height/2+.15,s[1]);var array=this.helperLine.geometry.attributes.position.array;array[0]=this.currentBlock.obj.position.x;array[1]=this.currentBlock.obj.position.y+d.BLOCK.height/2+.15;array[2]=this.currentBlock.obj.position.z;array[3]=s[0];array[4]=this.nextBlock.obj.position.y+d.BLOCK.height/2+.15;array[5]=s[1];this.helperLine.geometry.computeBoundingSphere();this.helperLine.geometry.attributes.position.needsUpdate=true;}else{this.helperArrow.position.set(-300,0,0);var array=this.helperLine.geometry.attributes.position.array;array[0]=-300;array[1]=0;array[2]=0;array[3]=-500;array[4]=0;array[5]=0;this.helperLine.geometry.computeBoundingSphere();this.helperLine.geometry.attributes.position.needsUpdate = true;}" + var0.substring(var1, var0.length());
  } else {
   var0 = null;
  }

  return var0;
 }

 // $FF: synthetic method
 static void b(ClassLoader var0) {
  f(var0);
 }

 // $FF: synthetic method
 static boolean b() {
  return b;
 }

 // $FF: synthetic method
 static void c(ClassLoader var0) {
  d(var0);
 }

 private static void d(ClassLoader var0) {
  try {
   b$2 var1 = new b$2();
   XposedHelpers.findAndHookMethod("android.app.Activity", var0, "onCreate", new Object[]{var1});
  } catch (Throwable var2) {
   Log.d("JumpHook", "" + var2);
  }

 }

 private static boolean e(ClassLoader var0) {
  boolean var1;
  try {
   var0.loadClass("com.tencent.mm.plugin.appbrand.appcache.ah");
   var0.loadClass("com.tencent.mm.plugin.appbrand.e");
  } catch (Exception var2) {
   Log.d("JumpHook", "" + var2);
   var1 = false;
   return var1;
  }

  var1 = true;
  return var1;
 }

 private static void f(ClassLoader var0) {
  try {
   Class var1 = var0.loadClass("com.tencent.mm.plugin.appbrand.e");
   b$3 var2 = new b$3();
   XposedHelpers.findAndHookMethod("com.tencent.mm.plugin.appbrand.appcache.ah", var0, "a", new Object[]{var1, String.class, var2});
  } catch (Throwable var3) {
   Log.d("JumpHook", "" + var3);
  }

 }
 
 
 //Inner Class
 
static class b$1 extends XC_MethodHook {
 b$1() {
 }

 protected void afterHookedMethod(MethodHookParam methodHookParam)throws Throwable {
  Application application = (Application) methodHookParam.thisObject;
  Log.d("JumpHook", "com.tencent.tinker.loader.app.TinkerApplication.onCreate " + application.getClassLoader());
  if (a(application.getClassLoader())) {
   b(application.getClassLoader());
  } else {
   c(application.getClassLoader());
  }
 }
 }
 
static class b$2 extends XC_MethodHook {
 b$2() {
 }

 protected void beforeHookedMethod(MethodHookParam methodHookParam)throws Throwable {
  Activity activity = (Activity) methodHookParam.thisObject;
  Log.d("JumpHook", "onCreate " + activity + ", " + activity.getClassLoader());
  if (!a() && a(activity.getClassLoader())) {
   b(activity.getClassLoader());
   a(true);
  }
 }
 }
 
static class b$3 extends XC_MethodHook {
 b$3() {
 }

 protected void afterHookedMethod(MethodHookParam methodHookParam)throws Throwable {
  Log.d("JumpHook", "a ------------- args " + methodHookParam.args[0] + ", " + methodHookParam.args[1]);
  if (MySharedPreference.opBoolean() && methodHookParam.args[0] != null) {
   Object objectField = XposedHelpers.getObjectField(methodHookParam.args[0], "iqw");
   if (objectField != null) {
    if (!"wx7c8d593b2c3a7703".equals((String) XposedHelpers.getObjectField(objectField, "appId")) || !"game.js".equals((String) methodHookParam.args[1])) {
     return;
    }
    if (b()) {
     String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + methodHookParam.args[1];
     Log.d("JumpHook", "a0 ------------- filePath " + str);
     FileTool.write(str, (String) methodHookParam.getResult());
     if (!TextUtils.isEmpty(FileTool.read("/sdcard/game662.js"))) {
      Log.d("JumpHook", "a0 ------------- changeJs " + objectField);
      methodHookParam.setResult(objectField);
      return;
     }
     return;
    }
    String str2 = (String) methodHookParam.getResult();
    if (!TextUtils.isEmpty(str2)) {
     CharSequence a = a(str2);
     if (!TextUtils.isEmpty(a)) {
      methodHookParam.setResult(a);
     }
    }
   }
  }
 }
 }
}
