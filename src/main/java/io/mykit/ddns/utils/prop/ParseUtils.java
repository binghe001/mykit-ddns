/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mykit.ddns.utils.prop;

import io.mykit.ddns.bean.DomainInfo;
import io.mykit.ddns.utils.common.ObjectUtils;
import io.mykit.ddns.utils.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author binghe
 * @version 1.0.0
 * @description 数据转换工具，将properties文件中的数据转换成DomainInfo列表信息
 */
public class ParseUtils {

    public static List<DomainInfo> parsePropData2DomainInfoList(String propPath){
        List<DomainInfo> list = new ArrayList<>();
        Set<Object> keys = PropLoad.getAllKeysFromPropertiesFile(propPath);
        if (keys == null || keys.isEmpty()){
            return list;
        }
        //循环遍历所有的Key
        for (Object key : keys){
            DomainInfo domainInfo = new DomainInfo();
            domainInfo.setTopDomain(key.toString());
            String value = PropLoad.getValueFromPropertiesFile(key.toString(), propPath);
            String[] values = ObjectUtils.splitString(value, Constants.SPLIT_REGEX);
            domainInfo.setChildDomainPrefix(values);
            list.add(domainInfo);
        }
        return list;
    }
}
