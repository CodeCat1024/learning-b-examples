// finished

package com.lrm.service;

import com.lrm.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

<<<<<<< HEAD
/**
 * Created by limi on 2017/10/16.
 */
=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

<<<<<<< HEAD
    List<Type> listTypeTop(Integer size);

    Type updateType(Long id,Type type);
=======
    Type updateType(Long id, Type type);
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2

    void deleteType(Long id);
}
