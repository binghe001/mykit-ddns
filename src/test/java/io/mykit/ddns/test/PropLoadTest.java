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
package io.mykit.ddns.test;

import io.mykit.ddns.utils.constants.Constants;
import io.mykit.ddns.utils.prop.PropLoad;
import io.mykit.ddns.utils.common.ObjectUtils;
import org.junit.Test;

import java.util.Set;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试文件加载
 */
public class PropLoadTest {

    @Test
    public void testPropLoad(){
        String propPath = "D:/Workspaces/mykit/mykit-ddns/mykit-ddns/src/main/resources/domains.properties";
        Set<Object> keys = PropLoad.getAllKeysFromPropertiesFile(propPath);
        for(Object key : keys){
            System.out.println(key.toString());
            String value = PropLoad.getValueFromPropertiesFile(key.toString(), propPath);
            String[] values = ObjectUtils.splitString(value,  Constants.SPLIT_REGEX);
            for (String v : values){
                System.out.println(v);
            }
        }
    }
}
