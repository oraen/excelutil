package com.oraen.oxygen.excelutil.dataUtil;

import com.oraen.oxygen.excelutil.exception.AccessingEmptyException;
import com.oraen.oxygen.excelutil.exception.UnspecificException;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

public class CommonUtil {

   public static Class<?> getContentType(List<?> col) throws AccessingEmptyException {
      if(col.size() == 0){
         throw new AccessingEmptyException("容器没有任何存储的对象， 无法获取类型");
      }else{
         return col.get(0).getClass();
      }
   }



   public static<T> T create(Class<T> clazz) throws UnspecificException {

      try{
         T t = clazz.getDeclaredConstructor().newInstance();
         return t;
      }catch (NoSuchMethodException e){
         throw new UnspecificException("构建"+ clazz.getName() +"实例失败， 目标类不存在无参构造函数");
      }catch (IllegalAccessException e){
         throw new UnspecificException("构建"+ clazz.getName() +"实例失败， 没有权限访问目标类的无参构造函数");
      }catch (InvocationTargetException e){
         e.printStackTrace();
         throw new UnspecificException("构建"+ clazz.getName() +"实例失败， 无参构造函数调用时发生未捕获异常");
      }catch (InstantiationException e){
         throw new UnspecificException("构建"+ clazz.getName() +"实例失败， 目标类无法被实例化， 可能是抽象类或者接口");
      }

   }

   //NoSuchMethodException  没有空构函数
//java.lang.IllegalAccessException    空构函数的访问权限不够
//java.lang.reflect.InvocationTargetException  通过反射调用函数时候抛出了异常没有捕获  （这里是空构函数）
//java.lang.InstantiationException   要实例化的目标是接口或者抽象类
}
