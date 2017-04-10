package cn.com.chenxin.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射的Utils函数集合. 提供访问私有变量,获取泛型类型Class,提取集合中元素的属性等Utils函数.
 * 
 * @author lei
 */
public class ReflectionUtils {

    private static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    /**
     * 根据类名，返回一个class对象，用于获取方法
     */
    public static Class<?> getClass(String clazzName) {
        try {
            return Class.forName(clazzName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据对象，返回一个class对象，用于获取方法
     */
    public static Class<?> getClass(Object obj) {
        try {
            return Class.forName(obj.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据对象，获取某个方法
     * 
     * @param obj
     *            对象
     * @param methodName
     *            方法名
     * @param parameterTypes
     *            该方法需传的参数类型，如果不需传参，则不传
     */
    public static Method getMethod(Object obj, String methodName, Class<?>... parameterTypes) {
        try {
            Method method = getClass(obj).getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String methodName, Class<?>... parameterTypes) {
        try {
            Method method = cls.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 直接传入对象、方法名、参数，即可使用该对象的隐藏方法
     * 
     * @param obj
     * @param methodName
     * @param parameter
     */
    public static Object invoke(Object obj, String methodName, Object... parameter) {
        Class<?>[] parameterTypes = new Class<?>[parameter.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = parameter[i].getClass();
        }
        try {
            return getMethod(obj, methodName, parameterTypes).invoke(obj, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 直接传入类名、方法名、参数，即可使用该对象的隐藏静态方法
     * 
     * @param cls
     * @param methodName
     * @param parameter
     */
    public static Object invoke(Class<?> cls, String methodName, Object... parameter) {
        Class<?>[] parameterTypes = new Class<?>[parameter.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = parameter[i].getClass();
        }
        try {
            return getMethod(cls, methodName, parameterTypes).invoke(null, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取父类方法
     * 
     * @param object
     * @param methodName
     * @param parameterTypes
     * @return
     * @throws NoSuchMethodException
     */
    public static Method getDeclaredMethodByInstance(Object object, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method method = null;
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {

            }
        }
        throw new NoSuchMethodException("没有该方法定义");
    }

    /**
     * 获取父类方法
     * 
     * @param object
     * @param methodName
     * @param parameterTypes
     * @return
     * @throws NoSuchMethodException
     */
    public static Method getDeclaredMethodByClazz(Class clazz, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, parameterTypes);
            return method;
        } catch (Exception e) {

        }
        throw new NoSuchMethodException("没有该方法定义");
    }

    /**
     * 关闭Thrift客户端连接
     * @param client	客户端对象
     * @throws NoSuchMethodException	没有close方法时抛出异常
     */
    public static void closeClient (Object client) throws NoSuchMethodException {
     //   client.getInputProtocol().getTransport().close();
        try {
            Method protocolMethod = getDeclaredMethodByInstance(client, "getInputProtocol");
            Object tProtocol = protocolMethod.invoke(client);
            
            Method transportMethod = getDeclaredMethodByInstance(tProtocol, "getTransport");
           Object transportObj= transportMethod.invoke(tProtocol);
            invoke(transportObj, "close");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
   }

}