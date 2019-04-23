package com.chenmin.factory1;

import com.chenmin.factory1.service.People;
import com.chenmin.factory1.service.impl.ErrorPeople;
import com.chenmin.factory1.utils.ApplicationContextUtils;
import org.springframework.stereotype.Service;

@Service
public class PeopleFactory {

    public People getBean(String name){
        try {
            return (People) ApplicationContextUtils.getBean(name);
        }catch (Exception e){
            return new ErrorPeople();
        }
    }
}
