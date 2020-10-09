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
package io.mykit.ddns.utils.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @author binghe
 * @version 1.0.0
 * @description Json工具类
 */
public class JsonUtils {

    /**
     * 将Json字符串转化为T对象
     */
    public static <T> T json2Bean(String json, Class<T> clazz){
        JSONObject jsonObject = JSONObject.parseObject(json);
        T obj = jsonObject.toJavaObject(clazz);
        return obj;
    }

    /**
     * 将对象转化为字符串
     */
    public static String bean2Json(Object obj){
        return JSONObject.toJSONString(obj);
    }
}
