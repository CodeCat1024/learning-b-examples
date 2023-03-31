<<<<<<< HEAD
// finished

=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
package com.lrm.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
/**
 * Created by limi on 2017/10/21.
 */
public class MyBeanUtils {


=======
public class MyBeanUtils {

>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
    /**
     * 获取所有的属性值为空属性名数组
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds =  beanWrapper.getPropertyDescriptors();
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            if (beanWrapper.getPropertyValue(propertyName) == null) {
                nullPropertyNames.add(propertyName);
            }
        }
        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }
<<<<<<< HEAD

=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
}
