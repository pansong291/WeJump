package pansong291.xposed.wejump;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTool
{
 public static String read(String fileName)throws Throwable
 {
  FileInputStream fileInputStream;
  try
  {
   fileInputStream=new FileInputStream(fileName);
   try
   {
    byte[] bArr = new byte[fileInputStream.available()];
    fileInputStream.read(bArr);
    String str2 = new String(bArr,"UTF-8");
    if(fileInputStream==null)
    {
     return str2;
    }
    try
    {
     fileInputStream.close();
     return str2;
    }catch(Exception e2)
    {
     e2.printStackTrace();
     return str2;
    }
   }catch(Exception e3)
   {
    try
    {
     e3.printStackTrace();
     if(fileInputStream!=null)
     {
      return null;
     }
     try
     {
      fileInputStream.close();
      return null;
     }catch(Exception e4)
     {
      e4.printStackTrace();
      return null;
     }
    }catch(Throwable th2)
    {
     if(fileInputStream!=null)
     {
      try
      {
       fileInputStream.close();
      }catch(Exception e22)
      {
       e22.printStackTrace();
      }
     }
     throw th2;
    }
   }
  }catch(Exception e5)
  {
   fileInputStream=null;
   e5.printStackTrace();
   if(fileInputStream!=null)
   {
    return null;
   }
   fileInputStream.close();
   return null;
  }catch(Throwable th3)
  {
   fileInputStream=null;
   if(fileInputStream!=null)
   {
    fileInputStream.close();
   }
   throw th3;
  }
 }

 public static void write(String fileName,String value)throws Throwable
 {
  FileOutputStream fileOutputStream;
  try
  {
   fileOutputStream=new FileOutputStream(fileName);
   try
   {
    fileOutputStream.write(value.getBytes());
    fileOutputStream.flush();
    if(fileOutputStream!=null)
    {
     try
     {
      fileOutputStream.close();
     }catch(Exception e2)
     {
      e2.printStackTrace();
     }
    }
   }catch(Exception e3)
   {
    try
    {
     e3.printStackTrace();
     if(fileOutputStream!=null)
     {
      try
      {
       fileOutputStream.close();
      }catch(Exception e22)
      {
       e22.printStackTrace();
      }
     }
    }catch(Throwable th2)
    {
     if(fileOutputStream!=null)
     {
      try
      {
       fileOutputStream.close();
      }catch(Exception e4)
      {
       e4.printStackTrace();
      }
     }
     throw th2;
    }
   }
  }catch(Exception e5)
  {
   fileOutputStream=null;
   e5.printStackTrace();
   if(fileOutputStream!=null)
   {
    fileOutputStream.close();
   }
  }catch(Throwable th3)
  {
   fileOutputStream=null;
   if(fileOutputStream!=null)
   {
    fileOutputStream.close();
   }
   throw th3;
  }
 }
}
